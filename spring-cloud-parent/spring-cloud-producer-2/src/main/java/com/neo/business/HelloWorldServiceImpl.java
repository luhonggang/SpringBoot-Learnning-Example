package com.neo.business;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

/**
 * 将当前类当成一个controller
 * 路由器来分发请求并处理业务
 * 它的父类接口来源于[实例名:spring-cloud-producer]
 * @author luhonggang
 * @version 1.8.0
 * @date 2019/5/30 15:03
 */
@RestController
@Slf4j
public class HelloWorldServiceImpl implements HelloWorldService {

    /**
     * 当前实例如下方法是对 实例名:spring-cloud-producer 的暴露的服务接口的具体实现
     * @param name 客户端输入的名称
     * @return Map<String,Object>
     */
    @Override
    @PostMapping("/hello")
    public Map<String, Object> helloWorld(String name) {
        Map<String,Object> map = new HashMap<>(8);
        map.put("fegin","http test");
        map.put("http","模拟fegin调用实现");
        log.info("fegin callback : {} ", name);
        return map;
    }
}
