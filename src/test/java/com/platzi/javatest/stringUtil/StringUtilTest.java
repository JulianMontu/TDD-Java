package com.platzi.javatest.stringUtil;

import org.junit.Test;

import static org.junit.Assert.*;

public class StringUtilTest {
    StringUtil stringUtil = new StringUtil();

    @Test
    public void string_empty() {
        assertTrue(stringUtil.isEmpty(""));

    }
    @Test
    public void string_null() {
        assertTrue(stringUtil.isEmpty(null));
    }

    @Test
    public void string_not_empty() {
        assertFalse(stringUtil.isEmpty("Hola mundo"));

    }
}