package com.nan.cebo.competition.domain.apply.type;

import com.nan.cebo.competition.domain.apply.ApplyType;

/**
 * @author xuxiaoxi10
 * @version 1.0
 * @date 2020/4/14 22:09
 */
public class RadioType implements ApplyType {
    private String name;
    private String radioName;
    private int type;
    private String inputName;

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
        this.name=name;
        this.radioName=radioName;
    }
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
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

    public String getInputName() {
        return inputName;
    }

    public void setInputName(String inputName) {
        this.inputName = inputName;
    }
}
