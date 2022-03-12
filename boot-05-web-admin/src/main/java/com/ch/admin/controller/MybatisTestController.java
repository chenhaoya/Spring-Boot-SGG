/**
 * 开发团队：复仇者联盟
 * 开发团队领导人：陈浩
 * 开发人员姓名：陈浩
 * 学号/工号：2019112102
 * 个人/公司邮箱：ch111222@qq.com
 * 时间：2022/3/9 21:13
 * 开发名称：MybatisTestController
 * 开发工具：IntelliJ IDEA
 * 当前用户：CH
 * 描述：
 */
package com.ch.admin.controller;

import com.ch.admin.bean.Account;
import com.ch.admin.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class MybatisTestController {

    @Autowired
    AccountService accountService;

    @ResponseBody
    @GetMapping("acct")
    public Account getAccountById(Long id){
        Account accountById = accountService.getAccountById(id);
        return accountById;
    }
}