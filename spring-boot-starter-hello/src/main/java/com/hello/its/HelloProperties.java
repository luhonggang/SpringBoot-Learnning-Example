package com.hello.its;

import org.springframework.boot.context.properties.ConfigurationProperties;

/**
 * 在spring主配置文件中通过 hello.msg=来设置
 * 若不设置,默认为 hello.msg=LAJI
 * @author luhonggang
 * @version 1.8.0
 * @date 2019/7/11 13:45
 */
@ConfigurationProperties(prefix = "hello")
public class HelloProperties {
    private static final String MSG = "LAJI";
    private String msg = MSG;

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }
}
