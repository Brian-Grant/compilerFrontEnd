import re


# Creates a global variable checker which provides easy access to the
# entire semantic checker.  Import as `from checker import checker`.
#
# checker.types:      returns all top-level types which includes all
#                     top-level classes.
# checker.errors:     errors object used for reporting errors using
#                     checker.errors.add().
# checker.new_temp(): used for creating new temporary variables.

class Checker:
    def __init__(self):
        self.errors = None
        self.types = None
        self.next_temp = 0

    def new_temp(self):
        temp = '$t%d' % self.next_temp
        self.next_temp += 1
        return temp

    TEMP_RE = re.compile(r'^\$t\d+$')

    def is_temp(self, temp):
        return Checker.TEMP_RE.match(temp)


#global var for easy access.
checker = Checker()
