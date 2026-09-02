package com.core.mongo.coreEx.facebookJava8Ex;

import java.util.HashMap;
import java.util.Map;

public class IntNumGivenTargetEx {

    public static void main(String[] args) {
        int nums[] = {2,7,11,15};
        int[] ints = twoSum(nums, 17);
        for(int n : ints) {
            System.out.println(n);
        }

        System.out.println();
        int[] intArr = twoSumArr(nums, 17);
        for(int n : intArr) {
            System.out.println(n);
        }
    }

    public static int CBSE(int x) {
        if(x < 100)
            x = CBSE(x+10);
        return (x-1);
    }

    public static int[]  twoSumArr(int[] nums, int target) {
        System.out.println("CBSE: "+CBSE(60));
        for(int i=0; i<nums.length; i++) {
            for(int j=i+1; j<nums.length; j++) {
                if(nums[i] + nums[j] == target) {
                    return new int[]{i,j};
                }
            }
        }
        return new int[] {};
    }


    public static int[]  twoSum(int[] nums, int target) {
        Map<Integer, Integer> map = new HashMap<>();
        for(int i=0; i<nums.length; i++) {
            int component = target - nums[i];
            if(map.containsKey(component)) {
                return  new int[] {
                    map.get(component), i
                };
            }
            map.put(nums[i], i);
        }
        return new int[] {};
    }
}
