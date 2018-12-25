package com.course.testng;


import org.testng.annotations.*;

public class BasicAnnotation {

   @Test
   protected void testCase1(){
       System.out.println("this is test11111 class");
    }
    @Test
    protected void testCase2(){
        System.out.println("this is test22222 class");
    }
    @BeforeMethod
    public void beforeMethod() {
        System.out.println("this is beforeMethod class");
    }
    @AfterMethod
    public void afterMethod(){
        System.out.println("this is afterMethod class");
    }
    @BeforeClass
    public void beforeClass() {
        System.out.println("this is before class");
    }
    @BeforeSuite
    public void beforeSuit(){
        System.out.println("this is beforeSuit class");
    }
    @AfterSuite
    public void AfterSuit(){
        System.out.println("this is AfterSuit class");
    }

    @AfterClass
    public void afterClass() {
        System.out.println("this is after class");
    }
}
