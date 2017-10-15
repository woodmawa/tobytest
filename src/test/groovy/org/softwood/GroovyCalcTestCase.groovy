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
        System.out = printMock

        def calc = new Calc()
        try {
            calc.add (1,2)
        } finally {
            System.out = originalPrintStream
        }

        assertEquals "calc ans=3", printMock.output
    }


}

class PrintMock extends PrintStream {
    PrintMock() {super(System.out)}

    def output

    void println (text) {output = text}
}