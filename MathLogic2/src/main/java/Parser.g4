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
var         : LOWERCASE DIGITS* ;
acsiomvar   : UPPERCASE DIGITS* ;
pred        : UPPERCASE DIGITS* '(' term (','term)* ')' | term '=' term | acsiomvar ;
term        : add | term '+' add ;
add         : mul | add '*' mul ;
mul         : LOWERCASE DIGITS* '(' term (','term)* ')'
                | var | '(' term ')' | '0' | mul'\'' ;

/*
 * Lexer Rules
 */
WS : [ \t\r]+ -> skip ;
LOWERCASE  : 'a'..'z' ;
UPPERCASE  : 'A'..'Z' ;
DIGITS : ('0'..'9') ;