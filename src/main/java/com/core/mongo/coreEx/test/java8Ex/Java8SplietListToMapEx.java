package com.core.mongo.coreEx.test.java8Ex;

import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class Java8SplietListToMapEx {

    static class Person {
        Integer no;
        String name;

        public Person(Integer no, String name) {
            this.no = no;
            this.name = name;
        }

        public Integer getNo() {
            return no;
        }

        public void setNo(Integer no) {
            this.no = no;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }
    }

    public static void main(String args[]) {

        List<Person> personList = new ArrayList<>();
        IntStream.range(1,100).boxed().forEach(n->{
            personList.add(new Person(n, "Person"+n));
        });

        Map<Integer, Person> personMap1 = personList.stream().filter(p -> p.getNo() >= 1 && p.getNo() <= 10)
                .collect(Collectors.toMap(Person::getNo, Function.identity()));

        Map<Integer, Person> personMap2 = personList.stream().filter(p -> p.getNo() >= 1 && p.getNo() <= 10)
                .collect(Collectors.toMap(Person::getNo, Function.identity()));

        Map<Integer, Person> personMap3 = personList.stream().filter(p -> p.getNo() >= 1 && p.getNo() <= 10)
                .collect(Collectors.toMap(Person::getNo, Function.identity()));

        System.out.println("Person List");
        //IntStream.range(1, personList.size()/10).collect(Collectors.toMap());

        //How many maps you want split the Maps based on factor.
        List<Map<Integer, Person>> personMaps = splitPersons(personList, 3);
        System.out.println(personMaps.size());
        System.out.println(personMap1);

        personMaps.get(0).entrySet().stream().sorted(Map.Entry.comparingByValue(Comparator.comparing(m->m.getName())));

        String str = "ganapathi";
        Stream.of(str).forEach(c->System.out.println("Char: "+c));
        List.of(Arrays.asList(str.toCharArray())).stream().forEach(c->System.out.println("Char: "+c));

    }

    public Map<Integer, Person> getMap(Integer fromIndex, Integer toIndex, List<Person> personList) {
        return  personList.stream().filter(p -> p.getNo() >= fromIndex && p.getNo() <= toIndex)
                .collect(Collectors.toMap(Person::getNo, Function.identity()));
    }

    public static List<Map<Integer, Person>> splitPersons(List<Person> personList, int factor) {
        int total = personList.size();
        int chunkSize = (int) Math.ceil((double) total / factor);
        List<Map<Integer, Person>> result = new ArrayList<>();
        for (int i = 0; i < factor; i++) {
            int from = (i * chunkSize) + 1;
            int to = Math.min((i + 1) * chunkSize, total);

            Map<Integer, Person> subMap = personList.stream()
                    .filter(p -> p.getNo() >= from && p.getNo() <= to)
                    .collect(Collectors.toMap(Person::getNo, Function.identity()));
            result.add(subMap);
        }
        return result;
    }



}

