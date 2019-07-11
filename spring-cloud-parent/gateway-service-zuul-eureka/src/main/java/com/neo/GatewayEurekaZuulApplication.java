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
 * Zuul包含了对请求的路由和过滤两个主要的功能，其中路由功能负责将外部的请求转发到具体的微服务实例上，是实现外部访问统一入口的基础上，而过滤功能则负责对请求的处理过程进行干预，是实现请求校验，服务聚合等功能的基础。
 * Zuul和Eureka进行整合，将Zuul自身注册为Eureka服务治理下的应用，同时从Eureka中获取其他微服务的信息，也即以后访问微服务都是通过Zuul跳转后获得。
 * 代理+路由+过滤三大功能
 */
@SpringBootApplication
//@EnableEurekaClient  //开启eurkea客户端
@EnableZuulProxy
public class GatewayEurekaZuulApplication {

	public static void main(String[] args) {
		SpringApplication.run(GatewayEurekaZuulApplication.class, args);
	}
}
