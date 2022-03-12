/**
 * 开发团队：复仇者联盟
 * 开发团队领导人：陈浩
 * 开发人员姓名：陈浩
 * 学号/工号：2019112102
 * 个人/公司邮箱：ch111222@qq.com
 * 时间：2022/3/9 13:04
 * 开发名称：MyDataSourceConfig
 * 开发工具：IntelliJ IDEA
 * 当前用户：CH
 * 描述：
 */
package com.ch.admin.config;

import com.alibaba.druid.pool.DruidDataSource;
import com.alibaba.druid.support.http.StatViewServlet;
import com.alibaba.druid.support.http.WebStatFilter;
import com.alibaba.druid.support.spring.stat.BeanTypeAutoProxyCreator;
import com.alibaba.druid.support.spring.stat.DruidStatInterceptor;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.annotation.PreDestroy;
import javax.servlet.Filter;
import javax.sql.DataSource;
import java.sql.SQLException;
import java.util.Arrays;

@Deprecated
//@Configuration
public class MyDataSourceConfig {

    @ConfigurationProperties("spring.datasource")
    @Bean
    public DataSource dataSource() throws SQLException {
        DruidDataSource druidDataSource = new DruidDataSource();
        //加入监控功能
        druidDataSource.setFilters("stat,wall");
        druidDataSource.setMaxActive(10);
        return druidDataSource;
    }

    /**配置druid监控功能*/
    @Bean(value = "statViewServlet")
    public ServletRegistrationBean servletRegistrationBean(){
        StatViewServlet statViewServlet = new StatViewServlet();

        ServletRegistrationBean<StatViewServlet> statViewServletServletRegistrationBean = new ServletRegistrationBean<>(statViewServlet, "/druid/*");
        statViewServletServletRegistrationBean.addInitParameter("loginUsername","admin");
        statViewServletServletRegistrationBean.addInitParameter("loginPassword","123456");
        return statViewServletServletRegistrationBean;
    }

    /**WebStatFilter*/
    @Bean
    public FilterRegistrationBean filterRegistrationBean(){
        WebStatFilter webStatFilter = new WebStatFilter();
        FilterRegistrationBean<WebStatFilter> filterFilterRegistrationBean = new FilterRegistrationBean<>(webStatFilter);
        filterFilterRegistrationBean.setUrlPatterns(Arrays.asList("/*"));
        filterFilterRegistrationBean.addInitParameter("exclusions","*.js,*.gif,*.jpg,*.png,*.css,*.ico,/druid/*");
        return filterFilterRegistrationBean;
    }
    /**Spring监控*/
    @Bean
    public DruidStatInterceptor springInterceptor(){
        DruidStatInterceptor druidStatInterceptor = new DruidStatInterceptor();
        return null;
    }
    @Bean
    public BeanTypeAutoProxyCreator beanTypeAutoProxyCreat(){
        BeanTypeAutoProxyCreator beanTypeAutoProxyCreator = new BeanTypeAutoProxyCreator();
        beanTypeAutoProxyCreator.setInterceptorNames("springInterceptor");
        return beanTypeAutoProxyCreator;
    }

}