/**
 * 开发团队：复仇者联盟
 * 开发团队领导人：陈浩
 * 开发人员姓名：陈浩
 * 学号/工号：2019112102
 * 个人/公司邮箱：ch111222@qq.com
 * 时间：2022/2/17 13:05
 * 开发名称：MainApplication
 * 开发工具：IntelliJ IDEA
 * 当前用户：CH
 * 描述：
 */
package com.ch.boot;

import ch.qos.logback.core.boolex.Matcher;
import com.ch.boot.bean.Car;
import com.ch.boot.bean.Pet;
import com.ch.boot.bean.User;
import com.ch.boot.bean.User2;
import com.ch.boot.config.MyConfig;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;


/**
 * 主程序类
 * @SpringBootApplication ：这是一个springboot应用
 *
 *
 */
@SpringBootApplication(scanBasePackages = "com.ch.boot")
public class MainApplication {
    public static void main(String[] args) {
        /*1、返回IOC容器*/
        ConfigurableApplicationContext run = SpringApplication.run(MainApplication.class, args);
        /*2、查看容器内的组件*/
        String[] names = run.getBeanDefinitionNames();
        for (String beanDefinitionName : names) {
            System.out.println(beanDefinitionName);
        }
//        /*3、从容器中获取组件*/
//        Pet tom01 = run.getBean("tom", Pet.class);
//        Pet tom02 = run.getBean("tom", Pet.class);
//        System.out.println("组件："+(tom01 == tom02));
//
//        /*
//        * 4、
//        * com.ch.boot.config.MyConfig$$EnhancerBySpringCGLIB$$93b5359f@577f9109
//        * bean；本身就是被CGLIB增强了的代理对象
//        * */
//        MyConfig bean = run.getBean(MyConfig.class);
//        System.out.println(bean);
//
//        /*
//        * Spring默认逻辑为：
//        * 如果@Configuration(proxyBeanMethods = true)我们这个类获取到的就是代理对象
//        * 代理对象调用方法。：Spring就会检查：容器中有没有这个方法返回的组件，如果有就拿来，没有就创建
//        * springboot总会检查这个组件是否存在于容器中，保持组件单例
//        *
//        * */
//        User user = bean.user01();
//        User user2 = bean.user01();
//        System.out.println(user==user2);
//
//
//        //组件依赖
//        /**/
//        User2 user02 = run.getBean("user02", User2.class);
//        Pet tom = run.getBean("tom", Pet.class);
//
//        System.out.println("用户的宠物与容器中的宠物："+ (user02.getPet() == tom));
//
//        /*获取组件*/
//        String[] beanNamesForType = run.getBeanNamesForType(User.class);
//        System.out.println("==========================");
//        for (String s : beanNamesForType) {
//            System.out.println(s);
//        }
//
//        Matcher bean1 = run.getBean(Matcher.class);
//        System.out.println(bean1);

        boolean tom = run.containsBean("tom");
        System.out.println("容器中tom组件："+ tom);

        boolean user01 = run.containsBean("user01");
        System.out.println("容器中user01组件："+ user01);

        boolean haha = run.containsBean("haha");
        System.out.println("容器中haha组件："+ haha);
        boolean hehe = run.containsBean("hehe");
        System.out.println("容器中hehe组件："+ hehe);

        Car car = run.getBean("mycar-com.ch.boot.bean.Car", Car.class);
        System.out.println(car);

        System.out.println(run.getBeanDefinitionCount());
    }
}