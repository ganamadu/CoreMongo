package com.core.mongo.coreEx.test;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class MapAndFlatMapEx {

    public static void main(String[] args) {

        List<Institute> instituteList = new ArrayList<>();

        instituteList.add(new Institute("IIM", List.of("Bangalore", "Ahmedabad", "Kozhikode", "Lucknow")));
        instituteList.add(new Institute("IIt", List.of("Delhi", "Mumbai", "Madras")));
        instituteList.add(new Institute("NIFT", List.of("Hyderabad", "Mumbai", "Patna", "Bangalore")));

        //Map
        instituteList.stream().map(Institute::getName).forEach(System.out::println);

        //FlatMap

        List<String> locationList = instituteList.stream().flatMap(institute -> institute.getLocations().stream().distinct()).collect(Collectors.toList());
        System.out.println("Locations List: "+locationList);

    }

}


