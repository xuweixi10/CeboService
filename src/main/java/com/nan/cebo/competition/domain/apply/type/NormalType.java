package com.nan.cebo.competition.domain.apply.type;

import com.nan.cebo.competition.domain.apply.ApplyType;

/**
 * @author xuxiaoxi10
 * @version 1.0
 * @date 2020/4/14 19:18
 */
public class NormalType implements ApplyType {
    private String name;
    private String maxLength;
    private String type;
    public NormalType(){

    }
    public NormalType(String name,String maxLength){
        this.name=name;
        this.maxLength=maxLength;
    }

    public String getName() {
        return name;
    }

    public String getMaxLength() {
        return maxLength;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    @Override
    public String toJson(){
        return null;
    }

    @Override
    public Class ClassPath() {
        return this.getClass();
    }
}
