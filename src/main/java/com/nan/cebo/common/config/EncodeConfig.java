package com.nan.cebo.common.config;

import lombok.Data;
import lombok.Getter;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;

/**
 * @Description
 * @Author WM
 * @Date 2020/4/25 17:59
 */
@Component
@Getter
public class EncodeConfig {
  @Value("${admin.username}")
  private String username;

  @Value("${admin.password}")
  private String password;

}
