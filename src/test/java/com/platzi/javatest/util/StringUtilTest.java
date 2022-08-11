package com.platzi.javatest.util;
public class StringUtilTest {
    public static void main(String[] args) {
        String result = StringUtil.repeat("Hola",3);
        System.out.println(result);
        if (result.equals("HolaHolaHola")){
            System.out.println("Ok");
        }

    }

}