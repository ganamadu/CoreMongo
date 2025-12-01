package com.javaconceptoftheday.methodreference;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.function.BiFunction;
import java.util.function.Function;
import java.util.function.Supplier;
import java.util.stream.Collectors;

public class MethodReferenceExamples {

    static class Person {
        private String name;
        private Integer age;

        public Person(String name, Integer age) {
            this.name = name;
            this.age = age;
        }

        public static Integer compareByAge(Person a, Person b) {
            return Integer.compare(a.age, b.age);
        }

        public Integer compareByName(Person a) {
            return this.name.compareTo(a.name);
        }

        public String getName() {
            return name;
        }

        public Integer age() {
            return age;
        }

        @Override
        public String toString() {
            return name+" ("+age+")";
        }

    }

    public static void main(String args[]) {

        List<Person> people = Arrays.asList(
          new Person("Ganapathi", 40),
            new Person("Thaneesh", 13),
                new Person("Rishith", 7)
        );
        people.sort(Person::compareByAge);
        System.out.println("Sort By Age: "+people);

        // 4. Reference to constructor
        Function<String, StringBuilder> sbCreator = StringBuilder::new;
        StringBuilder sb = sbCreator.apply("Hello");
        System.out.println("StringBuilder: "+sb);

        // BiFunction with constructor
        BiFunction<String, Integer, Person> personCreator = Person::new;
        Person newPerson = personCreator.apply("Srilatha", 38);
        System.out.println("New Person: "+newPerson);

        // Static method reference
        List<String> strings = Arrays.asList("1", "2", "3", "4", "5");
        List<Integer> integerList = strings.stream().map(Integer::parseInt)
                .collect(Collectors.toList());
        System.out.println("Int List: "+integerList);

        String text = "Hello World";
        Supplier<String> supplierUpperCase = text::toUpperCase;
        System.out.println("Upper Case: "+supplierUpperCase.get());

        
    }

}
