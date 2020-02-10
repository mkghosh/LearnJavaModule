package com.mithun.lambda;

interface HelloInterface {
    void displayHello();

    default int addition(int a, int b) {
        return a + b;
    }
}

interface FunToMethod {
    double multipleOfTwo(double a, double b);
}

interface MethodRef {
    void helloMRef();
}

public class HelloLambda {

    //Method Reference Example
    static void helloRef () {
        System.out.println("From Method reference");
    }

    public static void main(String[] args) {
        /*
        //Lambda demo
        HelloInterface helloInterface = () -> System.out.println("Hello From lambda");
        helloInterface.displayHello();
        System.out.println(helloInterface.addition(45,56));

        FunToMethod fun = (a,b) -> a* b;
        printMultiple(fun);*/

        //Method Ref by :: demo
        MethodRef ref = HelloLambda::helloRef;
        ref.helloMRef();
    }

    public static void printMultiple(FunToMethod funToMethod) {
        System.out.println("Starting to see lambda way");
        System.out.println("The multiple of numbers 45.8 and 9.89 is : " + funToMethod.multipleOfTwo(45.8,9.89));
    }
}
