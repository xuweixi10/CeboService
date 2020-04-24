package com.nan.cebo.signup.domain;

/**
 * @author xuxiaoxi10
 * @version 1.0
 * @date 2020/4/23 13:23
 */
public class SchoolInformation {
    private String uuid=null;
    private String schoolId=null;
    private String schoolName=null;
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

    public String getSchoolName() {
        return schoolName;
    }

    public void setSchoolName(String schoolName) {
        this.schoolName = schoolName;
    }

    public String getStudentId() {
        return studentId;
    }

    public void setStudentId(String studentId) {
        this.studentId = studentId;
    }
}
