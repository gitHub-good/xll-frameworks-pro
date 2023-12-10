package com.xll.frameworks.pro.common.design.pipeline.v2;

import lombok.Getter;

/**
 * 功能描述: <br>
 * <p>
 *  <抽象管道>
 * </p>
 * @author xuliangliang
 * @since 2023/12/10 20:22
 * @version 1.0.0
 */
@Getter
public abstract class AbstractPipeline<T> implements Pipeline<T> {

    /**
     * 管道名称
     */
    private final String name;

    private Pipeline<? super T> next;

    protected AbstractPipeline(String name) {
        this.name = name;
    }

    protected AbstractPipeline(String name, Pipeline<? super T> next) {
        this.name = name;
        this.next = next;
    }

    /**
     * 处理当前流水线节点
     * @param ctx 上下文
     * @param inputArgs 入参数
     */
    protected abstract void doProcess(PipelineContext ctx, T inputArgs);

    public void setNext(Pipeline<? super T> next) {
        this.next = next;
    }
}
