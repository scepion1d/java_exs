package com.epam.cdp.caclulator

import spock.lang.Specification

/**
 * Created by Andrii_Korkoshko on 10/18/2016.
 */
class GroovyCalculatorSpec extends Specification {
    def instance = Spy(GroovyCalculator)

    def "Throws IllegalArgumentException when statement doesn't contain allowed operation"() {
        given:
            //Setup
        when:
            instance.calculate("0.222 < 2")
        then:
            thrown IllegalArgumentException
    }

    def "Throws IllegalArgumentException when statement contains wrong number of operands"() {
        given:
            //Setup
        when:
            instance.calculate("0.222+")
        then:
            thrown IllegalArgumentException
    }

    def "Successfully performs addition"() {
        given:
            //Setup
        when:
            def result = instance.calculate("0.222 + 2")
        then:
            result == 2.222d
    }

    def "Successfully performs subtraction"() {
        given:
            //Setup
        when:
            def result = instance.calculate("0.222 - 2")
        then:
            result == -1.778d
    }

    def "Successfully performs multiplication"() {
        given:
            //Setup
        when:
            def result = instance.calculate("0.222 * 2")
        then:
            result == 0.444d
    }


    def "Successfully performs division"() {
        given:
            //Setup
        when:
            def result = instance.calculate("0.222 / 2")
        then:
            result == 0.111d
    }
}
