package com.course.testng;

import org.testng.annotations.Test;

public class IgnoreTest {
    //当需要忽略某个或某组测试用例的时候 设置enable为false
    @Test
    public void ignoreTest1(){
    System.out.println("ignoreTest1");
    }
    @Test(enabled = false)
    public void ignoreTest2(){
        System.out.println("ignoreTest2");
    }
    @Test(enabled = true)
    public void ignoreTest3(){
        System.out.println("ignoreTest3");
    }
}
