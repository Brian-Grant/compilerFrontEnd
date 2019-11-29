#!/usr/bin/env python3

from collections import namedtuple
import copy, re, sys

from walnut.ast import Ast

from classtype import ClassType
from codechecker import CodeChecker
import constants
from checker import checker
from errors import Errors
from functioninfo import FunctionInfo
from mainclass import MainClass
from splits import Splits
from walnutsys import sys_coord
from util import is_multi_def
from toptypes import TopTypes
from type import NilType, PrimitiveType

# top-level of semantic checker which provides behavior
# (note that checker simply provides a global variable to
# access important data-structures like types, without any
# interesting behavior; all behavior is implemented here).

PREDEF_CLASSES = [
    Ast('CLASS', [], type_name=constants.OBJECT, super_name=None,
        coord=sys_coord()),
    #Ast('CLASS', [], type_name='System', super_name=None, coord=sys_coord()),
]

PREDEF_TYPES = [ 'Int', 'Real', 'String', 'Void',  ]

class SemanticChecker:
    def __init__(self):
        checker.types = TopTypes()
        checker.errors = Errors()
        for ast in PREDEF_CLASSES:
            checker.types.put(ast.type_name, self.make_class_info(ast))
        for name in PREDEF_TYPES:
            checker.types.put(name, PrimitiveType(name))
        nilType = NilType()
        checker.types.put(nilType.name, nilType)

    def make_class_info(self, ast):
        name, super_name, coord = ast.type_name, ast.super_name, ast.coord
        return ClassType(name, super_name, coord, Splits(ast))

    def check_and_xform(self, ast):
        assert(ast.tag == 'PROGRAM')
        self.coord = ast.coord
        splits = Splits(ast)
        self.class_names = []

        #wrap top-level code into $Main class
        main_class = MainClass(splits)
        checker.types.put(main_class.name, main_class)
        self.class_names.append(main_class.name)

        #check class headers
        for ast in splits.classes:
            assert(ast.tag == 'CLASS')
            if not is_multi_def(checker.types, ast.type_name, ast.coord):
                name = ast.type_name
                self.class_names.append(name)
                info = self.make_class_info(ast)
                checker.types.put(name, info)
        self.supers_check()

        #order class names by depth in inheritance hierarchy
        self.class_names = (
            sorted(self.class_names,
                   key = lambda c : checker.types.get(c).depth)
        )

        #semantic check top-level of each class
        for name in self.class_names:
            info = checker.types.get(name)
            assert(info.kind == 'class')
            info.check_and_xform()

        #semantic check function bodies within each class
        code_checker = CodeChecker()
        for name in self.class_names:
            info = checker.types.get(name)
            assert(info.kind == 'class')
            code_checker.check_and_xform(info)

        return self.xformed_ast()

    def xformed_ast(self):
        """returns transformed ast for entire program"""
        asts = [ checker.types.get(c).ast() for c in self.class_names ]
        return Ast('PROGRAM', asts, coord=self.coord)

    def supers_check(self):
        """ ensure super-classes are declared and check for inheritance loops
        """
        for class_name in self.class_names:
            info = checker.types.get(class_name)
            assert(info.kind == 'class')
            name, parent = info.name, info.parent
            if parent and not checker.types.get(parent):
                msg = 'undefined super class %s for class %s' % (parent, name)
                checker.errors.add(info.coord, 'UNDEF', msg)
                info.parent = constants.OBJECT

        for class_name in self.class_names:
            info = checker.types.get(class_name)
            assert(info.kind == 'class')
            name, parent = info.name, info.parent
            ancestors = []
            while parent:
                ancestors.append(parent)
                if parent == name:
                    ancs = '->'.join(ancestors)
                    msg = ('circular inheritance %s->%s; ' % (name, ancs) +
                           'setting parent to %s' % constants.OBJECT)
                    checker.errors.add(info.coord, 'CIRCULAR', msg)
                    parent = constants.OBJECT
                    info.parent = parent
                    ancestors = [parent]
                parent = checker.types.get(parent).parent
            info.depth = len(ancestors)
