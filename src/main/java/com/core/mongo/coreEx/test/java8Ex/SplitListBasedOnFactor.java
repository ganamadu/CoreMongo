package com.core.mongo.coreEx.test.java8Ex;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class SplitListBasedOnFactor {

    public static void main(String args[]) {

        System.out.println(Math.ceil(13/2));
        System.out.println(Math.min(13/4, 13/3));
        System.out.println(Math.max(13/4, 13/3));

        splitList((IntStream.range(1,55).boxed().collect(Collectors.toList())), 4);

    }

    public static void splitList(List<Integer> intList, int factor) {

        int total = intList.size();
        int chunkSize = (int) Math.ceil((double)total/factor);

        for(int i=0; i<factor; i++) {
            int from = (i * chunkSize) + 1;
            int to = Math.min((i + 1) * chunkSize, total);
            System.out.println("From: "+from+" To: "+to);
        }


    }

}
