grammar Parser;

/*
 * Parser Rules
 */

file        : header '\n' proving;
header      : (expr',')* expr '|-' expr ;
proving     : (expr'\n')* EOF?;
expr        : dis | <assoc=right> dis '->' expr;
dis         : con | dis '|' con ;
con         : unary | con '&' unary ;
unary       : pred | not | '(' expr ')' | any | exist ;
not         : '!' unary ;
exist       : '?' var unary ;
any         : '@' var unary ;
var         : LOWERCASE ('0'| DIGITS)* ;
acsiomvar   : UPPERCASE ('0'| DIGITS)* ;
pred        : predname '(' term (','term)* ')' | term '=' term | acsiomvar ;
predname    : UPPERCASE ('0'| DIGITS)* ;
term        : add | term '+' add ;
add         : mul | add '*' mul ;
mul         : funcname '(' term (','term)* ')'
                | var | '(' term ')' | '0' | mul'\'' ;
funcname    : LOWERCASE ('0'| DIGITS)* ;

/*
 * Lexer Rules
 */
WS : [ \t\r]+ -> skip ;
LOWERCASE  : 'a'..'z' ;
UPPERCASE  : 'A'..'Z' ;
DIGITS : ('1'..'9') ;