/**
 * 开发团队：复仇者联盟
 * 开发团队领导人：陈浩
 * 开发人员姓名：陈浩
 * 学号/工号：2019112102
 * 个人/公司邮箱：ch111222@qq.com
 * 时间：2022/3/6 13:15
 * 开发名称：AdminWebConfig
 * 开发工具：IntelliJ IDEA
 * 当前用户：CH
 * 描述：
 */
package com.ch.admin.config;

import com.ch.admin.interceptor.LoginInterceptor;
import com.ch.admin.interceptor.RedisUrlCountInterceptor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;


/**
 * 1、编写一个拦截器，实现HandlerInterceptor接口
 * 2、拦截器注册到容器中，（实现WebMvcConfigurer的addInterceptors）
 * 3、指定拦截规则【静态资源拦截问题  /* 和 /**】
 */
@Configuration
public class AdminWebConfig implements WebMvcConfigurer {

    /**
     * Filter 和 Interceptor  几乎拥有相同的功能，用哪个好； 区别？
     * filter ： 他是Servlet定义原生组件  有点：脱离Spring应用也能使用
     * Interceptor：是Spring定义的接口。可以使用Spring自动装配的功能等
     * */
    @Autowired
    RedisUrlCountInterceptor redisUrlCountInterceptor;

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(new LoginInterceptor())
                .addPathPatterns("/**")
                .excludePathPatterns("/","/login","/css/**","/fonts/**","/images/**","/js/**","/error");
        /**这里注意，如果时new出来的，那么它内部的自动注入就无法注入，应为自动注入条件时：当前对象在容器中*/
        registry.addInterceptor(redisUrlCountInterceptor)
                .addPathPatterns("/**")
                .excludePathPatterns("/","/login","/css/**","/fonts/**","/images/**","/js/**","/error");
    }
}