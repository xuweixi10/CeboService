package com.nan.cebo.competition.domain.apply.submit;

/**
 * 数据库中存储的方式
 * @author xuxiaoxi10
 * @version 1.0
 * @date 2020/4/19 0:17
 */
public class PersonDataBase {
    private String tableName;
    private String teamId;
    private String name;
    private String value;
    public PersonDataBase(){}

    public String getTeamId() {
        return teamId;
    }



    public String getTableName() {
        return tableName;
    }

    public void setTableName(String tableName) {
        this.tableName = tableName;
    }

    public void setTeamId(String teamId) {
        this.teamId = teamId;
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
