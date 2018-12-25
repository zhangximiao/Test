package com.course.testng;

import org.testng.annotations.Test;

public class ExpectedException {
    /**
     * 什么时候回用到异常测试
     * 我们期望结果为某一个异常的时候
     * 比如：我们传入了某些不合法的参数，程序抛出了异常
     * 也就是我们预期的结果就是这个异常

    @Test(expectedExceptions = RuntimeException.class)
    public  void runTimeExceptionFail(){
        System.out.println("z这是一个失败的异常测试！");
    }
     */
    @Test(expectedExceptions = RuntimeException.class)
    public  void runTimeExceptionSuccess(){
        System.out.println("z这是一个成功的异常测试！");
        //抛出异常应写最后，不然后面的代码不能执行
        throw new RuntimeException();
    }
}