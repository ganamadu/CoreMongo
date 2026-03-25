package com.javaconceptoftheday.java8Ex;

import java.util.Arrays;
import java.util.Comparator;

public class RemoveAllOccrOfCharEx {

    //Remove all the occurrences of a given character from that string using java8 streams

    public static void main(String[] args) {
        String originalString = "hello world java streams";
        char charToRemove = 'o';
        String modifiedString = removeCharacter(originalString, charToRemove);
        System.out.println("Original string: " + originalString);
        System.out.println("Character to remove: " + charToRemove);
        System.out.println("Modified string: " + modifiedString);

        System.out.println(" ");
        System.out.println(" ");
        System.out.println("hello world java streams".replace(String.valueOf('o'),""));


        String lenString = Arrays.asList(originalString.split(" "))
                .stream()
                .max(Comparator.comparing(String::length))
                .get();

        System.out.println("StrLeng: "+lenString);

        System.out.println("StrLeng: ");
        Character secondNonRepeativeChar = originalString.chars()
                .mapToObj(ch -> (char) ch)
                .filter(ch -> originalString.indexOf(ch) == originalString.lastIndexOf(ch))
                .skip(1)
                .findFirst()
                .get();
        System.out.println("secondNonRepeativeChar: "+secondNonRepeativeChar);

    }

    public static String removeCharacter(String originalString, char charToRemove) {

        return originalString.chars()
                .filter(c -> c != charToRemove)
                .collect(StringBuilder::new, StringBuilder::appendCodePoint, StringBuilder::append)
                .toString();

    }

}
