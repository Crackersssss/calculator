lexer grammar CalculatorLexer; 

fragment DIGIT : [0-9];

NUMBER : DIGIT+('.'(DIGIT+)?)? ;

PLUS_OPERATOR:  '+';
MINUS_OPERATOR: '-';
MUL_OPERATOR:  '*';
DIV_OPERATOR:   '/';

OPEN_PAR_SYMBOL:    '(';
CLOSE_PAR_SYMBOL:   ')';

WS : [ \t\r\n]+ -> skip ;