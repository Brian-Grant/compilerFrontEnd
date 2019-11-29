import re

from walnut.ast import Ast

from arraytype import ArrayType
import constants
from env import Env
from type import Type

# Keep track of all object types (primitive, class types and array types,
# not function types).  Provides a TopTypes class which is the class of
# checker.types which provides global access to the object types.

class TopTypes:
    """all object types (not function types) should land up here.  """

    def __init__(self):
        self.env = Env()

    def get(self, name, rank=0):
        """ return entry stored for base type name, rank.  If rank > 0 and entry
            is not found, then a new array type is created provided
            base name exists.
        """
        type = self.env.get(Type.make_type_id(name, rank))
        if type == None and rank > 0:
            base_type = self.get(name)
            if base_type:
                info = ArrayType(name, rank)
                type = self.put(name, info, rank)
        return type

    def put(self, name, info, rank=0):
        #info must be a Type
        assert(info.name == name)
        assert(info.rank == rank)
        id = info.type_id()
        self.env[id] = info
        return info

    def get_by_type_id(type_id):
        return self.env.get(type_id)

    def error(self): return Type.ERROR
