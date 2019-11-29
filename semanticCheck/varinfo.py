# simple struct for static and instance fields.  No behavior.

class VarInfo:
    """abstract class for static and instance fields and local vars"""
    def __init__(self, name, kind, isConst, isStatic, type, coord):
        self.name = name
        self.kind = kind
        self.isConst = isConst
        self.isStatic = isStatic
        self.type = type
        self.coord = coord

class InstanceFieldInfo(VarInfo):
    def __init__(self, name, isConst, type, coord):
        super().__init__(name, 'instance', isConst, False, type, coord)

class StaticFieldInfo(VarInfo):
    def __init__(self, name, isConst, type, coord):
        super().__init__(name, 'static', isConst, True, type, coord)

class LocalInfo(VarInfo):
    def __init__(self, name, isConst, type, coord):
        super().__init__(name, 'local', isConst, False, type, coord)
