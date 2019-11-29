# An extension of python's dict.  Overrides get and [] to return None
# on failure,

class Env(dict):
    """Extends dictionary for mapping string keys to some kind of info
       object.  Only difference is that looking up a non-existent key
       using [] or get() returns None.
    """

    def __init__(self):
        super().__init__()

    def get(self, key):
        """returns info for key in this if its there; else return None"""
        return super().get(key, None)

    def __getitem__(self, key):
        """returns info for key if its there; else return None.
           Implements [] indexing operator.
        """
        return self.get(key)
