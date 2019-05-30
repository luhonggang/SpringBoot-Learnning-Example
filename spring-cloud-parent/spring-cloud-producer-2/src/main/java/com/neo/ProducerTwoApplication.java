package com.neo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
/**
 *  @author luhonggang
 *  第二台实例注册到服务注册中心
 *  模拟一个客户端注册当前实例 eureka server 服务注册中心去
 */
@SpringBootApplication
@EnableDiscoveryClient
public class ProducerTwoApplication {

	public static void main(String[] args) {
		SpringApplication.run(ProducerTwoApplication.class, args);
	}
}
