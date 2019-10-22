package com.study.annotation.applicationcontextaware;

import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Component;

/** ApplicationContextAware 该接口的作用:
 * 当一个类实现ApplicationContextAware接口后，当这个类被spring加载后，就能够在这个类中获取到spring的上下文操作符ApplicationContext，
 * 通过ApplicationContext 就能够轻松的获取所有的spring管理的bean
 * @author luhonggang
 * @version 1.8.0
 * @date 2019/10/17 11:43
 */
@Component
public class SpringContextUtil implements ApplicationContextAware {

    private static ApplicationContext applicationContext;
    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
           SpringContextUtil.applicationContext = applicationContext;
    }

    /**
     * 获取实例
     * @param beanName 对象名称
     * @return         Object
     */
    public static Object getBean(String beanName) {
        return applicationContext.getBean(beanName);
    }
    /**
     * 获取对象实例
     * @param clsName 据类名
     * @param <T>     类型未定
     * @return        类的实例
     */
    public static <T> T getBean(Class<T> clsName){
        return applicationContext.getBean(clsName);
    }
}
