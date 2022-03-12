/**
 * 开发团队：复仇者联盟
 * 开发团队领导人：陈浩
 * 开发人员姓名：陈浩
 * 学号/工号：2019112102
 * 个人/公司邮箱：ch111222@qq.com
 * 时间：2022/3/9 8:44
 * 开发名称：MyRegisConfig
 * 开发工具：IntelliJ IDEA
 * 当前用户：CH
 * 描述：
 */
package com.ch.admin.filters;

import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.boot.web.servlet.ServletListenerRegistrationBean;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Controller;

import javax.servlet.Filter;
import javax.servlet.Servlet;
import javax.servlet.ServletContextListener;
import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.EventListener;

@Controller
public class MyRegisConfig{
    @Bean
    public ServletRegistrationBean myServlet(){
        Servlet servlet = new MyServlet();
        return new ServletRegistrationBean(servlet,"/my","/my02");
    }

    @Bean
    public FilterRegistrationBean myFilter() {
        MyFilter myFilter = new MyFilter();
        FilterRegistrationBean<Filter> filterFilterRegistrationBean = new FilterRegistrationBean<>();
        filterFilterRegistrationBean.setFilter(myFilter);
        filterFilterRegistrationBean.setUrlPatterns(Arrays.asList("/my","/my02"));

        return filterFilterRegistrationBean;
    }

    @Bean
    public ServletListenerRegistrationBean myListener(){
        MyServletContextListener myServletContextListener = new MyServletContextListener();
        ServletListenerRegistrationBean<ServletContextListener> Listener1 = new ServletListenerRegistrationBean<>();
        Listener1.setListener(myServletContextListener);
        return Listener1;
    }
}