package com.course.testng.groups;

import org.testng.annotations.AfterGroups;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeGroups;
import org.testng.annotations.Test;

public class GroupOnMethod {
    @Test(groups = "server")
    public void test1(){
        System.out.println("z这是服务端11111");
    }
    @Test(groups = "server")
    public void test2(){
        System.out.println("z这是服务端2222");
    }
    @Test(groups = "client")
    public void test3(){
        System.out.println("z这是客服端11111");
    }
    @Test(groups = "client")
    public void test4(){
        System.out.println("z这是客服端2222");
    }
    @BeforeGroups("server")
    public void beforeGroupsOnServer(){
        System.out.println("这是服务端运行之前的运行方法！");
    }
    @AfterGroups("server")
    public void afeterGroupsONServer(){
        System.out.println("这是服务端运行之后运行的方法！");
    }
    @BeforeGroups("client")
    public void beforeGroupsOnClient(){
        System.out.println("这是客户端运行之前的运行方法！");
    }
    @AfterGroups("client")
    public void afeterGroupsONClient(){
        System.out.println("这是客户端运行之后运行的方法！");
    }
}
