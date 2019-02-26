package com.study.basic;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableAsync;

/**
 * 让@Async注解能够生效，还需要在Spring Boot的主程序中配置@EnableAsync
 * @author luhonggang
 */
@SpringBootApplication
@EnableAsync
public class BasicJavaThreadlocalApplication {

    public static void main(String[] args) {
        SpringApplication.run(BasicJavaThreadlocalApplication.class, args);
    }

}

