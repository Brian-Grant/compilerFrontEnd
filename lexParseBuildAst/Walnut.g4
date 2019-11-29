grammar Walnut;

program
  :  ( fnDefinition | classDefinition | varDec | statement ) * EOF
  ;
varDec
  : isStatic='static' ? kind=('const' | 'var') typeSp=typeSpec (decl | initDecl) (',' (decl | initDecl ))* ';'
  | isStatic='static' ? kind=('const' | 'var') initDecl (',' initDecl)* ';'
  ;
decl
  : name=ID
  ;
initDecl
  : name=ID '=' expr                      #exprInit
  | name=ID '=' '{' array '}'             #arrayInit
  ;
array
  : '{' nested+=array '}' ( ',' '{' nested+=array '}' )* ( ',') ?
  | elements += expr ( ',' elements += expr)* ( ',') ?
  ;
classDefinition
  : 'class' typeName=TYPE_ID ( ':' superName=TYPE_ID ) ? '{' ( classBody+=classElement )* '}'
  ; 
classElement
  : ( fnDefinition | varDec )             
  ;	
fnDefinition
  : fnHeader block
  ;
fnHeader
  : isStatic='static' ? typeSpec ID
    '(' params ')'				                #fnProto
  | TYPE_ID '(' params ')'                     	#constrProto
  ;
params
  : formals+= param (',' formals+= param)*
      (',' initFormals+= initParam) *
  | initFormals+= initParam (',' initFormals+= initParam)*
  | // empty
  ;
param
  : typeSpec ID
  ;
initParam
  : typeSpec? ID '=' init
  ;
typeSpec
  : primitiveType ( brackets+= '[' ']' )*        #primType
  | TYPE_ID ( brackets+= '[' ']' )*              #namedType
  ;
primitiveType
  : 'String' | 'Int' | 'Real' | 'Void'
  ;

//placeholders
init 
  : exp=expr
  | '{' array '}'
  ;
actualParams
  : exprParams+=expr ( ',' exprParams+=expr ) * ( ',' keyParams+=keywordParam) *
  | keyParams+=keywordParam ( ',' keyParams+=keywordParam ) *
  | // empty
  ;
keywordParam
  : ID ':' expr
  ;
expr
  : '(' expr ')'                                                                     #eParen
  | anId                                                                             #eId
  | literal                                                                          #eLiteral 
  | TYPE_ID '.' ID                                                                   #eStaticAccess
  | TYPE_ID '(' actualParams ')'                                                     #objConstruction
  | ( TYPE_ID | prim=primitiveType ) '[' idxs+=expr ']' ( '[' idxs+=expr ']' ) *     #arrConstruction
  | arr=expr '[' index=expr ']'                                                      #eArrIndex  
  | expr '(' actualParams ')'                                                        #eFnCall  
  | expr '.' name=ID                                                                 #eAccess
  | '(' typeSpec ')' expr                                                            #eCast
  | '-' expr                                                                         #eMinus
  | left=expr operator=( '*' | '/' | '%' ) right=expr                                #eMulDivMod
  | left=expr operator=( '+' | '-' ) right=expr                                      #eAddSub
  | left=expr operator=( '==' | '!=' | '<' | '>' | '<=' | '>=') right=expr           #eRelation
  | '!' expr                                                                         #eNot
  | left=expr  '&&' right=expr                                                       #eAnd
  | left=expr  '||' right=expr                                                       #eOr
  | <assoc=right> cond=expr '?' then=expr ':' elseExpr=expr                          #eTern
  | <assoc=right> left=expr  '=' right=expr                                          #eAssign
  ;



literal
  : INT          #intLit
  | STRING       #stringLit
  | REAL         #realLit
  | 'nil'        #nilLit
  ;
block 
  : '{' ( statement | varDec )* '}'
  | '{' '}'
  ;

statement
  : 'while' '(' expr ')' statement                                                    #stWhile
  | 'if' '(' ifExpr=expr ')' ifStmnt=statement ( 'else' elseStmnt=statement ) ?       #stIf
  | 'return' ( ret=expr ) ? ';'                                                       #stReturn
  | block                                                                             #stBlock
  | expr ';'                                                                          #stExpr
  | ';'                                                                               #stEmpty
  ;

// non-terminals used for development
anId
  : ID
  ;



//Lexical grammar

TYPE_ID
  : [A-Z][a-zA-Z0-9_]*
  ;
ID
  : [_a-z][a-zA-Z0-9_]*
  ;
INT
  : DIGITS
  ;

STRING
  : '"' ( ~[\\\n"] | '\\'~[\n] ) * '"'
  ;

REAL
  : DIGITS ( '.' DIGITS ) ? ( 'e' | 'E' ) ( '-' | '+' ) ? DIGITS 
  | DIGITS ( '.' DIGITS )  ( ( 'e' | 'E' ) ( '-' | '+' ) ? DIGITS ) ?
  ;
LINE_COMMENT
  : '//' ~[\n]* -> skip
  ;
BLOCK_COMMENT
  : '/*' .*? '*/' -> skip
  ;
WS
  : [ \t\r\n]+ -> skip
  ;
fragment DIGITS
  : [0-9]([0-9_]*[0-9])?
  ;

