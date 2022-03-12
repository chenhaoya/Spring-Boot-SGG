/**
 * 开发团队：复仇者联盟
 * 开发团队领导人：陈浩
 * 开发人员姓名：陈浩
 * 学号/工号：2019112102
 * 个人/公司邮箱：ch111222@qq.com
 * 时间：2022/3/11 10:10
 * 开发名称：AssertionsTest
 * 开发工具：IntelliJ IDEA
 * 当前用户：CH
 * 描述：
 */
package com.ch.admin;

import org.junit.jupiter.api.Assumptions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.ValueSource;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;


@SpringBootTest
public class AssertionsTest {



    @ParameterizedTest
    @DisplayName("参数化测试")
    @ValueSource(ints = {1,2,3,4})
    void testParameterized(int i){
        System.out.println(i);
    }

    @ParameterizedTest
    @DisplayName("方法参数测试")
    @MethodSource("testWithDefaultLocalMethodSource")
    void testMethod(String methodSource){
        System.out.println(methodSource);
    }
    static Stream<String> testWithDefaultLocalMethodSource() {
        return Stream.of("apple", "banana");
    }


    /**
     * 断言：如果一个方法中有多个断言，前面的失败了，后面的就不会执行
     */
    @Test
    @DisplayName("simple assertion")
    void simple() {
        int cal = cal(2, 3);
        assertEquals(5, cal, "业务逻辑计算失败");

        Object o = new Object();
        Object o1 = new Object();
        //是否是同一个对象
        assertSame(o, o, "不是同一个对象");
    }

    int cal(int i, int j) {
        return i + j;
    }

    @Test
    @DisplayName("array assertion")
    void array() {
        assertArrayEquals(new int[]{1, 2}, new int[]{1, 2});
    }

    @Test
    @DisplayName("assert all")
    void all() {
        assertAll("test",
                () -> {assertArrayEquals(new int[]{1, 2}, new int[]{1, 2});},
                () -> {assertEquals(3, cal(1, 2), "业务逻辑计算失败");},
                () -> {assertTrue(true);}
        );
    }

    @Test
    @DisplayName("assert Exception")
    void testException(){
        assertThrows(ArithmeticException.class,()->{
            int i = 10/0;
            },"业务逻辑居然正常运行？");
    }

    @Test
    @DisplayName("快速失败")
    void testFail(){
        if (2 == 12) {
            fail("快速失败");
        }
    }

    @Test
    @DisplayName("测试前置条件")
    void testAssumptions(){
        Assumptions.assumeTrue(true,"不是true");
        System.out.println("前置条件通过");
    }
}