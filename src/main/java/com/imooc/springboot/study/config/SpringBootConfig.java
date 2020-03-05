package com.imooc.springboot.study.config;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

/**
 * Created by fengwei on 2020/3/4.
 */
@Data
@Component
@ConfigurationProperties(prefix = "imooc.springboot")
public class SpringBootConfig {

    private String version;
    private String name;
}
