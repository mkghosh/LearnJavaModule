package com.mithun.prac1;

import java.util.function.Function;

public class Practice1 {

    /*
    Given that fahrenheit=60
    2a) Convert Fahrenheit into celsius formula = (Fahrenheit - 32) * 5/9 = celsius
    2b) Convert Celsius into fahrenheit formula = Celsius * 9/5 + 32 = Fahrenheit
     */

    /*
    Given that inches = 20
    3a) Convert inches into centimeters formula = inches * 2.54 = cm
    3b) Convert centimeters into inches formula = cm * 0.39 = inches
     */


    public static void main(String[] args) {

      /*
        problem one
        1a) Output the area of suare when a side is 3
        1b) Output the area of a rectangle width=4 and height=3
        1c) Output the area of a triangle height=8, base=2
      */
        //Calculating the area of a square using Function interface
        Function<Double, Double> areaOfSquare = length -> length * length;

        //Converting temp from farh to cel
        Function<Double, Double> farhToCelsius = farh -> (farh - 32) * 5.0 / 9.0;
        //Converting temp from cel to farh
        Function<Double, Double> celToFarh = cel -> cel * 9.0 / 5.0 + cel;

        System.out.println("The Area of a Square with length 3 is : " + areaOfSquare.apply(3.0));
        System.out.println("The celsius equivalent of 60 deg farh is : " + farhToCelsius.apply(60.0));
        System.out.println("The farh equivalent of 60 deg farh is : " + celToFarh.apply(60.0));

        //Function andThen demo
        Function<String, String> fun1 = String::toUpperCase;
        Function<String, String> fun2 = s -> s + " World";

        //Output of fun1
        System.out.println("Output of fun1 " + fun1.apply("Hello"));
        //Output of andThen
        System.out.println("Output of andThen " + fun1.andThen(fun2).apply("Hello"));
    }
}
