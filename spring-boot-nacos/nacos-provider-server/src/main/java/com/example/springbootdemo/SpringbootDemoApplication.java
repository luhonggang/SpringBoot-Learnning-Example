package com.example.springbootdemo;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author luhonggang
 * 启动类
 * nacos 中文社区示例 : http://springcloud.cn/view/438
 * nacos 参考网址 : http://blog.didispace.com/spring-cloud-alibaba-1/
 * nacos 下载网址 : https://github.com/alibaba/nacos/releases
 * nacos 访问地址 : http://127.0.0.1:8848/nacos/
 */
@EnableDiscoveryClient
@SpringBootApplication
public class SpringbootDemoApplication {
    public static void main(String[] args) {
        SpringApplication.run(SpringbootDemoApplication.class, args);
    }

    @Slf4j
    @RestController
    static class TestController {
        @GetMapping("/hello")
        public String hello(@RequestParam String name) {
            log.info("invoked name = " + name);
            return "The server return helloWorld and name is : " + name;
        }
    }

}

