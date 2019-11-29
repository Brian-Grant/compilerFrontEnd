import constants
from walnutsys import sys_coord

# Each object type extends the abstract Type class defined below.
class Type:
    """
    Abstract class for object types.
    """

    def __init__(self, name, kind, rank=0):
        self.name = name
        self.kind = kind
        self.rank = rank

    def is_subtype_of(self, supertype):
        return self == supertype

    def is_array_type(self):
        return self.rank > 0

    def __str__(self):
        return self.name + '[]'*self.rank

    def type_id(self):
        return (
            self.name if self.rank == 0 else ('%s$%d' % (self.name, self.rank))
        )

    def is_error(self):
        return self.name == constants.ERROR

    @staticmethod
    def make_type_id(name, rank=0):
        return name if rank == 0 else ('%s$%d' % (name, rank))

class PrimitiveType(Type):
    def __init__(self, name):
        super().__init__(name, 'primitive')
        self.type = self
        self.coord = sys_coord()

class NilType(Type):
    def __init__(self):
        super().__init__(constants.NIL_TYPE, 'nil')
        self.type = self
        self.coord = sys_coord()

    def is_subtype_of(self, supertype):
        return supertype.kind == 'class'

class ErrorType(Type):
    def __init__(self):
        super().__init__(constants.ERROR, 'error')
        self.type = self

    def is_error(self):
        return True

Type.ERROR = ErrorType()
