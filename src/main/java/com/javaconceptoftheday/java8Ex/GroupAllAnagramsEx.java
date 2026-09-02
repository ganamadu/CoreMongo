package com.javaconceptoftheday.java8Ex;

import java.io.Console;
import java.util.*;

public class GroupAllAnagramsEx {

    public static void main(String[] args) {

        List<String> strList = Arrays.asList("tea","ate","tan","bat","tab","nat","cat","mat","rat");

        List<List<String>> anagrams = getAnagrams(strList);
        System.out.println("Anagrams: "+anagrams);


        String str = "java concepts are awesome";
        Map<Character, Integer> countMap = new HashMap<>();
        for(char c : str.toCharArray())
        {
            if(countMap.containsKey(c)) {
                countMap.get(c);
            }
        }



    }

    public static List<List<String>> getAnagrams(List<String> stringList) {

        Map<String, List<String>> strMap = new HashMap<>();

        for(String word : stringList) {
            char[] charArray = word.toCharArray();
            Arrays.sort(charArray);
            String key = new String(charArray);
            strMap.computeIfAbsent(key, k->new ArrayList<>()).add(word);
        }

        return new ArrayList<>(strMap.values());

    }

}
