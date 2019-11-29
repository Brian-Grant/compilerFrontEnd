from checker import checker

def is_multi_def(env, name, coord):
    """Given an env for which env.get(name) returns falsy if name is not
       found, signal a MULTI_DEF error if name already exists in env
    """
    info = env.get(name)
    if info:
        msg = '%s already defined at %s' % (name, info.coord)
        checker.errors.add(coord, 'MULTI_DEF', msg)
        return True
    return False
