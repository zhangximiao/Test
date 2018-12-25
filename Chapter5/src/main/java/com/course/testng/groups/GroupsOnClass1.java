package com.course.testng.groups;

import org.testng.annotations.Test;

@Test(groups = "stu")
public class GroupsOnClass1 {
    public void stu1(){
        System.out.println("这是stu11111运行的方法1111");
    }
    public void stu2(){
        System.out.println("这是stu11111运行的方法2222");
    }
}
