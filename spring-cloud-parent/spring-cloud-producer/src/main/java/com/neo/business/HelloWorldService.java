package com.neo.business;

import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import java.util.Map;

/**
 * Fegin 调用测试
 * name 指定要调用的实例服务名,即指定当前接口类下具体方法的实现的那个 实例名称
 * name = 具体实现业务的服务实例名称
 * @author luhonggang
 * @version 1.8.0
 * @date 2019/5/30 14:50
 */
@FeignClient(name = "spring-cloud-producer2")
public interface HelloWorldService {

    @PostMapping("/hello")
    Map<String, Object> helloWorld(@RequestParam("name") String name);

}
