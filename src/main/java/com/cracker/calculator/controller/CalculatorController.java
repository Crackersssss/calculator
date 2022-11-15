package com.cracker.calculator.controller;

import com.cracker.calculator.service.CalculatorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CalculatorController {
    
    @Autowired
    private CalculatorService calculatorService;
    
    @RequestMapping(path = "/compute")
    public Double compute(final String expr) {
        return calculatorService.compute(expr);
    }
}
