package com.nacos.study;

import com.nacos.study.service.HelloWorldService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 第三种方式用Fegin来进行调用三方服务
 * @author luhonggang
 * @version 1.8.0
 * @date 2019/1/28 14:48
 */
@RestController
@Slf4j
public class HelloWorldController {


    @Autowired
    HelloWorldService helloWorldService;

    @RequestMapping("/helloWorld")
    public String helloWorld(String name){

        return helloWorldService.hello(name);
//        return "invoke helloWorld method is success name is : " +name;
    }
}
