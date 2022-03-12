/**
 * 开发团队：复仇者联盟
 * 开发团队领导人：陈浩
 * 开发人员姓名：陈浩
 * 学号/工号：2019112102
 * 个人/公司邮箱：ch111222@qq.com
 * 时间：2022/3/11 21:15
 * 开发名称：HelloController
 * 开发工具：IntelliJ IDEA
 * 当前用户：CH
 * 描述：
 */
package com.ch.boot.controller;

import com.ch.boot.bean.Person;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class HelloController {

    @Value(("${person.name:默认值}"))
    String name;

    @ResponseBody
    @GetMapping("/")
    public String hello(){
        return "hello"+ name ;
    }

    @Autowired
    private Person person;

    @ResponseBody
    @GetMapping("/person2")
    public String person2(){
        return person.getClass().toString();
    }
    @ResponseBody
    @GetMapping("/person")
    public Person person(){
        return person;
    }
    /**
     * 上面代码用于测试：Profile功能
     *
     * 下面代码用于测试：外部化配置
     * */

    //系统变量取值
    @Value("${MAVEN_HOME}")
    String msg;

    @ResponseBody
    @GetMapping("/msg")
    String getMsg(){
        return msg;
    }

    //系统名字
    @Value("${os.name}")
    String osName;
    @ResponseBody
    @GetMapping("/os")
    String getOsName(){
        return osName;
    }
}