package com.xll.frameworks.pro.common.design.aggregate;

/**
 * 功能描述: <br>
 * <p>
 *  <聚合模式 - 超类（标记类）>
 * </p>
 * @author xuliangliang
 * @since 2024/1/14 18:41
 * @version 1.0.0
 */
public interface ActionAggregate {
    /**
     * 获取具体动作
     * @param t 入参数
     * @return 具体动作实现
     */
    <T> T getAction(Class<T> t);
}
