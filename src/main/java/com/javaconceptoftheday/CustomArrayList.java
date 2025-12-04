package com.javaconceptoftheday;

public class CustomArrayList<E> {

    public static final int INITIAL_CAPACITY = 10;
    private Object[] elements;
    private int size;

    private CustomArrayList() {
        elements = new Object[INITIAL_CAPACITY];
    }




}
