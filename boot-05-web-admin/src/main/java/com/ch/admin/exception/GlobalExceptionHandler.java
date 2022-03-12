/**
 * 开发团队：复仇者联盟
 * 开发团队领导人：陈浩
 * 开发人员姓名：陈浩
 * 学号/工号：2019112102
 * 个人/公司邮箱：ch111222@qq.com
 * 时间：2022/3/8 11:15
 * 开发名称：GlobalExceptionHandler
 * 开发工具：IntelliJ IDEA
 * 当前用户：CH
 * 描述：
 */
package com.ch.admin.exception;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.MissingServletRequestParameterException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

/**
 * 用于处理整个Web Controller中的异常
 * */
@ControllerAdvice
@Slf4j
public class GlobalExceptionHandler {

    /**代表它是一个异常处理器 : 处理数学运算异常，空指针异常 ,请求参数没有值*/
    @ExceptionHandler({ArithmeticException.class,NullPointerException.class, MissingServletRequestParameterException.class})
    public String handleArithmeticException(Exception e){

        log.error("异常是:{}",e.getMessage());

        /*在默认的处理程序异常解析器中可以看到，返回的都是ModeAndView，这里返回视图地址页可以*/
        return "login";
    }
}