package com.platzi.javatest.fizzbuzz;

import org.junit.Test;

import static org.hamcrest.CoreMatchers.*;
import static org.junit.Assert.*;

public class FizzBuzzShould {
    FizzBuzz fizzBuzz = new FizzBuzz();

    @Test
    public void number_divisible_by_3() {
        assertThat(fizzBuzz.isDivisible(3),is("fizz"));
    }

    @Test
    public void number_divisible_by_5() {
        assertThat(fizzBuzz.isDivisible(5),is("buzz"));
    }

    @Test
    public void number_divisible_by_3_and_5() {
        assertThat(fizzBuzz.isDivisible(15),is("FizzBuzz"));
    }

    @Test
    public void number_is_not_divisible_by_3_and_5() {
        int number=2;
        assertThat(fizzBuzz.isDivisible(number),is(String.valueOf(number)));
    }
}