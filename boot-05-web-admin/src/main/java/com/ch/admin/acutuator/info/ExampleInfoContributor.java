/**
 * 开发团队：复仇者联盟
 * 开发团队领导人：陈浩
 * 开发人员姓名：陈浩
 * 学号/工号：2019112102
 * 个人/公司邮箱：ch111222@qq.com
 * 时间：2022/3/11 20:18
 * 开发名称：AppInfoInfoContributor
 * 开发工具：IntelliJ IDEA
 * 当前用户：CH
 * 描述：
 */
package com.ch.admin.acutuator.info;

import org.springframework.boot.actuate.info.Info;
import org.springframework.boot.actuate.info.InfoContributor;
import org.springframework.stereotype.Component;

import java.util.Collections;


@Component
class ExampleInfoContributor implements InfoContributor {


    @Override
    public void contribute(Info.Builder builder) {
        builder.withDetail("msg", "你好");
        builder.withDetails(Collections.singletonMap("world", "666"));
    }
}