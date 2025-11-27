package com.javaconceptoftheday.overrideEx;

public class OutPutEx1 {

    public static void main(String args[]) {

        new ExA();

    }

}

class ExA {

    public ExA(int i) {
        System.out.println(1);
    }
    public ExA() {
        this(10);
        System.out.println(2);
    }

    void ExA() {
        ExA(10);
        System.out.println("3");
    }
    void ExA(int i) {
        System.out.println(4);
    }
}
