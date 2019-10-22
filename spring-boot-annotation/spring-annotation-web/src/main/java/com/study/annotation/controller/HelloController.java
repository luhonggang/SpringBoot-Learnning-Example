package com.study.annotation.controller;

import com.study.annotation.common.ReadPropertiesConfig;
import com.study.annotation.entity.ExperimentVo;
import com.study.annotation.entity.User;
import com.study.annotation.service.ExperimentService;
import com.study.annotation.service.UserService;
import jdk.nashorn.internal.ir.annotations.Reference;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
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

    @Reference
    ExperimentService experimentService;

    @RequestMapping(value = "/list",method = RequestMethod.GET)
    public String queryList(){
        log.info("注入的值 : " + readPropertiesConfig.url);
        // 注入的值 : jdbc:mysql://localhost:3306/rule?useUnicode=true&characterEncoding=utf8&allowMultiQueries=true&zeroDateTimeBehavior=convertToNull&autoReconnect=true
//        return userService.queryList();
        return readPropertiesConfig.url;
    }

    @RequestMapping(value = "list02",method = {RequestMethod.POST,RequestMethod.GET})
    public List<User> queryList02(){
        return userService.queryList02();
    }

    /**
     * 保存实验数据
     * @param experimentVo 入参数据
     */
    @PostMapping(value = "/save-experiment")
    private void saveExperiment(@Valid @RequestBody ExperimentVo experimentVo){
        experimentService.saveExperiment(experimentVo);
    }

    /**
     * 修改实验数据
     * @param experimentVo 入参数据
     */
    @PostMapping(value = "/update-experiment")
    private void updateExperiment(@Valid @RequestBody ExperimentVo experimentVo){
         experimentService.updateExperiment(experimentVo);
    }


}
