package com.core.mongo.coreEx.test;

import java.util.List;
import java.util.function.Supplier;
import java.util.stream.Stream;

public class StreamReuseExample {

    public static void main(String args[]) {

        List<String> names = List.of("Ganapathi", "Srilatha","Thaneesh","Risith");

        Stream<String> nameStream = names.stream();
        nameStream.forEach(System.out::println);

        //nameStream.sorted().forEach(System.out::println);


        Supplier<Stream<String>> streamSupplier = () -> List.of("Ganapathi", "Srilatha","Thaneesh","Risith").stream();


        streamSupplier.get().forEach(System.out::println);
        System.out.println("\n Supplier: ");
        streamSupplier.get().sorted().forEach(System.out::println);

    }

}
