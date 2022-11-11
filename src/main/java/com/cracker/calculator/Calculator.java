package com.cracker.calculator;

import com.cracker.calculator.service.CalculatorService;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class Calculator {

    public static void main(final String[] args) {
        Double compute = new CalculatorService().compute("-1-(1-(2+3)-(-4)*(-5)/(+6))");
        System.out.println(compute.doubleValue());
    }

}
