package com.xll.frameworks.pro.common.design.pipeline.v2;

import lombok.NonNull;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.function.Function;

/**
 * 功能描述: <br>
 * <p>
 *  <堆栈管道构建器>
 * </p>
 * @author xuliangliang
 * @since 2023/12/10 18:34
 * @version 1.0.0
 */
public final class StackPipelineBuilder<T> implements PipelineBuilder {

    private final Deque<Function<Pipeline<? super T>, ? extends Pipeline<T>>> stack = new ArrayDeque<>();

    public StackPipelineBuilder<T> add(@NonNull Function<Pipeline<? super T>, ? extends AbstractForwardingPipeline<T>> factory) {
        stack.push(factory);
        return this;
    }

    public Pipeline<T> end(@NonNull AbstractEndPipeline<T> abstractEndPipeline) {
        if (stack.isEmpty()) {
            return abstractEndPipeline;
        }
        Pipeline<T> p = abstractEndPipeline;
        while (!stack.isEmpty()) {
            p = stack.pop().apply(p);
        }
        return p;
    }
}
