/**
 * 开发团队：复仇者联盟
 * 开发团队领导人：陈浩
 * 开发人员姓名：陈浩
 * 学号/工号：2019112102
 * 个人/公司邮箱：ch111222@qq.com
 * 时间：2022/3/11 18:34
 * 开发名称：MyComHealthIndicator
 * 开发工具：IntelliJ IDEA
 * 当前用户：CH
 * 描述：
 */
package com.ch.admin.acutuator.health;

import org.springframework.boot.actuate.health.AbstractHealthIndicator;
import org.springframework.boot.actuate.health.Health;
import org.springframework.boot.actuate.health.Status;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;

@Component
public class MyComHealthIndicator extends AbstractHealthIndicator {
    /**
     * 这里编真实的检查方法
     * */
    @Override
    protected void doHealthCheck(Health.Builder builder) throws Exception {
        Map<String, Object> map = new HashMap();
        if (1 == 1) {
            builder.status(Status.UP);
            map.put("count",1);
            map.put("ms",400);
        }else {
            builder.down();
            map.put("err","错误原因");
        }
        /**
         * 除了可以返回状态，还可以附带参数
         * */
        builder.withDetail("code",100)
                .withDetails(map);
    }
}