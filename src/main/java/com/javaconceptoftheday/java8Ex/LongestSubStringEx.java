package com.javaconceptoftheday.java8Ex;

import java.util.HashSet;

public class LongestSubStringEx {

    public static void main(String[] args) {

        //Find the longest substring without repeating characters.

        String str = "abcabcdbb";

        System.out.println(str.substring(0,longestSubString(str)));

    }

    public static int longestSubString(String str) {
        HashSet<Character> set = new HashSet<>();
        int left=0, maxLength = 0;

        for(int right=0; right<str.length(); right++) {
            char current = str.charAt(right);

            while (set.contains(current)) {
                set.remove(str.charAt(left));
                left++;
            }

            set.add(current);
            maxLength = Math.max(maxLength, right - left + 1);
        }
        return maxLength;
    }

}
