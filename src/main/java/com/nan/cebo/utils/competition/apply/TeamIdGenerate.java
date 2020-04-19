package com.nan.cebo.utils.competition.apply;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.LinkedList;
import java.util.Queue;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @author xuxiaoxi10
 * @version 1.0
 * @date 2020/4/18 20:55
 */
public class TeamIdGenerate {
    public static ReentrantLock lock=new ReentrantLock();
    public static long EXPIRED_TIME=1000*10;
    public static Logger log= LoggerFactory.getLogger("TeamIdGenerate");

    public static String generateId(){
        String id=null;
        try {
            if(lock.tryLock(EXPIRED_TIME, TimeUnit.MILLISECONDS)){
                try {
                    id= String.valueOf(System.currentTimeMillis());
                    TimeUnit.MILLISECONDS.sleep(5);
                }finally {
                    lock.unlock();
                }
            }
        }catch (InterruptedException e){
            log.warn("get lock Expired in TeamIdGenerate");
        }
        return id;
    }
}
