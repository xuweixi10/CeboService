package com.nan.cebo.competition.domain.apply.type;

import com.nan.cebo.competition.domain.apply.ApplyType;

/**
 * @author xuxiaoxi10
 * @version 1.0
 * @date 2020/4/14 22:09
 */
public class RadioType implements ApplyType {
    private String name;
    private int count;
    private String radioName;
    private int type;

    @Override
    public String toJson() {
        return null;
    }

    @Override
    public Class ClassPath() {
        return this.getClass();
    }

    public RadioType(){

    }
    public RadioType(String name,int count,String radioName){
        this.count=count;
        this.name=name;
        this.radioName=radioName;
    }
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public String getRadioName() {
        return radioName;
    }

    public void setRadioName(String radioName) {
        this.radioName = radioName;
    }

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }
}
