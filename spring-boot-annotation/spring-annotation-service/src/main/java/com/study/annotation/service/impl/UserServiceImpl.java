package com.study.annotation.service.impl;

import com.study.annotation.common.TargetDataSource;
import com.study.annotation.dao.UserMapper;
import com.study.annotation.entity.User;
import com.study.annotation.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author luhonggang
 * @version 1.8.0
 * @date 2019/1/17 14:07
 */
@SuppressWarnings("all")
@Service
@Slf4j
public class UserServiceImpl implements UserService {

    @Autowired
    UserMapper userMapper;

    @TargetDataSource("mg")
    @Override
    public List<User> queryList() {
        return userMapper.queryList();
    }

    @TargetDataSource("hhh")
    @Override
    public List<User> queryList02() {
        return userMapper.queryList();
    }
}
