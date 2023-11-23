package com.xll.frameworks.pro.common.design.retry;

/**
 * 功能描述: <br>
 * <p>
 *  <业务操作>
 * </p>
 * @author xuliangliang
 * @since 2023/11/23 16:20
 * @version 1.0.0
 */
@FunctionalInterface
public interface BusinessOperation<T> {

    /**
     * 执行<br>
     * @return 执行结果
     * @throws BusinessException 异常信息
     */
    T perform() throws BusinessException;
}
