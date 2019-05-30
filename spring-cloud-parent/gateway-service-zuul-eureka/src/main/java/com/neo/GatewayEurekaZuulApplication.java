package com.neo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;

/**
 * 使用 Eureka
 * 基于 URL 去配置有一个问题，就是当服务本身被调度到其他节点时，Zuul 无法感知。利用 Eureka 注册服务的能力，
 * 如果 Zuul 也能去 Eureka Server 获取服务的地址并且基于所有服务的实例进行轮询/熔断/重试，那就更好了。
 * 当然可以，因为 Zuul 和 Eureka 都是 Netflix 开发的，它们之间可以配合。
 *
 * 参考网址 : https://mp.weixin.qq.com/s/yOChVzBMwXIHHQHjKGzI0g
 */
@SpringBootApplication
//@EnableEurekaClient  //开启eurkea客户端
@EnableZuulProxy
public class GatewayEurekaZuulApplication {

	public static void main(String[] args) {
		SpringApplication.run(GatewayEurekaZuulApplication.class, args);
	}
}
