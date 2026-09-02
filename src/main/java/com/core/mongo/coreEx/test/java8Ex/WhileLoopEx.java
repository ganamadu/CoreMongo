package com.core.mongo.coreEx.test.java8Ex;

public class WhileLoopEx {

    public static void main(String[] args) {

        int x = 10;
        while(true) {
            System.out.println(x++ * 2);
            if(x%3==0)
                break;
        }

        boolean flag = true;
        /*switch (flag) { While not supported to the boolean input

        }*/

    }

}
