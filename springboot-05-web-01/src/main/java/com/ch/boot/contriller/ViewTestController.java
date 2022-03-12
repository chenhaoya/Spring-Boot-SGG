/**
 * 开发团队：复仇者联盟
 * 开发团队领导人：陈浩
 * 开发人员姓名：陈浩
 * 学号/工号：2019112102
 * 个人/公司邮箱：ch111222@qq.com
 * 时间：2022/3/5 10:29
 * 开发名称：ViewTestController
 * 开发工具：IntelliJ IDEA
 * 当前用户：CH
 * 描述：
 */
package com.ch.boot.contriller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class ViewTestController {
    @RequestMapping("/atguigu")
    public String atguigu(Model model){
        /**Model 中的数据会被放到请求域中
         *  request.setAttribute
         * */
        model.addAttribute("msg","aaa");
        model.addAttribute("link","https://www.baidu.com");
        return "success";
    }
}