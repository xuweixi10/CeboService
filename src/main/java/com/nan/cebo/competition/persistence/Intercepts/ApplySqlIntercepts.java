package com.nan.cebo.competition.persistence.Intercepts;

import com.nan.cebo.competition.domain.apply.DataBaseTableName;
import com.nan.cebo.competition.persistence.annotation.InterceptMethod;
import org.apache.ibatis.executor.Executor;
import org.apache.ibatis.executor.resultset.ResultSetHandler;
import org.apache.ibatis.mapping.MappedStatement;
import org.apache.ibatis.mapping.ResultMap;
import org.apache.ibatis.mapping.ResultMapping;
import org.apache.ibatis.plugin.*;
import org.apache.ibatis.session.ResultHandler;
import org.apache.ibatis.session.RowBounds;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import java.lang.annotation.Annotation;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Properties;

/**
 * @author xuxiaoxi10
 * @version 1.0
 * @date 2020/4/14 19:30
 */
@Component
@Intercepts({
        @Signature(
                type = Executor.class,
                method = "query",
                args = {MappedStatement.class,Object.class, RowBounds.class, ResultHandler.class})})
public class ApplySqlIntercepts implements Interceptor{
    private static final Logger log= LoggerFactory.getLogger("Intercept");
    private static final List<ResultMapping> EMPTY_RESULT_MAPPING = new ArrayList<ResultMapping>(0);
    @Override
    public Object intercept(Invocation invocation) throws Throwable {
        log.warn("begin intercept");
        final Object[] args = invocation.getArgs();
        MappedStatement ms = (MappedStatement) args[0];
        Class<?> classType = Class.forName(ms.getId().substring(0, ms.getId().lastIndexOf(".")));
        String methodName=ms.getId().substring(ms.getId().lastIndexOf(".")+1,ms.getId().length());
        Method[] methods=classType.getMethods();
        for(Method method:methods){
            if(method.getName().equals(methodName)){
                Annotation annotation=method.getAnnotation(InterceptMethod.class);
                if(annotation!=null){
                    //改变ms
                    Object parameterObject = args[1];
                    if(((Map)parameterObject).containsKey("type")){
                        byte type=(byte)((Map)parameterObject).get("type");
                        Class applyType=getType(type);
                        if(applyType==null){
                            return invocation.proceed();
                        }
                        args[0]=changeResultType(ms,applyType);
                        return invocation.proceed();
                    }
                }
            }
        }

        return invocation.proceed();

    }

    @Override
    public Object plugin(Object target) {
        return Plugin.wrap(target,this);
    }

    @Override
    public void setProperties(Properties properties) {

    }
    public MappedStatement changeResultType(MappedStatement ms, Class resultType) {
        //复制MappedStatement
        MappedStatement.Builder builder = new MappedStatement.Builder(
                ms.getConfiguration(), ms.getId(),
                ms.getSqlSource(), ms.getSqlCommandType());
        builder.resource(ms.getResource());
        builder.fetchSize(ms.getFetchSize());
        builder.statementType(ms.getStatementType());
        builder.keyGenerator(ms.getKeyGenerator());
        //是否引入主键对象
        /*
        if (ms.getKeyProperties() != null && ms.getKeyProperties().length != 0) {
            StringBuilder keyProperties = new StringBuilder();
            for (String keyProperty : ms.getKeyProperties()) {
                keyProperties.append(keyProperty).append(",");
            }
            keyProperties.delete(keyProperties.length() - 1, keyProperties.length());
            builder.keyProperty(keyProperties.toString());
        }

         */
        builder.timeout(ms.getTimeout());
        builder.parameterMap(ms.getParameterMap());
        List<ResultMap> resultMaps = new ArrayList<>();
        //修改result
        ResultMap resultMap = new ResultMap.Builder(ms.getConfiguration(), ms.getId(), resultType, EMPTY_RESULT_MAPPING).build();
        resultMaps.add(resultMap);
        builder.resultMaps(resultMaps);
        builder.resultSetType(ms.getResultSetType());
        builder.cache(ms.getCache());
        builder.flushCacheRequired(ms.isFlushCacheRequired());
        builder.useCache(ms.isUseCache());
        return builder.build();
    }
    public Class getType(byte type){
        DataBaseTableName dataBaseTableName=DataBaseTableName.valueof(type);
        if(dataBaseTableName!=null){
            return dataBaseTableName.getTypeClass();
        }
        return null;
    }
}
