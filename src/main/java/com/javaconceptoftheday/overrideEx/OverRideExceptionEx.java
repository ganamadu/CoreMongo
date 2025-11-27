package com.javaconceptoftheday.overrideEx;

import java.io.IOException;
import java.sql.SQLException;

public class OverRideExceptionEx {
}

class OverRideParent {

    public void message() throws NullPointerException {
        System.out.println("This is OverRideBase class message ");
    }

}

class OverRideChild extends  OverRideParent {
    public void message() throws NullPointerException {
        System.out.println("This is OverRideBase class message ");
    }
}

