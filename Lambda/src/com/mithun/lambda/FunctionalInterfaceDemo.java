package com.mithun.lambda;

@FunctionalInterface
interface FunInt {
    void printName();
}

@FunctionalInterface
interface FunIntWithDefault {
    int addThree(int a, int b, int c);
    default double mulThree(double a, double b, double c) {
        return a * b * c;
    }
}

public class FunctionalInterfaceDemo {

    public static void main(String[] args) {

    }
}
