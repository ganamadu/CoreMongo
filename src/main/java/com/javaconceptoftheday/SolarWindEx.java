package com.javaconceptoftheday;

import com.core.mongo.coreEx.util.DBUtil;
import com.core.mongo.entity.Emp;

import java.io.IOException;
import java.lang.reflect.Field;
import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class SolarWindEx {

    public static void main(String[] args) throws NoSuchFieldException, IllegalAccessException, IOException {
        String filePath = "src/main/resources/employee.emp.json";
        List<Emp> empList = DBUtil.readEmployeeJson(filePath);
        Test test = new Test1();
        test.name = "Abc";
        new Test(test);
        System.out.println("This is SolarWindEx Main class...");

        new Test1();

        ArrayList<Integer> list = new ArrayList<>();
        Field field = ArrayList.class.getDeclaredField("elementData");
        //field.setAccessible(true);
        //Object[] internalArray = (Object[]) field.get(list);
        //System.out.println(field.get(internalArray.length));
        list.trimToSize();
        System.out.println(list);
        list.add(1);
        list.trimToSize();
        System.out.println(list);

        //How to Map value sort
        Map<Integer, Emp> empMap = empList.stream().collect(Collectors.toMap(Emp::getEmpno, Function.identity()));
        System.out.println(empMap);

        empMap.entrySet().stream().sorted(Comparator.comparing((Map.Entry<Integer, Emp> m)->m.getValue().getSal())
                .thenComparing(m->m.getValue().getEname())).forEach((m) -> {
                    System.out.println(m.getValue().getSal()+" "+m.getValue().getEname());
        });
        System.out.println("\nSort by Map Values: ");
        empMap.entrySet()
                .stream()
                .sorted(Map.Entry.comparingByValue(Comparator.comparing(Emp::getSal, Comparator.reverseOrder()).thenComparing(Emp::getEname)))
                .forEach(m->{
                    System.out.println(m.getKey()+"  "+m.getValue().getEname()+"  "+m.getValue().getSal());
                });

        splitListBasedOnFactor(IntStream.range(1,57).boxed().collect(Collectors.toList()), 4);

    }


    public static void splitListBasedOnFactor(List<Integer> numList, int factor) {
        int total = numList.size();
        int chunkSize = (int)Math.ceil((double) total/factor);
        for(int i=0; i<factor; i++) {
            int from = (i*chunkSize)+1;
            int to = Math.min((i+1)*chunkSize, total);
            System.out.println("From: "+from+" To: "+to);
        }

    }

}



class Test {
    String name;
    Test() {
        System.out.println("This is Test class constructor....");
    }

    Test(Test t) {
        this.name = t.name;
        System.out.println("This is Test class copy constructor....");
    }

}

class Test1 extends Test {
    Test1(){
        System.out.println("Test1 child class constructor...");
    }
}
