/**
 * 开发团队：复仇者联盟
 * 开发团队领导人：陈浩
 * 开发人员姓名：陈浩
 * 学号/工号：2019112102
 * 个人/公司邮箱：ch111222@qq.com
 * 时间：2022/3/10 10:07
 * 开发名称：UserMpServiceImpl
 * 开发工具：IntelliJ IDEA
 * 当前用户：CH
 * 描述：
 */
package com.ch.admin.service.Impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.ch.admin.bean.UserMp;
import com.ch.admin.mapper.UserMpMapper;
import com.ch.admin.service.UserMpService;
import org.springframework.stereotype.Service;

@Service
public class UserMpServiceImpl extends ServiceImpl<UserMpMapper, UserMp> implements UserMpService {
}