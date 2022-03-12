/**
 * 开发团队：复仇者联盟
 * 开发团队领导人：陈浩
 * 开发人员姓名：陈浩
 * 学号/工号：2019112102
 * 个人/公司邮箱：ch111222@qq.com
 * 时间：2022/2/17 13:07
 * 开发名称：HelloController
 * 开发工具：IntelliJ IDEA
 * 当前用户：CH
 * 描述：
 */
package com.ch.boot.controller;

import com.ch.boot.bean.Car;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;


@Controller
public class HelloController {

    @Autowired
    private Car car;

    @ResponseBody
    @RequestMapping("/car")
    public Car car(){
        return car;
    }


    @ResponseBody
    @RequestMapping("/hello2")
    public String hello(){
        return "hello SpringBoot 2";
    }

}