package com.xll.frameworks.pro.common.core.annotation;

import com.xll.frameworks.pro.common.core.enums.DataSourceType;

import java.lang.annotation.*;

/**
 * 功能描述: <br>
 * <p>
 * 〈自定义多数据源切换注解〉
 * </p>
 * @Author: xuliangliang
 * @Date: 2022/11/27 14:24
 */
@Target({ ElementType.METHOD, ElementType.TYPE })
@Retention(RetentionPolicy.RUNTIME)
@Documented
@Inherited
public @interface DataSource {
    /**
     * 切换数据源名称
     */
    DataSourceType value() default DataSourceType.MASTER;
}
