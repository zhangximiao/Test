package com.course.httpclient.cookies;

import org.apache.http.HttpResponse;
import org.apache.http.client.CookieStore;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.cookie.Cookie;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.util.EntityUtils;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.io.IOException;
import java.util.List;
import java.util.Locale;
import java.util.ResourceBundle;

public class MyCookiesForGet {
    private String url;
    private ResourceBundle bundle;
    private CookieStore store;
    @BeforeTest
    public  void beforeTest(){
        bundle=ResourceBundle.getBundle("application", Locale.CHINA);
        url=bundle.getString("test.url");
    }
    @Test
    public  void testGetCookies() throws IOException {
        String result;
        //从配置文件中拼接URL
        String uri =bundle.getString("getCookies.uri");
        String testUrl=this.url+uri;
        //测试逻辑代码书写
        System.out.println(testUrl);
        HttpGet get=new HttpGet(testUrl);
        DefaultHttpClient client=new DefaultHttpClient();
        HttpResponse response=client.execute(get);
        result= EntityUtils.toString(response.getEntity(),"utf-8");
        System.out.println(result);
        //获取cookies信息
        this.store =client.getCookieStore();
        List<Cookie> cookieList=store.getCookies();
        for(Cookie cookie:cookieList){
            String name=cookie.getValue();
            String value=cookie.getName();
            System.out.println("value="+value+",    name="+name);
        }
    }
    @Test(dependsOnMethods = {"testGetCookies"})
    public void testGetWithCookies() throws IOException {
        //从配置文件中拼接URL
        String uri =bundle.getString("getWithCookies.uri");
        String testUrl=this.url+uri;
        //测试逻辑代码书写
        HttpGet get=new HttpGet(testUrl);
        DefaultHttpClient client=new DefaultHttpClient();
        //设置cookies方法
        client.setCookieStore(this.store);
        HttpResponse response=client.execute(get);
        //获取响应的状态码
        int statusCode=response.getStatusLine().getStatusCode();
        System.out.println("statusCode="+statusCode);
        if(statusCode==200){
            String  result= EntityUtils.toString(response.getEntity(),"utf-8");
            System.out.println(result);
        }
    }
}
