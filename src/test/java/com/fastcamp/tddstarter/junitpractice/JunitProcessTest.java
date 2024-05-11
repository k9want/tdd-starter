package com.fastcamp.tddstarter.junitpractice;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class JunitProcessTest {

    public JunitProcessTest() {
        System.out.println("Constructor");
    }

    @BeforeAll // static 메서드로 선언해야함
    public static void classAll() {
        System.out.println("BeforeAll");
    }

    @BeforeEach
    public void classEach() {
        System.out.println("BeforeEach");
    }

    @Test
    public void testForTest1() {
        System.out.println("Test1");
    }

    @Test
    public void testForTest2() {
        System.out.println("Test2");
    }

    @AfterEach
    public void classAfterEach() {
        System.out.println("AfterEach");
    }
    @AfterAll // static 메서드로 선언해야함
    public static void classAfterAll() {
        System.out.println("AfterAll");
    }



}
