package com.course.server;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

@RestController
@Api(value="/",description = "这是我全部的get方法")
public class MyGetMethod {
    @RequestMapping(value = "/getCookies", method = RequestMethod.GET)
    @ApiOperation(value="通过这个方法可以获得Cookis")
    public String getCookies(HttpServletResponse response) {
        //HttpSer
        Cookie cookie = new Cookie("login", "true");
        response.addCookie(cookie);
        return "恭喜你获得cookies信息成功!!!!";
    }

    /**
     * 要求客户端携带cookies访问
     * 这是一个需要携带cookies信息才能访问的get请求
     */
    @RequestMapping(value = "/get/with/cookies", method = RequestMethod.GET)
    @ApiOperation(value="需要携带cookies信息才能访问的get请求")
    public String getWithCookies(HttpServletRequest request) {
        Cookie[] cookies = request.getCookies();
        if (Objects.isNull(cookies)) {
            return "你必须带cookies信息来！";
        }
        for (Cookie cookie : cookies) {
            if (cookie.getName().equals("login") &&cookie.getValue().equals("true")) {
                return "这是一个需要带cookie信息才能访问的请求";
            }
        }
        return "你必须带cookies信息来！";
    }
    /**
     * 开发一个需要携带参数才能访问的get请求
     * 第一种实现方法url：key=value&key=value
     * 我们来模拟获取商品列表
     * */
    @RequestMapping(value="/get/with/param",method = RequestMethod.GET)
    @ApiOperation(value="需要携带参数才能访问的get请求方法11111")
    public Map<String,Integer> getlist(@RequestParam Integer start
                                      , @RequestParam Integer end){
        Map<String,Integer>myList=new HashMap<>();
        myList.put("鞋",400);
        myList.put("干脆面",1);
        myList.put("衬衫",300);
        return myList;

    }
    /**
     * 第二种需要携带参数访问的get请求
     * url：ip：port/get/with/param/10/20
     * * */
    @RequestMapping(value="/get/with/param/{start}/{end}",method = RequestMethod.GET)
    @ApiOperation(value="需要携带参数才能访问的get请求方法222222")
    public Map myGetList(@PathVariable Integer start,
                         @PathVariable Integer end){

            Map<String, Integer> myList = new HashMap<>();
        if (start==10 &end==11) {
            myList.put("鞋1", 400);
            myList.put("干脆面", 1);
            myList.put("衬衫", 300);
        }
            return myList;


    }

}