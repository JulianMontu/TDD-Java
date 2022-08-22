package com.platzi.javatest.stringUtil;

public class StringUtil {

    public boolean isEmpty(String str) {
        return str == null || str.trim().length() <= 0;
    }
}
