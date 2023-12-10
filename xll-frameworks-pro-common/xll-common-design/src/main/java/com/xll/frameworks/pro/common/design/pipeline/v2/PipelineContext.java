package com.xll.frameworks.pro.common.design.pipeline.v2;

/**
 * 功能描述: <br>
 * <p>
 *  <管道上下文>
 * </p>
 * @author xuliangliang
 * @since 2023/12/10 18:04
 * @version 1.0.0
 */
public interface PipelineContext {

    /**
     * 获取上下文名称
     * @return 名称
     */
    String getActionName();

    /**
     * 获取属性
     * @param key 属性KEY
     * @return 值
     * @param <T> 属性类型
     */
    <T> T getProperty(String key);

    /**
     * 设置属性
     * @param key 属性KEY
     * @param value 属性值
     * @param <T> 属性类型
     */
    <T> void setProperty(String key, T value);

    /**
     * 移除属性
     * @param key 属性KEY
     */
    void removeProperty(String key);
}
