package com.study.annotation.event;

import lombok.extern.slf4j.Slf4j;

/**
 * 事件监听接口实现 如何处理
 * @author luhonggang
 * @version 1.8.0
 * @date 2019/9/11 16:53
 */
@Slf4j
public class AbstractMethodMonitorEventListener implements MethodMonitorEventListener {
    @Override
    public void begin(MethodMonitorEvent event) {
        // 记录方法开始执行的时间
        event.timestamp = System.currentTimeMillis();

    }

    @Override
    public void end(MethodMonitorEvent event) {
        // 计算方法耗时
        long times = System.currentTimeMillis() - event.timestamp;
        System.out.println("记录方法执行的总耗时 : " + times + " 毫秒");
    }
}
