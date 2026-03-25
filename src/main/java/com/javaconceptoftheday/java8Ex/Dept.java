package com.javaconceptoftheday.java8Ex;

public record Dept(Integer deptNo, String dName, String loc)  implements MyInterface{


    @Override
    public void run() {
        System.out.println("This is run method form Dept Record Class");
    }
}
