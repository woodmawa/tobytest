package org.softwood

class GroovyCalcTestCase extends GroovyTestCase {
    void testAdd () {
        def ans = Calc.add (1,2)
        println "going assert answer is correct"
        assertEquals "1 plus 2 must give 3", 3, ans
    }

    void testAddOutput() {
        def originalPrintStream = System.out
        def printMock = new PrintMock ()

        printMock.println "hello"
        assert printMock.textOutput == "hello"

        def ans

        def calc = new Calc()
        System.out = printMock
        try {
            ans = calc.add (1,2)
        } finally {
            System.out = originalPrintStream
        }

        assertEquals 3, ans
        assertEquals "expected ans as 3 ", "calc ans=3", printMock.textOutput
    }

    void testMultiplyOutput () {
        def testCalc = new Calc ()

        def fileMock = groovy.mock.interceptor.StubFor (java.io.FileWriter)
        def resultText

        fileMock.demand.write {resultText = it.toString()}
        fileMock.demand.close {}

        fileMock.use {
            testCalc.multiply(2, 2)
        }

        assertEquals
    }
}

class PrintMock extends PrintStream {
    PrintMock() {super(System.out)}

    def textOutput

    @Override
    void println (String text) {
        textOutput = text

        def var = 1
    }
}