package com.xll.frameworks.pro.common.design.pipeline.v2;

import lombok.NonNull;

/**
 * 功能描述: <br>
 * <p>
 *  <管道转发>
 * </p>
 * @author xuliangliang
 * @since 2023/12/10 18:25
 * @version 1.0.0
 */
public abstract class AbstractForwardingPipeline<T> extends AbstractPipeline<T> {


    protected AbstractForwardingPipeline(@NonNull String name, @NonNull Pipeline<? super T> next) {
       super(name, next);
    }

    @Override
    public void forward(PipelineContext ctx, T t) {
        getNext().process(ctx, t);
    }

    @Override
    public String toString() {
        return getName() + "->" + getNext();
    }
}
