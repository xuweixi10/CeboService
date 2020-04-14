package com.nan.cebo.utils.competition.apply;

import com.nan.cebo.competition.domain.apply.ApplyDataBase;
import com.nan.cebo.competition.domain.apply.ApplyFormData;
import com.nan.cebo.competition.domain.apply.ApplyType;
import com.nan.cebo.competition.persistence.ApplyMapper;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;

/**
 * 工具类 类型转换用
 * @author xuxiaoxi10
 * @version 1.0
 * @date 2020/4/14 15:34
 */
public class MixAll {

    /**
     * 转换成字节数组
     * @param applyType 字符串 0,0,0
     * @return 字节数组
     */
    public static byte[] StringToByteArray(String applyType){
        String[] types=applyType.split(",");
        byte[] result=new byte[types.length];
        for(int i=0;i<types.length;i++){
            result[i]=Byte.decode(types[i]);
        }
        return result;
    }

    /**
     * 获取所有类型的id
     * @param applyTypeId 12,123,1234
     * @return 数组
     */
    public static String[] StringToArray(String applyTypeId){
        return applyTypeId.split(",");
    }
}
