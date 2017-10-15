package org.softwood

import spock.lang.Specification

class SpockCalcTest extends Specification {

    def firstCalcTest () {
        setup: ""
        println "1st test on add "

        when: "add 1 + 2 "
        def ans = Calc.add(1,2)

        then : "result should be 3"
        ans == 3
    }
}
