from walnut.ast import Ast

from walnutsys import sys_coord
from classtype import ClassType
from splits import Splits


class ArrayType(ClassType):
    def __init__(self, element_type, rank):
        super().__init__(element_type, 'Array', sys_coord(),
                         Splits(Ast('CLASS', [])), rank)
        assert(rank > 0)

    def is_subtype_of(self, supertype):
        """return true iff self is a sub-type of supertype"""
        return self.name == supertype.name and self.rank == supertype.rank
