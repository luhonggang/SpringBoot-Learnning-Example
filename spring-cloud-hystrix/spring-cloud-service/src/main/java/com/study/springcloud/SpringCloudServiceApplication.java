package com.study.springcloud;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * Hello world!
 * @author luhonggang
 */
@EnableDiscoveryClient
@SpringBootApplication
public class SpringCloudServiceApplication
{
    public static void main( String[] args )
    {
        new SpringApplicationBuilder(SpringCloudServiceApplication.class).web(true).run(args);
    }
}
