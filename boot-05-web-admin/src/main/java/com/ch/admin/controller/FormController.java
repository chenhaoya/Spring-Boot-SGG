/**
 * 开发团队：复仇者联盟
 * 开发团队领导人：陈浩
 * 开发人员姓名：陈浩
 * 学号/工号：2019112102
 * 个人/公司邮箱：ch111222@qq.com
 * 时间：2022/3/6 20:21
 * 开发名称：FormController
 * 开发工具：IntelliJ IDEA
 * 当前用户：CH
 * 描述：
 */
package com.ch.admin.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;

@Controller
@Slf4j
public class FormController {
    /**
     * 测试文件上传
     * */
    @GetMapping("form_layouts")
    public String form_layouts(){
        return "forms/form_layouts";
    }

    /**
     * 处理上传请求
     * MultipartFile：自动封装上传来的文件
     * */
    @PostMapping("upload")
    public String upload(@RequestParam("email") String email,
                         @RequestParam("password") String pwd,
                         @RequestPart("file_input") MultipartFile file1,
                         @RequestPart("file_inputs") MultipartFile[] files) throws IOException {

        log.info("上传的信息：email={}，password={}，file_input={}，file_inputs={}",
                email,pwd,file1.getSize(),files.length);

        if (!file1.isEmpty()) {
            /*保存对象到服务器：OSS服务器*/
            String originalFilename = file1.getOriginalFilename();
            file1.transferTo(new File("E:\\SpringBoot-sgg\\boot-05-web-admin\\src\\main\\resources\\upload\\file\\"+originalFilename));
        }

        if (files.length > 0) {
            for (MultipartFile i: files) {
                if (!i.isEmpty()) {
                    String originalFilename = i.getOriginalFilename();
                    i.transferTo(new File("E:\\SpringBoot-sgg\\boot-05-web-admin\\src\\main\\resources\\upload\\files\\"+originalFilename));
                }
            }
        }

        return "index";
    }
}