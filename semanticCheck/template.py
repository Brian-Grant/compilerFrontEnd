import os
import sys

from walnut.walnut_parse import parse_string

from walnutsys import sys_coord

# allow parsing snippets of walnut code with $holes in them which
# are filled in with provided ast's.  Provides a less painful
# alternative to construction ast's manually.

class Template:

    @staticmethod
    def substitute(non_terminal, template, template_dict):
        """return ast corresponding to the walnut source code template parsed
            as non_terminal with all occurrences of the $KEY replaced
            by the precomputed ast from template_dict[KEY]
        """
        #set up artificial source path to indicate caller's location
        path = str(sys_coord(2))
        n_errors, ast = parse_string(path, template, non_terminal,
                                     template_dict)
        if n_errors > 0:
            sys.stderr.write('INTERNAL ERROR: template parse has %d errors' %
                             n_errors)
        return ast
