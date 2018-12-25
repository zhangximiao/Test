package com.course.testng.suite;

import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;

public class SuiteConfig {
    @BeforeSuite
    public void beforeSuite(){
        System.out.println("这是开始套件");
    }
    @AfterSuite
    public void afterSuite(){
        System.out.println("这是结束套件");
    }
    @BeforeTest
    public  void beforeTest(){
        System.out.println("beforeTest");
    }
    @AfterTest
    public void afterTest(){
        System.out.println("afterTest");
    }
}
