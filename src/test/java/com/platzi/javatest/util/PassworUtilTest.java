package com.platzi.javatest.util;

import org.junit.Test;

import static com.platzi.javatest.util.PassworUtil.*;
import static org.junit.Assert.*;

public class PassworUtilTest {

    @Test
    public  void weak_when_has_less_than_8_letters() {
        assertEquals(SecurityLevel.WEAK, assesPassword("123aa!"));
    }
    @Test
    public  void weak_when_has_only_letters() {
        assertEquals(SecurityLevel.WEAK, assesPassword("abcdefghjk"));
    }
    @Test
    public  void medium_when_has_only_letters_and_numbers() {
        assertEquals(SecurityLevel.MEDIUM, assesPassword("abcd12345"));
    }
    @Test
    public  void strong_when_has_only_letters_numbers_and_symbols() {
        assertEquals(SecurityLevel.STRONG, assesPassword("abcd1234!"));
    }
}