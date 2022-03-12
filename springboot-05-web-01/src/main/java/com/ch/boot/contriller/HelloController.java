/**
 * 开发团队：复仇者联盟
 * 开发团队领导人：陈浩
 * 开发人员姓名：陈浩
 * 学号/工号：2019112102
 * 个人/公司邮箱：ch111222@qq.com
 * 时间：2022/2/23 12:48
 * 开发名称：HelloController
 * 开发工具：IntelliJ IDEA
 * 当前用户：CH
 * 描述：
 */
package com.ch.boot.contriller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
public class HelloController {
    @ResponseBody
//    @RequestMapping(value = "/user",method = RequestMethod.GET)
    @GetMapping("/user")
    public String getUser(){
        return "GET-张三";
    }
    @ResponseBody
//    @RequestMapping(value = "/user",method = RequestMethod.POST)
    @PostMapping("/user")
    public String saveUser(){
        return "POST-张三";
    }

    @ResponseBody
//    @RequestMapping(value = "/user",method = RequestMethod.PUT)
    @DeleteMapping("/user")
    public String putUser(){
        return "PUT-张三";
    }
    @ResponseBody
//    @RequestMapping(value = "/user",method = RequestMethod.DELETE)
    @PutMapping("/user")
    public String deleteUser(){
        return "DELETE-张三";
    }
}