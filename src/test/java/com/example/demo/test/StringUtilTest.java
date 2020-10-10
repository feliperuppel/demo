package com.example.demo.test;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class StringUtilTest {

    final StringUtil stringUtil = new StringUtil();

    @Test
    public void testFindFirstNonRepetitiveChar(){
        test("b", "aabc");
    }

    @Test
    public void testFindFirstNonRepetitiveCharWhenThereIsNot(){
        test("", "aaaa");
    }

    @Test
    public void testEmptyImput(){
        test("", "");
    }

    @Test
    public void testNullImput(){
        test("", null);
    }

    @Test
    public void testBlankImput(){
        test("", "  ");
    }

    @Test
    public void testAllNonRepeting(){
        test("a", "abcd");
    }

    @Test
    public void testWithSpaceInTheMiddle(){
        test("a", "bbb add");
    }

    @Test
    public void testWithInitialSpace(){
        test("a", " bbba");
    }

    private void test(final String expectedResult, final String input){
        String result = stringUtil.findFirstNotRepetingChar(input);
        Assertions.assertEquals(expectedResult, result);
    }
}
