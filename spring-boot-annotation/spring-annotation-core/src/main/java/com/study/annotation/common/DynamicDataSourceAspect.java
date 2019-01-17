package com.study.annotation.common;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;


@Aspect
/** 定义顺序，保证当前线程在销毁前，spring工厂可以创建需要的数据源*/
@Order(-10)
@Component
public class DynamicDataSourceAspect {
    Logger logger = LoggerFactory.getLogger(DynamicDataSourceAspect.class);
    @Before("@annotation(targetDataSource)")
    public void changeDataSource(JoinPoint point, TargetDataSource targetDataSource) throws Throwable {
        //获取当前的指定的数据源;
        String dsId = targetDataSource.value();
        //如果不在我们注入的所有的数据源范围之内，那么输出警告信息，系统自动使用默认的数据源。

        if (!DynamicDataSourceContextHolder.containsDataSource(dsId)) {
            logger.info("数据源[{}]不存在，使用默认数据源 ",dsId);
        } else {
            logger.info("Use DataSource : {} ",dsId);
            //找到的话，那么设置到动态数据源上下文中。
            DynamicDataSourceContextHolder.setDataSourceType(dsId);
        }
    }

    @After("@annotation(targetDataSource)")
    public void restoreDataSource(JoinPoint point, TargetDataSource targetDataSource) {
        logger.info("Revert DataSource : {} > {}",targetDataSource.value(),point.getSignature());
        //方法执行完毕之后，销毁当前数据源信息，进行垃圾回收。
        DynamicDataSourceContextHolder.clearDataSourceType();
    }
}
