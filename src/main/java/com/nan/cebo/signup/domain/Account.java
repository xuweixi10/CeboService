package com.nan.cebo.signup.domain;

/**
 * @author xuxiaoxi10
 * @version 1.0
 * @date 2020/4/23 13:10
 */
public class Account {
    private String uuid=null;
    private String schoolId=null;
    private String nickName=null;
    private String studentId=null;

    public String getUuid() {
        return uuid;
    }

    public void setUuid(String uuid) {
        this.uuid = uuid;
    }

    public String getSchoolId() {
        return schoolId;
    }

    public void setSchoolId(String schoolId) {
        this.schoolId = schoolId;
    }

    public String getNickName() {
        return nickName;
    }

    public void setNickName(String nickName) {
        this.nickName = nickName;
    }

    public String getStudentId() {
        return studentId;
    }

    public void setStudentId(String studentId) {
        this.studentId = studentId;
    }
}
