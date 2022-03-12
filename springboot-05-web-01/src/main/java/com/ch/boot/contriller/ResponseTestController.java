/**
 * 开发团队：复仇者联盟
 * 开发团队领导人：陈浩
 * 开发人员姓名：陈浩
 * 学号/工号：2019112102
 * 个人/公司邮箱：ch111222@qq.com
 * 时间：2022/3/1 21:52
 * 开发名称：ResponseTestController
 * 开发工具：IntelliJ IDEA
 * 当前用户：CH
 * 描述：
 */
package com.ch.boot.contriller;

import com.ch.boot.bean.Person;
import org.springframework.core.io.FileSystemResource;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Date;

@Controller
public class ResponseTestController {

    /**标注@ResponesBody的
     * 使用：RequestResponseBodyMethodProcessor 处理器处理
     * 在底层调用具体的MessageConverter转换数据  返回文件类型
     * */
    @ResponseBody
    @GetMapping("")
    public FileSystemResource fileSystemResource(){

        return null;
    }


    /**
     * 在这里测试 内容协商原理
     * 在这里测试 自定义messageConverter
     * 需求：
     * 1. 浏览器发送请求，返回xml     【application/xml】 找到    JasksonXmlConverter 处理
     * 2. ajax请求，返回 json                 【application/json】 找到  JasksonJsonConverter 处理
     * 3. 某个app发请求，返回自定义协议数据   【application/x-guigu】 找到 xxxConverter 处理
     *             Person 属性1 ；属性2；   两个属性之间用分号隔开
     * 步骤：
     * 1. 添加一个自定义的MessageConverter 进系统底层
     * 2. 系统底层就会统计出所有Message Converter能操作哪些类型
     * 3. 客户端类容协商  【客户端需要：x-guigu----> 服务器有：x-guigu converter】
     * */
    @ResponseBody
    @GetMapping("/person")
    public Person getPerson(){
        Person person = new Person();
        person.setAge(22);
        person.setBirth(new Date());
        person.setUserName("张三");
        return person;
    }
}