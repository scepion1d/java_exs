package com.epam.cdp.caclulator

import java.util.regex.Pattern

class GroovyCalculator implements Calculator {
    private static Pattern numberRegex = ~/\d+(\.*\d+)?/
    private static Pattern operatorRegex = ~/[\*\/\+-]/

    static void main(String...args) {
        println("Main point is here")
        println(new GroovyCalculator().calculate("invalid statement here"))
    }

    @Override
    double calculate(String statement) {
        if (!statementIsValid(statement)) throw new IllegalArgumentException()

        def operandsMatcher = statement =~ numberRegex
        double leftOperand  = Double.parseDouble(operandsMatcher[0][0])
        double rightOperand = Double.parseDouble(operandsMatcher[1][0])
        String operator     = (statement =~ operatorRegex)[0][0]

        switch (operator) {
            case "+":
                return leftOperand + rightOperand
            case "-":
                return leftOperand - rightOperand
            case "*":
                return leftOperand * rightOperand
            case "/":
                return leftOperand / rightOperand
        }
    }

    private static boolean statementIsValid(String statement) {
        Pattern statementRegex = Pattern.compile(
                String.format(
                        "%s\\s*%s\\s*%s", numberRegex, operatorRegex, numberRegex
                )
        )

        return statementRegex.matcher(statement).matches()
    }
}