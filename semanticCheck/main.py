#!/usr/bin/env python3

import copy, os, sys

COURSE_LIB = os.environ['HOME'] + '/cs572/lib'
if COURSE_LIB not in sys.path: sys.path.extend([COURSE_LIB])

from checker import checker
from linearize import Linearizer
from walnut.walnut_parse import parse_paths
from walnut.sys import WalnutSys

from semchk import SemanticChecker

# command-line driver for semantic checker

def go(paths, opts):
    (n_errors, ast) = parse_paths(paths)
    if n_errors == 0:
        (n_errors, sem_ast) = semchk(ast)
        if n_errors == 0:
            if len(opts['c']) > 0: sem_ast = filter_classes(sem_ast, opts['c'])
            if opts['o']: out_formats(sem_ast, opts['o'], O_FMTS)
            if opts['l']: out_formats(sem_ast, opts['l'], L_FMTS)
    return n_errors

O_FMTS = {
    'text': lambda ast: ast.text,
    'dot': lambda ast: ast.dot,
    'xml': lambda ast: ast.xml,
}
L_FMTS = {
    'lin': lambda ast: Linearizer(ast).linearize
}
def out_formats(ast, base_path, fmts):
    for (fmt, fn) in fmts.items():
        dest_path = base_path + '.' + fmt
        with open(dest_path, 'w') as f:
                s = fn(ast)()
                f.write(s)


def filter_classes(sem_ast, classes):
    kids = []
    for k in sem_ast.kids:
        if k.type_name in classes: kids.append(k)
    if len(kids) == 0:
        sys.stderr.write('could not find classes %s' % classes)
        sys.exit(1)
    copy_ast = copy.copy(sem_ast)
    copy_ast.kids = kids
    return copy_ast

#Return pair containing # of semantic errors detected and
#transformed ast.
def semchk(ast) :
    sem_ast = SemanticChecker().check_and_xform(ast)
    sys.stderr.write(str(checker.errors))
    return (len(checker.errors), sem_ast)

def main(argv):
    argv = sys.argv + WalnutSys.sys_files()
    paths, classes = [], []
    opts = {
        'c': [],
        'o': '',
        'l': '',
    }
    i = 1
    while i < len(argv):
        arg = argv[i]
        i = i + 1
        if arg in [ '-o', '-c', '-l' ]:
            if i == len(argv):
                sys.stderr.write('%s must be followed by a value' % arg)
                sys.exit(1)
            val = argv[i]
            i = i + 1
            if arg == '-c':
                opts['c'].append(val)
            else:
                opts[arg[1:]] = val
        elif arg.startswith('-'):
            sys.stderr.write('unknown option %s\n' % arg)
            usage()
        else:
            paths.append(arg)
    if len(paths) == 0:
        sys.stderr.write('one or more paths must be specified')
        usage()
    n_errors = go(paths, opts)
    sys.exit(n_errors != 0)

def usage():
    stderr = sys.stderr
    stderr.write(('usage: %s [-c class] [-o out] [-l out] ' +
                 'WALNUT_FILE|- ...\n') % (sys.argv[0]))
    stderr.write('-c class only output class (can have multiple -c)\n')
    stderr.write('-l out outputs linearized ast in files out.lin\n')
    stderr.write('-o out generates ast in files out.xml, ' +
                 'out.dot, out.text\n')
    sys.exit(1)

if __name__ == '__main__':
    if len(sys.argv) < 2:
        usage()
    else:
        main(sys.argv)
