package com.xll.frameworks.pro.common.design.pipeline.v2;

import java.util.List;

/**
 * 功能描述: <br>
 * <p>
 *  <普通管道>
 * </p>
 * @author xuliangliang
 * @since 2023/12/10 18:10
 * @version 1.0.0
 */
public abstract class AbstractOrdinaryPipeline<T> extends AbstractPipeline<T> {

    protected AbstractOrdinaryPipeline(String name) {
        super(name);
    }

    @Override
    public void setNext(Pipeline<? super T> next) {
        super.setNext(next);
    }

    @Override
    public final void forward(PipelineContext ctx, T t) {
        if (getNext() != null) {
            getNext().process(ctx, t);
        }
    }

    @Override
    public String toString() {
        if (getNext() != null) {
            return getName() + "->" + getNext();
        }
        return getName();
    }

    public static <T> Pipeline<T> getInstance(List<? extends AbstractOrdinaryPipeline<? extends T>> pipelines) {
        if (pipelines == null || pipelines.isEmpty()) {
            throw new IllegalArgumentException("empty pipelines!");
        }
        @SuppressWarnings("unchecked")
        AbstractOrdinaryPipeline<T>[] a = pipelines.toArray(new AbstractOrdinaryPipeline[0]);
        AbstractOrdinaryPipeline<T> p = a[0];
        for (int i = 1; i < a.length; ++i) {
            p.setNext(a[i]);
            p = a[i];
        }
        p.setNext(null);
        return a[0];
    }
}
