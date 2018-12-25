package com.course.httpclient.cookies;

import org.apache.http.HttpResponse;
import org.apache.http.client.CookieStore;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.cookie.Cookie;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.util.EntityUtils;
import org.json.JSONException;
import org.json.JSONObject;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.io.IOException;
import java.util.List;
import java.util.Locale;
import java.util.ResourceBundle;

public class MyCookieForPost {
    private String url;
    private ResourceBundle bundle;
    private CookieStore store;

    @BeforeTest
    public void beforeTest() {
        bundle = ResourceBundle.getBundle("application", Locale.CHINA);
        url = bundle.getString("test.url");
    }
    @Test
    public  void testGetCookies() throws IOException {
        String result;
        //从配置文件中拼接URL
        String uri =bundle.getString("getCookies.uri");
        String testUrl=this.url+uri;
        //测试逻辑代码书写
        HttpGet get=new HttpGet(testUrl);
        DefaultHttpClient client=new DefaultHttpClient();
        HttpResponse response=((DefaultHttpClient) client).execute(get);
        result= EntityUtils.toString(response.getEntity(),"utf-8");
        System.out.println(result);
        //获取cookies信息
        this.store =client.getCookieStore();
        List<Cookie> cookieList=store.getCookies();
        for(Cookie cookie:cookieList){
            String name=cookie.getValue();
            String value=cookie.getName();
            System.out.println("value="+value+",  name="+name);
        }

    }
    @Test(dependsOnMethods = {"testGetCookies"})
    public void testGetWithCookies() throws IOException, JSONException {
        String uri=bundle.getString("test.post.with.cookies.uri");
        String testUrl=this.url+uri;

        DefaultHttpClient client=new DefaultHttpClient();
        //声明一个方法这个方式是post方法
        HttpPost post=new HttpPost(testUrl);
        //添加参数
        JSONObject param=new JSONObject();
        param.put("name","huhansan");
        param.put("age","18");
        //请求信息,设置信息
        post.setHeader("Content-Type","application/json");
        //将参数信息添加到方法中
        StringEntity entity=new StringEntity(param.toString());
        post.setEntity(entity);
        //声明一个对象进行响应结果的存储
        String result;
        //设置cookies信息
        client.setCookieStore(this.store);
        //执行post方法
        HttpResponse response=client.execute(post);
        //获取响应结果
        result= EntityUtils.toString(response.getEntity(),"utf-8");
        System.out.println(result);
        //处理结果，就是判断返回结果符合预期
        JSONObject resultJson=new JSONObject(result);
        //将返回的响应结果字符串化为json对象
        //获取到结果值
        String success = (String) resultJson.get("huhansan");
        String status = (String) resultJson.get("status");
        //具体判断返回值
      Assert.assertEquals("success",success);
      Assert.assertEquals("1",status);



    }
}