package com.ch.admin;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletComponentScan;


/**basePackages:不写扫描域；自动扫描主包*/
@ServletComponentScan(basePackages = "com.ch.admin")
@SpringBootApplication
@MapperScan("com.ch.admin.mapper")
public class Boot05WebAdminApplication {

    public static void main(String[] args) {
        SpringApplication.run(Boot05WebAdminApplication.class, args);
    }

}
