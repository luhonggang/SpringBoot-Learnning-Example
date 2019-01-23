package com.neo.controller;

import org.springframework.core.annotation.Order;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;
import javax.annotation.Resource;

///**
// * @author luhonggang
// * @version 1.8.0
// * @date 2019/1/23 19:42
// */
//@RestController
//public class OrderController {
//    /**
//     * 直接使用zuul网管连接业务的服务提供者
//     */
//    private final static String URI_PRFIX="http://spring-cloud-eureka/api-order";
//
//    @Resource
//    private RestTemplate restTemplate;
//
//    @GetMapping("/order/{id}")
//    public Order getOrder(@PathVariable("id")Integer id) {
//        return restTemplate.getForObject(URI_PRFIX+"/order/"+id, Order.class);
//    }
//
//}