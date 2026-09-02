package com.core.mongo.coreEx.test.java8Ex;

import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;

public class FindNthSalaryInMap {

    public static Map.Entry<String, Integer> findNthSal(Map<String, Integer> map, Integer nthSal) {

        return map.entrySet().stream().distinct().sorted(Map.Entry.comparingByValue(Comparator.reverseOrder()))
                .skip(nthSal-1)
                .findFirst().get();

    }



    public static void main(String args[]) {

        Map<String, Integer> map = new HashMap<>();
        map.put("vivek", 100);
        map.put("Rinku", 400);
        map.put("vishal", 600);
        map.put("shankar", 500);
        map.put("shyam", 500);
        map.put("tinku", 300);

        map.entrySet().stream()
                .sorted(Map.Entry.comparingByValue(Comparator.reverseOrder()))
                        //.sorted(Comparator.comparing(Map.Entry::getValue, Comparator.reverseOrder()))
                                .forEach(m->System.out.println(m.getKey()+"     "+m.getValue()));

        System.out.println(findNthSal(map , 3));

    }

}
