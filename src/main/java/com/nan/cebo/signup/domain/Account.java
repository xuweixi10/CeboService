package com.nan.cebo.signup.domain;

/**
 * @author xuxiaoxi10
 * @version 1.0
 * @date 2020/4/23 13:10
 */
public class Account {
    private String openId =null;
    private String studentId=null;

    public String getOpenId() {
        return openId;
    }

    public void setOpenId(String openId) {
        this.openId = openId;
    }

    public String getStudentId() {
        return studentId;
    }

    public void setStudentId(String studentId) {
        this.studentId = studentId;
    }
}
