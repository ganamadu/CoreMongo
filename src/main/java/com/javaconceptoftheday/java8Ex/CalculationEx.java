package com.javaconceptoftheday.java8Ex;

import java.util.function.BiFunction;

public class CalculationEx {


    public static void main(String args[]) {

        Calculator addition = (int a, int b) -> a+b;
        Calculator subtract = (int a, int b) -> a-b;
        Calculator division = (int a, int b) -> {
            if (b == 0) throw new ArithmeticException("Division by zero");
            return a / b;
        };
        Calculator multiplication = (int a, int b) -> a+b;

        int a = 5, b =10;
        System.out.println(addition.calculate(a,b));
        System.out.println(subtract.calculate(a,b));
        System.out.println(division.calculate(a,b));
        System.out.println(multiplication.calculate(a,b));


    }

}
