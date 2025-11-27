package com.javaconceptoftheday.overrideEx;

public class OverLoadingEx {

    public static void main(String args[]) {

        OverLoadingABC abc = new OverLoadingABC();

        //abc.message(null);

        //abc.messageInt(null);

    }

}

class OverLoadingABC {
    public void message(String s) {
        System.out.println("String is "+s);
    }

    public void message(StringBuffer sb) {
        System.out.println("String is "+sb);
    }

    public void messageInt(Integer i) {
        System.out.println("Integer : "+i);
    }

    public void messageInt(Double f) {
        System.out.println("Float : "+f);
    }

}
