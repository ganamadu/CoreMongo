package com.core.mongo.coreEx.test.java8Ex;

import java.util.Comparator;
import java.util.List;

public class PSLInternalQuestionsEx {

    public static void main(String args[]) {

        List<Integer> intList = List.of(2,1,3,4,3,2,6,5,7,8,7,6,9);

        //Find the 3rd highest number in Integer List and remove duplicates
        Integer thirdHighestNum = intList.stream().distinct().sorted(Comparator.reverseOrder()).skip(2).findFirst().get();
        System.out.println("ThirdHighestNum: "+thirdHighestNum);

        //Difference between Transient and volatile keywords?

        //How to avoid deadlock?



    }

}
