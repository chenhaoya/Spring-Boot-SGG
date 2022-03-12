/**
 * 开发团队：复仇者联盟
 * 开发团队领导人：陈浩
 * 开发人员姓名：陈浩
 * 学号/工号：2019112102
 * 个人/公司邮箱：ch111222@qq.com
 * 时间：2022/2/17 14:13
 * 开发名称：MyConfig
 * 开发工具：IntelliJ IDEA
 * 当前用户：CH
 * 描述：
 */
package com.ch.boot.config;

import ch.qos.logback.core.boolex.Matcher;
import com.ch.boot.bean.Car;
import com.ch.boot.bean.Pet;
import com.ch.boot.bean.User;
import com.ch.boot.bean.User2;
import org.springframework.boot.autoconfigure.condition.ConditionalOnBean;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.context.annotation.ImportResource;


/**
 * 1、配置类里面使用@Bean标注在方法上给容器注册组件，默认也是单例的
 * 2、配置类本身也是组件
 * 3、proxyBeanMethods: 代理bean的方法
 * Full：全配置    (proxyBeanMethods = true)
 * Lite：轻量级配置 (proxyBeanMethods = false)
 * 应用场景：解决组件依赖  User2.java
 * 4、@Import({User.class,Filter.class})
 * 给容器中自动创建这两个类型的组件（通过无参构造
 * 默认组件名：全类名
 */
@Import({User.class, Matcher.class})
@Configuration(proxyBeanMethods = true) //告诉Spring这是一个配置类  == 配置文件
@ImportResource("classpath:beans.xml")
/**
 * 1、开启属性配置功能
 * 2、把Car这个组件自动注册到容器中，在Car类中说明 前提
 * */
@EnableConfigurationProperties(Car.class)
public class MyConfig {

    /**
     * @bean : 给容器中添加组件：以方法名作为组件的ID。返回类型就是组件类型。返回的值，就是组件在容器中的实例
     * 如果外部getBean(MyConfig)获取到配置文件的实例，对配置类中这个组件注册方法继续调用，
     * 则会根据@Configuration(proxyBeanMethods = true) or false 返回单例还是注册新的组件到容器
     * @return

     * @Conditional
     * @ConditionalOnBean(name = "tom") 条件装配 注解
     */
    @ConditionalOnBean(name = "tom")
    @Bean
    public User user01() {
        return new User("张三c", 18);
    }

    //    @Bean("tom")
    public Pet tomcatPet() {
        return new Pet("tomcatPet");
    }

    @Bean
    public User2 user02() {
        User2 user2 = new User2("张四", 18);
        /*user组件依赖pet组件*/
        user2.setPet(tomcatPet());
        return user2;
    }
}