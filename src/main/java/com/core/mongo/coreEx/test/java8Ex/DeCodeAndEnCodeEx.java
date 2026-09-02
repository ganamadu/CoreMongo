package com.core.mongo.coreEx.test.java8Ex;

import java.util.Arrays;
import java.util.Base64;

public class DeCodeAndEnCodeEx {

    public static void main(String[] args) {

        String str = "java concepts are awesome";
        System.out.println("Str: "+str);

        String enCodeStr = Base64.getEncoder().encodeToString(str.getBytes());
        System.out.println("Encode Str: "+enCodeStr);
        byte[] decode = Base64.getDecoder().decode(enCodeStr);
        String decodeStr = new String(decode);

        System.out.println("Decode Str: "+decodeStr);

        String strArr[] = {"java","java8","java9","java11","java17","java21","java2java"};

        String[] array = Arrays.asList(strArr)
                .stream()
                .map(s -> s.replace("java", "python"))
                .toArray(String[]::new);
        System.out.println("Array: "+Arrays.asList(array));


    }

}
