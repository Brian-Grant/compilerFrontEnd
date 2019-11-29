program
  : defn program
  | expr0 program
  | /* empty */
  ;

defn
  : 'fn' '(' ID params ')' expr ';' // NTS: maybe the let in should go here?
  ;

params
  : ID params
  | /* empty */
  ;


/** .expr. All expressions are in prefix form. Since all
 *  operators have a fixed arity, no paren are necessary. */
expr
  : INT
  | ID
  | '(' ID args ')'  /* function call */
  | '?' expr expr expr
  | '+' expr expr
  | '-' expr expr
  | '*' expr expr
  |  '/' expr expr
  | '%' expr expr
  | '<' expr expr
  | '>' expr expr
  | '<=' expr expr
  | '>=' expr expr
  | '==' expr expr
  | '!=' expr expr
  //| '(' LET ID expr IN expr ')'	// NTS: change
  //| LET // NTS
  //| IN // NTS
  | let
  ;

let
  : '(' 'let' ID expr more 'in' expr ')'
  ;

more
  : ID expr
  | /* empty */
  ;

/* .expr0. */
expr0
  : expr ';'
  ;

args
  : expr args
  | /* empty */
  ;
