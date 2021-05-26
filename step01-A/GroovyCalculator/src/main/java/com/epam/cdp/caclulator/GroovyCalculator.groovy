package com.epam.cdp.caclulator

class GroovyCalculator implements Calculator {

    static void main(String...args) {
        println("Main point is here")
        println(new GroovyCalculator().calculate("invalid statement here"))
    }

    @Override
    double calculate(String statement) {
        return 0
    }
}