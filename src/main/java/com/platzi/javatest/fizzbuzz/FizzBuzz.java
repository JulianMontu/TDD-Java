package com.platzi.javatest.fizzbuzz;

public class FizzBuzz {

    public static String isDivisible(int number) {
        String result = "";
        if (number % 3 == 0 && number % 5 == 0) {
            result += "FizzBuzz";

        } else if (number % 5 == 0) {
            result += "buzz";

        } else if (number % 3 == 0) {
            result += "fizz";
        }
        return result.isEmpty() ? String.valueOf(number) : result;
    }
}
