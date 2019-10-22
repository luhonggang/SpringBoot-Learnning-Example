package com.study.annotation.event;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.concurrent.TimeUnit;

/**
 * @author luhonggang
 * @version 1.8.0
 * @date 2019/9/11 16:56
 */
public class MethodMonitorEventPublisher {
    private List<MethodMonitorEventListener> listeners = new ArrayList<>();

    public void methodMonitor() throws InterruptedException {
        MethodMonitorEvent event = new MethodMonitorEvent(this);

        publishEvent("BEGIN", event);

        // 等 5s
        TimeUnit.SECONDS.sleep(5);

        publishEvent("END", event);
    }

    /**
     * 发布事件
     * @param state 具体状态的事件
     * @param event MethodMonitorEvent
     */
    private void publishEvent(String state, MethodMonitorEvent event) {
        List<MethodMonitorEventListener> copyListener = new ArrayList<>(listeners);
        for (MethodMonitorEventListener listener : copyListener) {
            if ("BEGIN".equals(state)) {
                listener.begin(event);
            } else {
                listener.end(event);
            }
        }
    }

    /**
     * 添加事件
     * @param listener
     */
    private void addEventListener(MethodMonitorEventListener listener) {
        if(Objects.nonNull(listener)){
            listeners.add(listener);
        }
    }

    /**
     * 移除事件
     * @param listener
     */
    private void removeEventListener(MethodMonitorEventListener listener){
        if (Objects.isNull(listeners)) {
            return;
        } else {
            listeners.remove(listener);
        }
    }


    public static void main(String[] args) throws InterruptedException {
        MethodMonitorEventPublisher publisher = new MethodMonitorEventPublisher();
        publisher.addEventListener(new AbstractMethodMonitorEventListener());
        publisher.methodMonitor();
    }
}
