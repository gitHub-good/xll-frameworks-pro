package com.xll.frameworks.pro.common.core.enums;

/**
 * 功能描述: <br>
 * <p>
 * 〈限流类型〉
 * </p>
 * @Author: xuliangliang
 * @Date: 2022/11/27 14:32
 */
public enum LimitType {
    /**
     * 默认策略全局限流
     */
    DEFAULT,

    /**
     * 根据请求者IP进行限流
     */
    IP
}
