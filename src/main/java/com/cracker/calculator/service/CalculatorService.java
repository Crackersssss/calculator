package com.cracker.calculator.service;

import com.cracker.calculator.autogen.CalculatorLexer;
import com.cracker.calculator.autogen.CalculatorParser;
import com.cracker.calculator.visitor.CalculatorVisitor;
import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.CharStreams;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.tree.ParseTree;
import org.springframework.stereotype.Service;

@Service
public class CalculatorService {
    
    public Double compute(final String expr) {
        CharStream input = CharStreams.fromString(expr);
        CalculatorLexer lexer = new CalculatorLexer(input);
        CommonTokenStream tokens = new CommonTokenStream(lexer);
        CalculatorParser parser = new CalculatorParser(tokens);
        ParseTree root = parser.root();
        CalculatorVisitor visitor = new CalculatorVisitor();
        return root.accept(visitor);
    }
    
}
