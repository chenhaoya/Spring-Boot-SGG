/**
 * 开发团队：复仇者联盟
 * 开发团队领导人：陈浩
 * 开发人员姓名：陈浩
 * 学号/工号：2019112102
 * 个人/公司邮箱：ch111222@qq.com
 * 时间：2022/3/9 20:56
 * 开发名称：Account
 * 开发工具：IntelliJ IDEA
 * 当前用户：CH
 * 描述：
 */
package com.ch.admin.bean;

public class Account {
    public Account() {
    }

    private long id;
    private String userName;
    private String password;


    public long getId() {
        return id;
    }

    @Override
    public String toString() {
        return "Account{" +
                "id=" + id +
                ", userName='" + userName + '\'' +
                ", password='" + password + '\'' +
                '}';
    }

    public Account(long id, String userName, String password) {
        this.id = id;
        this.userName = userName;
        this.password = password;
    }

    public void setId(long id) {
        this.id = id;
    }


    public String getName() {
        return userName;
    }

    public void setName(String userName) {
        this.userName = userName;
    }


    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}