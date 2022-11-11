parser grammar CalculatorParser;

options {
    tokenVocab = CalculatorLexer;
} 

root
    : expr EOF
    ;

expr
    : expr op = (MUL_OPERATOR | DIV_OPERATOR) expr      #mulDiv     //利用语法优先匹配消除运算符优先级问题
    | expr op = (PLUS_OPERATOR | MINUS_OPERATOR) expr   #plusMinus
    | (PLUS_OPERATOR | MINUS_OPERATOR)? NUMBER          #number
    | OPEN_PAR_SYMBOL expr CLOSE_PAR_SYMBOL             #subExpr
    ;