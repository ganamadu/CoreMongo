package com.javaconceptoftheday.overrideEx;

import java.util.EnumMap;

public class EnumMapEx {

    public static void main(String[] args) {

        EnumMap<Months, Integer> enumMap = new EnumMap<>(Months.class);
        enumMap.put(Months.JANUARY, 31);
        enumMap.put(Months.FEBRUARY, 28);
        enumMap.put(Months.MARCH, 31);
        enumMap.put(Months.APRIL, 30);
        enumMap.put(Months.MAY, 31);
        enumMap.put(Months.JUNE, 30);
        enumMap.put(Months.JULY, 31);
        enumMap.put(Months.AUGUST, 31);
        enumMap.put(Months.SEPTEMBER, 30);
        enumMap.put(Months.OCTOBER, 31);
        enumMap.put(Months.NOVEMBER, 30);
        enumMap.put(Months.DECEMBER, 31);


        enumMap.entrySet().stream().forEach(m->System.out.println(m.getKey()+"  "+m.getValue()));


    }

}

enum Months {
    JANUARY,
    FEBRUARY,
    MARCH,
    APRIL,
    MAY,
    JUNE,
    JULY,
    AUGUST,
    SEPTEMBER,
    OCTOBER,
    NOVEMBER,
    DECEMBER

}
