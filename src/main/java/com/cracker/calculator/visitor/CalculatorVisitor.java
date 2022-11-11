package com.cracker.calculator.visitor;

import com.cracker.calculator.autogen.CalculatorParser.MulDivContext;
import com.cracker.calculator.autogen.CalculatorParser.NumberContext;
import com.cracker.calculator.autogen.CalculatorParser.PlusMinusContext;
import com.cracker.calculator.autogen.CalculatorParser.RootContext;
import com.cracker.calculator.autogen.CalculatorParser.SubExprContext;
import com.cracker.calculator.autogen.CalculatorParserBaseVisitor;

public class CalculatorVisitor extends CalculatorParserBaseVisitor<Double> {

    @Override
    public Double visitRoot(final RootContext ctx) {
        return visit(ctx.expr());
    }

    @Override
    public Double visitPlusMinus(final PlusMinusContext ctx) {
        if ("+".equals(ctx.op.getText())) {
            return visit(ctx.expr(0)) + visit(ctx.expr(1));
        } else {
            return visit(ctx.expr(0)) - visit(ctx.expr(1));
        }
    }

    @Override
    public Double visitMulDiv(final MulDivContext ctx) {
        if ("*".equals(ctx.op.getText())) {
            return visit(ctx.expr(0)) * visit(ctx.expr(1));
        } else {
            return visit(ctx.expr(0)) / visit(ctx.expr(1));
        }
    }

    @Override
    public Double visitSubExpr(final SubExprContext ctx) {
        return visit(ctx.expr());
    }

    @Override
    public Double visitNumber(final NumberContext ctx) {
        return Double.parseDouble(ctx.getText());
    }
}
