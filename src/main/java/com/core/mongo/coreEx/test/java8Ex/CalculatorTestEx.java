package com.core.mongo.coreEx.test.java8Ex;


import java.util.stream.Stream;

public class CalculatorTestEx {

    public static void main(String args[]) {

        Calculator add = ( a, b) -> a + b;
        Calculator sub = ( a, b) -> a - b;
        Calculator mul = ( a, b) -> a * b;
        Calculator div = ( a, b) -> {
            if(b == 0) throw  new ArithmeticException("Not Division by Zero");
          return   a / b;
        };

        System.out.println(add.cal(10,20));
        System.out.println(sub.cal(10,20));
        System.out.println(mul.cal(10,20));
        System.out.println(div.cal(10,20));
        //System.out.println(div.cal(10,0));


        Stream.iterate(new int[]{0,1}, f->new int[]{f[1],f[0]+f[1]})
                .limit(8)
                .map(f->f[0])
                .forEach(System.out::println);


    }

}
