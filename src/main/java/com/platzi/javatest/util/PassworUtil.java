package com.platzi.javatest.util;

import java.security.Security;

public class PassworUtil {
    public  enum  SecurityLevel {
        WEAK,MEDIUM,STRONG
    }
    public static SecurityLevel assesPassword(String password) {
        if(password.length()<8){
            return SecurityLevel.WEAK;
        }
        //Validar una expresion regular
        if (password.matches("[A-Z-a-z]+")){
            return SecurityLevel.WEAK;
        }
        if ((password.matches("[A-Z-a-z0-9]+"))){
            return SecurityLevel.MEDIUM;
        }

        return SecurityLevel.STRONG;

    }
}
