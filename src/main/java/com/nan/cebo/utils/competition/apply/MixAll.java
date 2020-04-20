package com.nan.cebo.utils.competition.apply;

import com.nan.cebo.competition.domain.apply.submit.PersonDataBase;
import com.nan.cebo.competition.domain.apply.submit.TeamData;

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

    /**
     * 数据库类型转换成数据
     * @param personDataBase 数据库读取的数据
     * @return 实际数据
     */
    public static TeamData personDataBaseToData(PersonDataBase personDataBase){
        TeamData teamData=null;
        if(personDataBase!=null){
            teamData=new TeamData();
            teamData.setName(personDataBase.getName());
            teamData.setValue(personDataBase.getValue());
        }
        return teamData;
    }

    /**
     * 数据转换成数据库存储类型
     * @param teamData 队伍数据
     * @param teamId 队伍id
     * @return 数据库存储类型数据
     */
    public static PersonDataBase teamDataToBase(TeamData teamData,String teamId,String tableName){
        if(teamData!=null&&teamId!=null){
            PersonDataBase personDataBase=new PersonDataBase();
            personDataBase.setTeamId(teamId);
            personDataBase.setName(teamData.getName());
            personDataBase.setValue(teamData.getValue());
            return personDataBase;
        }
        return null;
    }
}
