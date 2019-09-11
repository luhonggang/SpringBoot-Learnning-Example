package com.study.annotation.dao;

import com.study.annotation.entity.User;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * @author luhonggang
 * @version 1.8.0
 * @date 2019/1/17 13:49
 */
@SuppressWarnings("ALL")
@Mapper
public interface UserMapper {
    List<User> queryList();
}
