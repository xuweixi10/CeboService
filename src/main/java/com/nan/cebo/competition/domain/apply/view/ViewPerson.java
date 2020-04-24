package com.nan.cebo.competition.domain.apply.view;

/**
 * 获取队员的信息bean
 * @author xuxiaoxi10
 * @version 1.0
 * @date 2020/4/24 17:26
 */
public class ViewPerson {
    private String personId;
    private String name;
    private String value;
    public ViewPerson(){

    }

    public String getPersonId() {
        return personId;
    }

    public void setPersonId(String personId) {
        this.personId = personId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }
}
