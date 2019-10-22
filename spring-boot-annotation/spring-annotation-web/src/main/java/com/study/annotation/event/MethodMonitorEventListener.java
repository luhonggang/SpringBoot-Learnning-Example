package com.study.annotation.event;


import java.util.EventListener;

/**
 * 定义事件监听接口
 * @author luhonggang
 * @version 1.8.0
 * @date 2019/9/11 16:49
 */
public interface MethodMonitorEventListener extends EventListener {
    public abstract void begin(MethodMonitorEvent event);

    public abstract void end(MethodMonitorEvent event);

}
