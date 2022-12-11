package com.xll.frameworks.pro.common.core.annotation;

import com.xll.frameworks.pro.common.core.enums.BusinessType;
import com.xll.frameworks.pro.common.core.enums.OperatorType;

import java.lang.annotation.*;

/**
 * 功能描述: <br>
 * <p>
 * 〈自定义操作日志记录注解〉
 * </p>
 * @Author: xuliangliang
 * @Date: 2022/11/27 14:26
 */
@Target({ ElementType.PARAMETER, ElementType.METHOD })
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface Log {
    /**
     * 模块 
     */
    String title() default "";

    /**
     * 功能
     */
    BusinessType businessType() default BusinessType.OTHER;

    /**
     * 操作人类别
     */
    OperatorType operatorType() default OperatorType.MANAGE;

    /**
     * 是否保存请求的参数
     */
    boolean isSaveRequestData() default true;

    /**
     * 是否保存响应的参数
     */
    boolean isSaveResponseData() default true;
}
