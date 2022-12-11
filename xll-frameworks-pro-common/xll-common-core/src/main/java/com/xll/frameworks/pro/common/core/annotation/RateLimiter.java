package com.xll.frameworks.pro.common.core.annotation;

import com.xll.frameworks.pro.common.core.constant.CacheConstants;
import com.xll.frameworks.pro.common.core.enums.LimitType;

import java.lang.annotation.*;

/**
 * 功能描述: <br>
 * <p>
 * 〈限流注解〉
 * </p>
 * @Author: xuliangliang
 * @Date: 2022/11/27 14:27
 */
@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface RateLimiter {
    /**
     * 限流key
     */
    String key() default CacheConstants.RATE_LIMIT_KEY;

    /**
     * 限流时间,单位秒
     */
    int time() default 60;

    /**
     * 限流次数
     */
    int count() default 100;

    /**
     * 限流类型
     */
    LimitType limitType() default LimitType.DEFAULT;
}
