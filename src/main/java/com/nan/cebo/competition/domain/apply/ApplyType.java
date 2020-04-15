package com.nan.cebo.competition.domain.apply;

/**
 * 所有报名类型的接口
 * @author xuxiaoxi10
 * @version 1.0
 * @date 2020/4/14 10:10
 */
public interface ApplyType {
    String toJson();

    /**
     * 获取对应类型的类
     * @return Class<T>
     */
    Class ClassPath();
}
