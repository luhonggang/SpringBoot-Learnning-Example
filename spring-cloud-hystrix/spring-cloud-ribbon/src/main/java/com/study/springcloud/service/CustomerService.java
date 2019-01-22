package com.study.springcloud.service;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

/**
 * @author luhonggang
 * @version 1.8.0
 * @date 2019/1/22 10:35
 */
@Service
public class CustomerService {

    @Autowired
    RestTemplate restTemplate;

    /**
     *  模拟因服务消费者因服务调用超时 而触发熔断请求,并调用回调逻辑 即返回 error
     * @return
     */
    @HystrixCommand(fallbackMethod = "addServiceFallback")
    public String addService() {
        return restTemplate.getForEntity("http://COMPUTE-SERVICE/add?a=10&b=20", String.class).getBody();
    }

    public String addServiceFallback() {
        return "error";
    }

}
