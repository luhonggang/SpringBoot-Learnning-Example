package com.study.springcloud;


import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
//import org.springframework.boot.web.support.SpringBootServletInitializer;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

/**
 * @author  luhonggang
 *
 */
@EnableEurekaServer
@SpringBootApplication
public class SpringCloudEurekaApplication /*extends SpringBootServletInitializer*/ {
    public static void main( String[] args )
    {
        new SpringApplicationBuilder(SpringCloudEurekaApplication.class).web(true).run(args);
    }
}
