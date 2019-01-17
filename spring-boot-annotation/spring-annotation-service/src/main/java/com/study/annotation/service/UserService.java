package com.study.annotation.service;


import com.study.annotation.entity.User;

import java.util.List;

public interface UserService {
    List<User> queryList();

    List<User> queryList02();
}
