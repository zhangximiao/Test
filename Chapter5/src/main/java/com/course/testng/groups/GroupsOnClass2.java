package com.course.testng.groups;

import org.testng.annotations.Test;

@Test(groups = "stu")
public class GroupsOnClass2 {
    public void stu3(){
        System.out.println("这是stu2222运行的方法1111");
    }
    public void stu4(){
        System.out.println("这是stu2222运行的方法2222");
    }
}
