/**
 * 开发团队：复仇者联盟
 * 开发团队领导人：陈浩
 * 开发人员姓名：陈浩
 * 学号/工号：2019112102
 * 个人/公司邮箱：ch111222@qq.com
 * 时间：2022/3/5 10:58
 * 开发名称：IndexController
 * 开发工具：IntelliJ IDEA
 * 当前用户：CH
 * 描述：
 */
package com.ch.admin.controller;

import com.ch.admin.bean.User;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpSession;
import javax.sql.DataSource;

@Controller
@Slf4j
public class IndexController {
    /**
     * 测试拿redis数据
     * */
    @Autowired
    StringRedisTemplate redisTemplate;


    @Autowired
    JdbcTemplate jdbcTemplate;
    @GetMapping("/sql")
    @ResponseBody
    public String getUser(){
        Long aLong = jdbcTemplate.queryForObject("select concat(1) from tb_emp1", Long.class);
        return aLong.toString();
    }

    /**
     * 登录页面
     * */
    @GetMapping(value = {"/","/login"})
    public String loginPage(){
        return "login";
    }

    /**
     *  表单提交账户密码，跳转到首页
     * */
    @PostMapping("/login")
    public String main(User user, HttpSession session, Model model){
        if (StringUtils.hasText(user.getUserName()) && StringUtils.hasText(user.getPassword())) {
            /*把登录成功的用户保存起来*/
            session.setAttribute("loginUser",user);
            return "redirect:index.html";
        }else {
            model.addAttribute("msg","账户或密码错误");
            return "/login";
        }
    }
    /**
     * 如果在index页面刷新网页，又会重复提交表单
     * 解决
     * */
    @GetMapping("/index.html")
    public String mainPage(HttpSession session,Model model){
        log.info("当前拦截方式是{}","index.html");

/*        //是否登录
        Object loginUser = session.getAttribute("loginUser");
        if (loginUser != null) {
            //真正去首页
            return "index";
        }
        model.addAttribute("msg","未登录");
        return "login";*/

        ValueOperations<String, String> operations = redisTemplate.opsForValue();
        String s = operations.get("/index.html");
        String s2 = operations.get("/dynamic_table");

        model.addAttribute("indexCount",s);
        model.addAttribute("dynamic_table_Count",s2);

        return "/index";
    }


}