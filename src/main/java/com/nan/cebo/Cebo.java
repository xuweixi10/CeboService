package com.nan.cebo;


import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.scheduling.annotation.EnableScheduling;

/**
 * @author xuxiaoxi10
 * @version 1.0
 * @date 2020/4/13 11:00
 */

@MapperScan("com.nan.cebo.competition.persistence")
@SpringBootApplication
@EnableScheduling
public class Cebo {

    public static void main(String[] args){
        SpringApplication.run(Cebo.class,args);
    }
}
