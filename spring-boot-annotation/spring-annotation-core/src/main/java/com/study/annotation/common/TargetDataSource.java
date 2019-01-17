package com.study.annotation.common;

import java.lang.annotation.*;

/**
 * 自定义注解在切换数据源的时候使用
 */
@Retention(RetentionPolicy.RUNTIME)
@Target({ ElementType.METHOD, ElementType.TYPE })
@Documented
public @interface TargetDataSource {
    String value();
}
