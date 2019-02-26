package com.study.factory;

/**
 * @author luhonggang
 * @version 1.8.0
 * @date 2019/2/26 16:59
 */
public class TeacherWorkFactory implements IworkFactory {
    /**
     * 获取到一个 老师类的实例
     * @return
     */
    @Override
    public Work getWork() {
        return new TeacherWork();
    }
}
