package com.hello.its;


/**
 * @author luhonggang
 * @version 1.8.0
 * @date 2019/7/11 11:43
 */
public class HelloService {

    public static final String TIME = "2019-07-11";

    private String msg;

    public void sayHello(String msg){
        System.out.println("此时此刻你好意思对我说: " + msg);
    }

    public void sayHello(){
        System.out.println("默认值输出 : " + msg);
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }
}
