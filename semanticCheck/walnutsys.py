import inspect
import os

from walnut.WalnutAstBuilder import Coord

def sys_coord(n=1):
    """when python code builds ast nodes using the Ast() constructor,
        calling this function as coord=sys_coord() ensures that the
        ast node's coordinates indicates the relevant line in the
        python code.

        Returning the line # in the python file results in different
        coord's when the python file changes.  This breaks regression
        tests.  It may be better to pass in a label and have the coord
        reflect that label instead, but that will break code which
        expects line # to be an integer.
    """
    info = inspect.stack()[n]  #0: this frame; 1: caller's frame
    path, lineN = os.path.basename(info.filename), info.lineno
    return Coord(path, lineN, 0)
