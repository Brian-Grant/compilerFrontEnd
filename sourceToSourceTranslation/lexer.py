#!/usr/bin/env python3.7

from collections import namedtuple

#track locations within files
Coord = namedtuple('Coord', 'path lineN colN')
Coord.__str__ = lambda self: f'{self.path}:{self.lineN}:{self.colN}'

#info included in a token
Token = namedtuple('Token', 'kind lexeme coord')
Token.__str__ = lambda self: f'{self.kind} "{self.lexeme}" @{self.coord}'

class Lexer:
    """Tedious manual scanner for tl0"""

    def __init__(self, paths=[]):
        """Create a lexer for all files specified by list of paths"""
        self._paths = paths
        self._contents = {}
        for path in paths:
            with open(path, 'rU') as file:
                self._contents[path] = file.read().expandtabs()

    def diagnostic(self, msg, coord):
        """Return a diagnostic message msg for coord, including line at coord"""
        lines = self._contents[coord.path].split('\n')
        line = lines[coord.lineN - 1]
        indicator = ' ' * coord.colN + '^'
        return f'{coord}: {msg}\n{line}\n{indicator}\n'

    def tokens(self):
        """Return iterator for all tokens produced by this lexer"""
        for path in self._paths:
            for token in self.text_tokens(self._contents[path], path):
                yield token
        yield self._tok('EOI', '')

    def text_tokens(self, text, path=''): #.text_tokens0.
        """Return iterator for all tokens from text

           Useful for testing without mocking.
        """
        self._text, self._path = text, path
        self._lineN, self._colN = 1, 0
        self._index, self._limit = 0, len(text)
        while self._index < self._limit:
            self._chew_space()
            if self._index >= self._limit:
                break                           #.text_tokens1.
            ch = text[self._index]
            if ch == '#':
                self._chew_comment()
            elif ch.isdigit():
                yield self._int_token()
            elif ch.isalpha() or ch == '_':
                yield self._id_token()
            elif self._is_eq_token():
                yield self._tok('OP', '==')
            elif self._is_neq_token():
                yield self._tok('OP', '!=')
            elif ch in '<>':
                yield self._compare_token()
            elif ch in '+-*/%?':               #.text_tokens2.
                yield self._single_char_token('OP')
            elif ch == ';':
                yield self._single_char_token('SEMI')
            elif ch in '()':
                yield self._single_char_token('PAREN')
            else:
                yield self._single_char_token('ERROR')
      #.text_tokens3.

    def _chew_space(self):
        """Advance _index to ignore whitespace, updating all instance vars"""
        while self._index < self._limit:
            ch = self._text[self._index]
            if not ch.isspace(): break
            if ch == '\n':
                self._lineN += 1
                self._colN = -1
            self._colN += 1
            self._index += 1

    def _chew_comment(self):
        """Advance _index to ignore rest of line"""
        text = self._text
        index, limit = self._index, self._limit
        assert text[index] == '#'
        while index < limit and text[index] != '\n': index += 1
        self._index = index

    def _int_token(self):
        """Return token corresponding to int at _index"""
        assert self._text[self._index].isdigit()
        return self._tok('INT', self._lexeme(lambda c: c.isdigit() or c == '_'))

    #reserved words recognized by lexer
    RESERVED = {
        'fn': 'FN', 'let': 'LET', 'in': 'IN'
    }

    def _id_token(self):
        """Return token corresponding to id or reserved word at _index"""
        assert (self._text[self._index].isalpha() or
                self._text[self._index] == '_')
        lexeme = self._lexeme(lambda c: c.isalnum() or c == '_')
        kind = Lexer.RESERVED.get(lexeme, None) or 'ID'
        return self._tok(kind, lexeme)

    def _lexeme(self, test):
        """Return lexeme at _index with chars c such that test(c)"""
        text = self._text
        index, limit = self._index, self._limit
        lexeme = ''
        while index < limit and test(text[index]):
            lexeme += text[index]
            index += 1
        return lexeme

    def _is_eq_token(self):
        """Return true iff _text[_index] is '=='"""
        text = self._text
        index, limit = self._index, self._limit
        return (text[index] == '=' and
                index + 1 < limit and
                text[index + 1] == '='
               )

    def _is_neq_token(self):
        """Return true iff _text[_index] is '!='"""
        text = self._text
        index, limit = self._index, self._limit
        return (text[index] == '!' and
                index + 1 < limit and
                text[index + 1] == '='
               )

    def _compare_token(self):
        """Return comparison token <, >, <=, >= at _index"""
        text = self._text
        index, limit = self._index, self._limit
        assert text[index] in '<>'
        if index + 1 < limit and text[index + 1] == '=':
            lexeme = text[index:(index+2)]
        else:
            lexeme = text[index]
        return self._tok('OP', lexeme)

    def _single_char_token(self, kind):
        """Return token with specified kind of single char at _index"""
        return self._tok(kind, self._text[self._index])

    def _tok(self, kind, lexeme):
        """Return token of specific kind and lexeme, updating instance vars"""
        coord = Coord(self._path, self._lineN, self._colN)
        token = Token(kind, lexeme, coord)
        lex_len = len(lexeme)
        self._index += lex_len
        self._colN += lex_len
        return token

if __name__ == '__main__':
    import sys
    lexer = Lexer(sys.argv[1:])
    for token in lexer.tokens():
        print(token)
    print(lexer.diagnostic('some message', Coord(sys.argv[1], 1, 3)))
