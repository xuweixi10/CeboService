package com.nan.cebo.competition.domain.apply;

import com.nan.cebo.competition.domain.apply.type.NormalType;
import com.nan.cebo.competition.domain.apply.type.PickerType;
import com.nan.cebo.competition.domain.apply.type.RadioType;
import com.nan.cebo.competition.domain.apply.type.TextareaType;

/**
 * 映射数据库对应表
 * 0----apply_normalType
 * @author xuxiaoxi10
 * @version 1.0
 * @date 2020/4/14 10:18
 */
public enum DataBaseTableName {
    NORMAL("apply_normalType",(byte) 0, new NormalType()),
    RADIO("apply_radioType",(byte) 1, new RadioType()),
    PICKER("apply_pickerType",(byte) 2, new PickerType()),
    TEXTAREA("apply_textAreaType",(byte) 3, new TextareaType());

    private String tableName;
    private byte code;
    private ApplyType type;
    DataBaseTableName(String tableName,byte code,ApplyType type){
        this.tableName=tableName;
        this.code=code;
        this.type=type;
    }
    public static DataBaseTableName valueof(byte code){
        for(DataBaseTableName dataBaseTableName:DataBaseTableName.values()){
            if(code==dataBaseTableName.getCode()){
                return dataBaseTableName;
            }
        }
        return null;
    }
    public String getTableName(){
        return this.tableName;
    }
    public Class getTypeClass(){
        return type.ClassPath();
    }
    public byte getCode(){
        return this.code;
    }
}
