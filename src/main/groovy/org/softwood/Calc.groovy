package org.softwood

class Calc {

    private static int ans

    static int add (int a, int b) {
        println "calc ans=${a+b}"

        return a+b;
    }

    int multiply (int a, int b) {

        def val = a*b
        def file = new java.io.FileWriter("calcFileOutput.txt")
        file.write ("the answer is : $val")
        return val
    }
}
