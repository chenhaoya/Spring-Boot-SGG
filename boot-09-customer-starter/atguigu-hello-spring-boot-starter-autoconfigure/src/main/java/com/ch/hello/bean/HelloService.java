/**
 * 开发团队：复仇者联盟
 * 开发团队领导人：陈浩
 * 开发人员姓名：陈浩
 * 学号/工号：2019112102
 * 个人/公司邮箱：ch111222@qq.com
 * 时间：2022/3/11 22:44
 * 开发名称：HelloService
 * 开发工具：IntelliJ IDEA
 * 当前用户：CH
 * 描述：
 */
package com.ch.hello.bean;

import com.ch.hello.HelloProperties;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * 默认不放容器中
 * */
public class HelloService {

    @Autowired
    HelloProperties helloProperties;

    public String sayHello(String userName){
        return helloProperties.getPrefix()+":"+userName+":"+helloProperties.getSuffix();
    }
}