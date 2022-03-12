/**
 * 开发团队：复仇者联盟
 * 开发团队领导人：陈浩
 * 开发人员姓名：陈浩
 * 学号/工号：2019112102
 * 个人/公司邮箱：ch111222@qq.com
 * 时间：2022/3/5 13:15
 * 开发名称：TableController
 * 开发工具：IntelliJ IDEA
 * 当前用户：CH
 * 描述：
 */
package com.ch.admin.controller;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.ch.admin.bean.UserMp;
import com.ch.admin.service.UserMpService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;

@Controller
public class TableController {

    @GetMapping("basic_table")
    /** 在这里测试了异常处理 */
    public String basicTable(@RequestParam("a") String a) {
        int i = 10 / 0;
        return "table/basic_table";
    }

    @Autowired
    UserMpService userMpService;

    @GetMapping("dynamic_table")
    public String dynamicTable(@RequestParam(value = "pn", defaultValue = "1") Integer pn, Model model) {
        /**
         ///动态遍历表格
         List<User> users = Arrays.asList(new User("张三", "111"),
         new User("李四", "222"),
         new User("傻逼", "sb"),
         new User("傻逼2", "sb2")
         );
         model.addAttribute("users",users);

         //在这里测试了自定义异常
         if (users.size() > 3) {
         throw new UserTooManyException();
         }*/

/*        List<UserMp> list = userMpService.list();
        model.addAttribute("users1", list);*/

        /**查出分页数据*/
        Page<UserMp> userMpPage = new Page<>(pn, 3);
        /**分页查询的结果*/
        Page<UserMp> page = userMpService.page(userMpPage, null);
        model.addAttribute("page",page);


        return "table/dynamic_table";
    }

    @GetMapping("table/removeById/{id}")
    public String removeById(
            @PathVariable("id") int id,
            @RequestParam(value = "pn",defaultValue = "1") int currentPage,
            RedirectAttributes ra){

        /*重定向携带参数*/
        ra.addAttribute("pn",currentPage);

        boolean b = userMpService.removeById(id);
        return "redirect:/dynamic_table";
    }

    @GetMapping("responsive_table")
    public String responsive_table() {
        return "table/responsive_table";
    }

    @GetMapping("editable_table")
    public String editable_table() {
        return "table/editable_table";
    }
}