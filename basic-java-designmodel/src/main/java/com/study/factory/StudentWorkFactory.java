package com.study.factory;

/**
 * @author luhonggang
 * @version 1.8.0
 * @date 2019/2/26 17:03
 */
public class StudentWorkFactory implements IworkFactory {
    @Override
    public Work getWork() {
        return new StudentWork();
    }
}
