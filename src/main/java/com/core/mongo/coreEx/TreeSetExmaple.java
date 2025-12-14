package com.core.mongo.coreEx;

import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.TreeSet;

public class TreeSetExmaple {

    public static void main(String args[]) {

        TreeSet<String> treeSet = new TreeSet<>();
        treeSet.add("Thaneesh");
        treeSet.add("Risith");
        treeSet.add("Srilatha");
        treeSet.add("Ganapathi");

        treeSet.stream().forEach(System.out::println);

        System.out.println();
        HashSet<String> hashSet = new HashSet<>();
        hashSet.add("Thaneesh");
        hashSet.add("Risith");
        hashSet.add("Srilatha");
        hashSet.add("Ganapathi");

        hashSet.stream().forEach(System.out::println);

        System.out.println();
        LinkedHashSet<String> linkedHashSet = new LinkedHashSet<>();
        linkedHashSet.add("Thaneesh");
        linkedHashSet.add("Risith");
        linkedHashSet.add("Srilatha");
        linkedHashSet.add("Ganapathi");

        linkedHashSet.stream().forEach(System.out::println);



    }

}
