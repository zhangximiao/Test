package com.course.testng.groups;

import org.testng.annotations.Test;

@Test(groups = "teacher")
public class GroupsOnClass3 {
    public void tea1(){
        System.out.println("这是teacher1111运行的方法1111");
    }
    public void tea2(){
        System.out.println("这是teacher2222运行的方法2222");
    }
}
