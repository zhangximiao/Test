package com.course.testng.paramter;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.lang.reflect.Method;

public class DateaProviderTest {
    @Test(dataProvider = "data")
    public void testDataProvider(String name ,int age){
        System.out.println("name="+name+";age="+age);
    }
    @DataProvider(name="data")
    public Object[][] providerDate(){
        Object [][] o=new Object[][]{
                {"zhangsan",10},
                {"lisi",20},
                {"wangshwu",30}
        };
        return o;
    }
    @Test(dataProvider = "methodDate")
    public void testMethod1(String name ,int age){
        System.out.println("name="+name+";age="+age);
    }
    @Test(dataProvider = "methodDate")
    public void testMethod2(String name ,int age){
        System.out.println("name="+name+";age="+age);
    }
    @DataProvider(name="methodDate")
    public Object[][] providerDataMethod(Method method){
        Object [][] o=null;
        if(method.getName().equals("testMethod1")){
            o=new Object[][]{
                    {"zhangsan",30},
                    {"lisi",40}
            };
        }
        if(method.getName().equals("testMethod2")){
            o=new Object[][]{
                    {"lisi",40},
                    {"wangwu",50}
            };
        }

        return o;
    }
}
