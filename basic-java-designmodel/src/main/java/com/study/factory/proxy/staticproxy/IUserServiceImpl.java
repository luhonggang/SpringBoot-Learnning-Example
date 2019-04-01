package com.study.factory.proxy.staticproxy;


/**
 * 正常的业务实现类
 * @author luhonggang
 * @version 1.8.0
 * @date 2019/3/27 15:15
 */
public class IUserServiceImpl implements IUserService {
    @Override
    public void add() {
        System.out.println("你说我想干什么,我只是想和你动动手");
    }
}
