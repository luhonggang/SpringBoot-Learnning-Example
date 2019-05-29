package com.neo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

/**
 *  说明该服务将作为一个注册中心,用来注册其他服务
 *  @EnableEurekaServer 开启服务发现
 *  @EnableAdminServer 开启服务器端监控
 *  @author luhonggang
 */
@SpringBootApplication
@EnableEurekaServer
public class SpringCloudEurekaApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringCloudEurekaApplication.class, args);
	}
}
