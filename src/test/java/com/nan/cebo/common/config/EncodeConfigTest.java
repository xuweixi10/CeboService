package com.nan.cebo.common.config;

import static org.junit.Assert.*;

import com.nan.cebo.Cebo;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * @Description
 * @Author WM
 * @Date 2020/4/25 18:04
 */

@SpringBootTest(classes = Cebo.class)
@RunWith(SpringRunner.class)
public class EncodeConfigTest {
  @Autowired
  EncodeConfig encodeConfig;

  @Test
  public void test(){
    System.out.println("asdsad"+encodeConfig.getUsername());
    System.out.println("qweqwee"+encodeConfig.getPassword());
  }
}