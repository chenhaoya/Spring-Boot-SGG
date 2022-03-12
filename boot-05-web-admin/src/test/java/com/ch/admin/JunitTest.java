/**
 * 开发团队：复仇者联盟
 * 开发团队领导人：陈浩
 * 开发人员姓名：陈浩
 * 学号/工号：2019112102
 * 个人/公司邮箱：ch111222@qq.com
 * 时间：2022/3/11 9:41
 * 开发名称：JunitTest
 * 开发工具：IntelliJ IDEA
 * 当前用户：CH
 * 描述：
 */
package com.ch.admin;

import org.junit.jupiter.api.*;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.concurrent.TimeUnit;

@SpringBootTest
@DisplayName("Junit功能测试类")
public class JunitTest {
    @DisplayName("测试displayName注解")
    @Test
    void testDisplayName(){
        System.out.println(1);
    }
    @Disabled
    @DisplayName("测试方法2")
    @Test
    void test2(){
        System.out.println(2);
    }

    @DisplayName("重复测试")
    @RepeatedTest(5)
    void testRepeatedTest(){
        System.out.println("==重复测试==");
    }

    /**
     * 如果方法运行时间超过500毫秒，报错
     * */
    @DisplayName("超时测试")
    @Timeout(value = 500,unit = TimeUnit.MILLISECONDS)
    @Test
    void testTimeout() throws InterruptedException {
        Thread.sleep(400);
    }

    @BeforeEach
    void testBeforeEach(){
        System.out.println("测试即将开始---");
    }
    @AfterEach
    void testAfterEach(){
        System.out.println("方式结束了---");
    }
    @BeforeAll
    static void testBeforeAll(){
        System.out.println("===所有测试即将开始===");
    }
    @AfterAll
    static void testAfterAll(){
        System.out.println("===所有测试都结束了===");
    }
}