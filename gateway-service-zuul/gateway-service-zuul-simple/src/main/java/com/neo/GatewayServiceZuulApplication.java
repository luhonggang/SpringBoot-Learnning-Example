package com.neo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;

/**
 * 访问的方式 : http://localhost:8888/spring-cloud-producer/hello?name=neo
 * 通过URL方式拦截匹配
 * 不使用 Eureka
 * 当 zuul 不配合 Eureka 服务发现服务的时候，Zuul 的路由就要基于 URL 去路由
 * 参考地址 : https://xli1224.github.io/2017/09/09/use-zuul/
 */
@SpringBootApplication
@EnableZuulProxy
public class GatewayServiceZuulApplication {

	public static void main(String[] args) {
		SpringApplication.run(GatewayServiceZuulApplication.class, args);
	}
}
