package com.javaconceptoftheday.java8Ex;

import java.util.function.BiFunction;

public class BiFunctionCalculation {

    public static void main(String[] args) {

        BiFunction<Integer, Integer, Integer> add = (a,  b) -> a + b;
        BiFunction<Integer, Integer, Integer> sub = (a,  b) -> a - b;
        BiFunction<Integer, Integer, Integer> div = (a,  b) -> {
            if(b ==0) throw  new ArithmeticException("Division by zero");
            return a / b;
        };
        BiFunction<Integer, Integer, Integer> mul = (a,  b) -> a+b;



        int a = 10, b = 5;
        System.out.println(add.apply(a,b));
        System.out.println(sub.apply(a,b));
        System.out.println(mul.apply(a,b));
        System.out.println(div.apply(a,0));



    }

}
