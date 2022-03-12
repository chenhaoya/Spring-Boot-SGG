/**
 * 开发团队：复仇者联盟
 * 开发团队领导人：陈浩
 * 开发人员姓名：陈浩
 * 学号/工号：2019112102
 * 个人/公司邮箱：ch111222@qq.com
 * 时间：2022/2/25 20:42
 * 开发名称：RequestController
 * 开发工具：IntelliJ IDEA
 * 当前用户：CH
 * 描述：
 */
package com.ch.boot.contriller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
public class RequestController {
    @RequestMapping("goto")
    public String goToPage(HttpServletRequest request) {
        request.setAttribute("msg", "geto方法转发请求");
        request.setAttribute("code", 200);
        return "forward:/success"; //转发到success请求
    }


    /**测试复杂参数*/
    @RequestMapping("param")
    public String testParam(Map<String, String> map,
                            Model model,
                            HttpServletRequest httpServletRequest,
                            HttpServletResponse httpServletResponse
    ) {
        map.put("map","map.put");
        model.addAttribute("model","model");
        httpServletRequest.setAttribute("request","request");

        Cookie cookie = new Cookie("response", "response");
        httpServletResponse.addCookie(cookie);

        return "forward:/success";
    }


    @ResponseBody
    @GetMapping("success")
    public Map success(
            @RequestAttribute(value = "msg",required = false) String a,
            @RequestAttribute(value = "code",required = false) Integer b,
            HttpServletRequest request
    ) {
        Object msg = request.getAttribute("msg");
        Map<String, Object> map = new HashMap<>();
        map.put("msg", a);
        map.put("code", b);
        map.put("reqMethod_msg", msg);


        Object map1 = request.getAttribute("map");
        Object model = request.getAttribute("model");
        Object request1 = request.getAttribute("request");
        Object response = request.getAttribute("response");

        map.put("map",map1);
        map.put("model",model);
        map.put("request",request1);
        map.put("response",response);

        return map;
    }

    /**
     * 1.语法 /cars/shell;low=34;brand=byd,audi,yd
     * 2.spring boot默认禁用 矩阵变量功能
     * 需要手动开启
     * 3.矩阵变量必须有URL路径变量才能被解析
     */
    @ResponseBody
    @GetMapping("/cars/{path}")
    public Map carsSell(
            @MatrixVariable("low") String low,
            @MatrixVariable("brand") List<String> brand,
            @PathVariable("path") String path
    ) {
        Map<String, Object> map = new HashMap<>();
        map.put("low", low);
        map.put("brand", brand);

        map.put("path", path);
        return map;
    }

    /**
     * 语法：/boss/1;age=20/2;age=10
     */
    @ResponseBody
    @GetMapping("/boss/{bossID}/{empID}")
    public Map carSell2(
            @MatrixVariable(value = "age", pathVar = "bossID") String bossAge,
            @MatrixVariable(value = "age", pathVar = "empID") String empAge
    ) {
        Map<String, Object> map = new HashMap<>();
        map.put("bossAge", bossAge);
        map.put("empAge", empAge);

        return map;
    }

}