package com.study.annotation.event;

import java.util.EventObject;

/**
 * Spring容器的事件监听机制
 * 过去，事件监听机制多用于图形界面编程，比如：点击按钮、在文本框输入内容等操作被称为事件，
 * 而当事件触发时，应用程序作出一定的响应则表示应用监听了这个事件，而在服务器端，
 * 事件的监听机制更多的用于异步通知以及监控和异常处理。Java提供了实现事件监听机制的两个基础类：
 * 自定义事件类型扩展自 java.util.EventObject、事件的监听器扩展自
 * java.util.EventListener。来看一个简单的实例：简单的监控一个方法的耗时
 * @author luhonggang
 * @version 1.8.0
 * @date 2019/9/11 16:46
 */
public class MethodMonitorEvent extends EventObject {

    /**
     * 记录方法执行的时间
     */
    public long timestamp;
    /**
     * Constructs a prototypical Event.
     *
     * @param source The object on which the Event initially occurred.
     * @throws IllegalArgumentException if source is null.
     */
    public MethodMonitorEvent(Object source) {
        super(source);
    }
}
