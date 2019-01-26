package com.course.httpclient;

import org.apache.http.HttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.util.EntityUtils;
import org.testng.annotations.Test;


import java.io.IOException;

public class demo {
    @Test
    public  void test1() throws IOException {
        //结果字符串
        String result=null;
        HttpGet get =new HttpGet("http://www.baidu.com");
        //这个是用来执行get方法的
        DefaultHttpClient client= new DefaultHttpClient();
        HttpResponse response= client.execute(get);
        result=EntityUtils.toString(response.getEntity(),"utf-8");
        System.out.println(result);
    }
}
