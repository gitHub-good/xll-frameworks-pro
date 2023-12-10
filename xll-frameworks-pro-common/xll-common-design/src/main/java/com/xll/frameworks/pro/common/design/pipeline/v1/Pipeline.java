package com.xll.frameworks.pro.common.design.pipeline.v1;

/**
 * 功能描述: <br>
 * <p>
 *  <管道模式>
 * </p>
 * @author xuliangliang
 * @since 2023/11/23 15:25
 * @version 1.0.0
 */
public class Pipeline<I, O> {
    private final Handler<I, O> currentHandler;

    public Pipeline(Handler<I, O> currentHandler) {
        this.currentHandler = currentHandler;
    }

    /**
     * 注册处理器
     * @param newHandler 新处理器
     * @return 管道
     * @param <K> 结果
     */
    public <K> Pipeline<I, K> register(Handler<O, K> newHandler) {
        return new Pipeline<>(input -> newHandler.process(currentHandler.process(input)));
    }

    /**
     * 执行
     * @param input 入参数
     * @return 结果
     */
    public O execute(I input) {
        return currentHandler.process(input);
    }
}
