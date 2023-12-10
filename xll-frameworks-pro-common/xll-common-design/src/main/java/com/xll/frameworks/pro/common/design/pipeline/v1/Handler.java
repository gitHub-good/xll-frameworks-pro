package com.xll.frameworks.pro.common.design.pipeline.v1;
/**
 * 功能描述: <br>
 * <p>
 *  <处理器>
 * </p>
 * @author xuliangliang
 * @since 2023/11/23 15:24
 * @version 1.0.0
 */
@FunctionalInterface
public interface Handler<I, O> {
    /**
     * 流程处理
     * @param input 参数
     * @return 出参
     */
    O process(I input);
}
