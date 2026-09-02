package com.core.mongo.coreEx.test.java8Ex;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ListOffEx {


    public static int[] getIndex(int arr[], int value){
        Map<Integer, Integer> map = new HashMap<>();
        for(int i=0; i<arr.length; i++) {
            int index = value - arr[i];
            if(map.containsKey(index)) {
                return new int[] {index, arr[i]};
            }
            map.put(arr[i], i);
        }
        return new int[]{};
    }




    public static void main(String[] args) {

        List<Integer> list1 = Arrays.asList(1,2,3,4,5);

        //list1.add(6);  //Exception in thread "main" java.lang.UnsupportedOperationException
        list1.set(3,6);
        System.out.println(list1);
        List<Integer> list2 = List.of(1,2,3,4,5);
        //list2.add(6); //Exception in thread "main" java.lang.UnsupportedOperationException
        //list2.set(3,6); //Exception in thread "main" java.lang.UnsupportedOperationException

        Map<String, String> map = new HashMap<>();
        map.put("1", "One");
        map.put("2", "Two");
        System.out.println(map.getOrDefault("3", "Three"));
        System.out.println(map.get("4"));

        int[] intArr = {2,5,7,8,9};
        for(int i : getIndex(intArr, 12)) {
            System.out.println(i);
        }

    }

}
