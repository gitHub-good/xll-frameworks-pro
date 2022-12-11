package com.xll.frameworks.pro.common.core.annotation;

import java.lang.annotation.*;

/**
 * 功能描述: <br>
 * <p>
 * 〈匿名访问不鉴权注解〉
 * </p>
 * @Author: xuliangliang
 * @Date: 2022/11/27 14:22
 */
@Target({ ElementType.METHOD, ElementType.TYPE })
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface Anonymous {
}
