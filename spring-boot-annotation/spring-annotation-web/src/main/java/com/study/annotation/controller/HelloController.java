package com.study.annotation.controller;

import com.study.annotation.common.ReadPropertiesConfig;
import com.study.annotation.entity.User;
import com.study.annotation.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @author luhonggang
 * @version 1.8.0
 * @date 2019/1/17 14:11
 */
@SuppressWarnings("all")
@RestController
@RequestMapping("/hello")
@Slf4j
public class HelloController {

    @Autowired
    UserService userService;

    @Autowired
    ReadPropertiesConfig readPropertiesConfig;

    @RequestMapping(value = "list",method = {RequestMethod.POST,RequestMethod.GET})
    public String queryList(){
        log.info("注入的值 : " + readPropertiesConfig.url);
//        return userService.queryList();
        return readPropertiesConfig.url;
    }

    @RequestMapping(value = "list02",method = {RequestMethod.POST,RequestMethod.GET})
    public List<User> queryList02(){
        return userService.queryList02();
    }

}
