from collections import namedtuple
import copy

from walnut.ast import Ast

from classchecker import ClassChecker
from arrayinit import new_array
from checker import checker
import constants
from env import Env
from type import Type

# Tracks information about classes.  Contains code to check
# and transform top-level of classes.
#
# Given a ClassType instance c, an important method is c.get(name)
# which returns the information associated with name in c or one
# of its parent classes.

class ClassType(Type):
    #if split out into a ClassInfo and ClassType could avoid circular
    #self.type = self below
    def __init__(self, name, super_name, coord, splits, rank=0):
        super().__init__(name, 'class', rank)
        self.coord = coord
        self.type = self
        self.parent = super_name
        self.constructors = splits.constructors
        self.fns = splits.fns
        self.methods = splits.methods
        self.static_decls = splits.static_decls
        self.instance_decls = splits.instance_decls
        self.depth = -1
        self.env = Env()


    def get(self, key):
        """returns info for key if its there; else return None.
           Follows inheritance hierarchy.  Implements [] indexing
           operator.
        """
        c = self
        info = None
        while not info and c :
            info = c.env.get(key)
            parent = c.parent
            c = checker.types.get(parent) if parent else None
        return info

    def put(self, key, info):
        """implements []= index assignment operator"""
        self.env[key] = info

    def is_subtype_of(self, supertype):
        """return true iff self is a sub-type of supertype"""
        assert(self.rank == 0)
        assert(supertype.rank == 0)
        assert(self.kind == 'class')
        if supertype.kind != 'class': return False
        c, name = self.name, supertype.name
        while c and c != name:
            cInfo = checker.types.get(c)
            if not cInfo: return False
            assert(cInfo.kind == 'class')
            c = cInfo.parent
        return not not c

    def ast(self):
        """return a reconstructed ast for class"""
        asts = (
            self.instance_decls +
            self.static_decls +
            #self.constructors +
            self.fns +
            self.methods
        )
        return Ast('CLASS', asts, type_name=self.name, super_name=self.parent,
                   coord=self.coord)

    def instance_init_name(self):
        return '%s_%s' % (constants.SELF_INIT, self.name)


    def check_and_xform(self):
        ClassChecker(self).check_and_xform()
