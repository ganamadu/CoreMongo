package com.javaconceptoftheday.java8Ex;

import java.util.Arrays;
import java.util.stream.Collectors;

public class StringStartWithEx {

    public static void main(String args[]) {

        String[] sentances = {
           "Here is a #sample sentences in #java.",
           "This is another #example of a #scentance.",
           "#Java streams #are powerful.",
           "Find words that start with #."
        } ;

        Arrays.stream(sentances)
                .flatMap(w-> Arrays.stream(w.split(" ")))
                .filter(w->w.startsWith("#"))
                .forEach(System.out::println);


    }

}
