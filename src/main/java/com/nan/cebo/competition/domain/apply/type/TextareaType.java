package com.nan.cebo.competition.domain.apply.type;

import com.nan.cebo.competition.domain.apply.ApplyType;

/**
 * @author xuxiaoxi10
 * @version 1.0
 * @date 2020/4/18 11:12
 */
public class TextareaType implements ApplyType {
    private String name;
    private int type;
    private String inputName;
    public TextareaType(){

    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
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

    @Override
    public String toJson() {
        return null;
    }

    @Override
    public Class ClassPath() {
        return this.getClass();
    }
}
