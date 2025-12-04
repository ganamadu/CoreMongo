package com.javaconceptoftheday;

import com.core.mongo.coreEx.util.DBUtil;
import com.core.mongo.entity.Emp;

import java.io.IOException;
import java.lang.reflect.Field;
import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;

public class SolarWindEx {

    public static void main(String[] args) throws NoSuchFieldException, IllegalAccessException, IOException {
        String filePath = "src/main/resources/employee.emp.json";
        List<Emp> empList = DBUtil.readEmployeeJson(filePath);
        Test test = new Test();
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
