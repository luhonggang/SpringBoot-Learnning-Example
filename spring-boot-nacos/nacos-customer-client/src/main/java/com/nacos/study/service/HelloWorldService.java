package com.nacos.study.service;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * 在该类中直接依据服务名称来调用nacos中的服务
 * @author luhonggang
 * @version 1.8.0
 * @date 2019/1/28 14:51
 */
@FeignClient("alibaba-nacos-discovery-server")
public interface HelloWorldService {
    @GetMapping("/hello")
    String hello(@RequestParam(name = "name") String name);
}
