package com.study.annotation.common;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

/**
 * 该类主要负责读取主配置文件下的配置信息
 * 前缀 == spring.datasource,会在配置文件中寻找spring.datasource.*的配置项
 * @author luhonggang
 * @version 1.8.0
 * @date 2019/9/11 15:11
 */
@Component
@ConfigurationProperties(prefix = "spring.datasource")
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ReadPropertiesConfig {
    public String url;
    public String username;
    public String password;
    public String type;
}
