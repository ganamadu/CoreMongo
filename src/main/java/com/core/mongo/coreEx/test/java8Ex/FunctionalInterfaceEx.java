package com.core.mongo.coreEx.test.java8Ex;

import java.util.function.Consumer;
import java.util.function.Predicate;
import java.util.function.Supplier;

public class FunctionalInterfaceEx {

    public static void main(String args[]) {
        MyInterface intf = () -> System.out.println("This is MyFunctional Interface Ex....");
        intf.message();

        MyInterface1 intf1 = (int a, int b) -> a+b;
        System.out.println(intf1.add(10, 20));

        Supplier<String> myName = () -> "My Name is Ganapathi...";
        System.out.println(myName.get());

        Predicate<Integer> isEven = n -> n/2==0;
        System.out.println(isEven.test(5));

        Consumer<String> name = n -> System.out.println(n);
        name.accept("Ganapathi");
    }

}

@FunctionalInterface
interface MyInterface {
    void message();
}

@FunctionalInterface
interface MyInterface1 {
    int add(int a, int b);
}
