package com.mithun.udemy;

public class PassingByValue {
    public static void main(String[] args) {
        PassingByValue pv = new PassingByValue();
        //Passing by value
        int value = 7;
        pv.show(value);

        //passing by reference is not available in java.
    }

    public void show(int value) {
        System.out.println("Value is : " + value);
    }
}
