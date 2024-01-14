package com.xll.frameworks.pro.common.design.wrapper;

import java.util.function.Function;
import java.util.function.Supplier;

/**
 * 功能描述: <br>
 * <p>
 *  <通用包装器接口定义>
 * </p>
 * @author xuliangliang
 * @since 2024/1/14 17:59
 * @version 1.0.0
 */
public interface CommonWrapper {
    /**
     * 支持出入参数组的包装
     * @param function 方法
     * @param params 参数
     * @return 出参数
     * @param <T> 返回类型
     */
    <T> T wrap(Function<Object[], T> function, Object... params);

    /**
     * 支持出参数组的包装
     * @param supplier 方法
     * @param <T> 返回类型
     * @return 出参数
     */
    <T> T wrap(Supplier<T> supplier);

    /**
     * 支持线程包装
     * @param runnable 线程
     */
    void wrap(Runnable runnable);
}
