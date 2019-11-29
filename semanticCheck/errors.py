# used for tracking errors: main instance method is add(coord, type, msg)
# which records error message for error type at coord.  str() method
# returns string of all error messages sorted by coord.  This makes
# it possible for multiple semantic passes to create errors in an
# arbirary order but have them presented in source order.

class Errors:
    def __init__(self, out=None):
        self.errors = []
        self.out = out

    def n_errors(self):
        return len(self.errors)

    def add(self, coord, type, msg):
        """add an error at coord with specified type and msg"""
        self.errors.append((coord, type, msg))
        if self.out: self.out.write('%s: %s: %s\n' % (coord, type, msg))

    def __len__(self):
        return len(self.errors)

    def __str__(self):
        """return string of all errors sorted by coordinate"""
        text = ''
        for err in sorted(self.errors, key=lambda e: e[0].sort_key()) :
            text += '%s: %s: %s\n' % (err[0], err[1], err[2])
        return text
