package com.tester.extent.demo;

import org.testng.Assert;
import org.testng.annotations.Test;

public class TestMethodsDemo {
    @Test
    public void test1() {
        System.out.println("hello world111");
        Assert.assertEquals(1, 2);
    }

    @Test
    public void test2() {
        System.out.println("hello world2222");
        Assert.assertEquals(1, 1);
    }

    @Test
    public void test3() {
        System.out.println("hello world333");
        Assert.assertEquals("aaa", "aaa");
    }
    @Test
    public void logdemo(){
        System.out.println("hello world4444");
        throw new RuntimeException("这是我自己抛出的异常");
    }
}
