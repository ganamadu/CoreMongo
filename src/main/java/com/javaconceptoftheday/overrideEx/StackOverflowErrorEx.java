package com.javaconceptoftheday.overrideEx;

public class StackOverflowErrorEx {

    public static void main(String[] args) {
        new StackOverFlowABC().methodABC();
    }

}

class StackOverFlowABC {
    void methodABC() {
        new StackOverFlowXYZ().methodXYZ();
    }
}

class StackOverFlowXYZ extends StackOverFlowABC {
    void methodXYZ() {
        methodABC();;
    }
}
