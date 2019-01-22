package com.study.springcloud.web;

import com.study.springcloud.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author luhonggang
 * @version 1.8.0
 * @date 2019/1/22 10:21
 */
@RestController
public class CustomerController {

    @Autowired
    CustomerService customerService;

    @RequestMapping(value = "/add", method = RequestMethod.GET)
    public String add() {
        return  customerService.addService();
    }
}
