package com.xll.frameworks.pro.common.design.pipeline.v2;

import java.util.function.Function;
/**
 * 功能描述: <br>
 * <p>
 *  <函数管道构建器>
 * </p>
 * @author xuliangliang
 * @since 2023/12/10 18:18
 * @version 1.0.0
 */
public final class FunctionalPipelineBuilder<T, P extends Pipeline<T>> implements PipelineBuilder {

    private final Function<Pipeline<? super T>, P> factory;

    @SuppressWarnings("unchecked")
    public FunctionalPipelineBuilder() {
        this((Pipeline<? super T> next) -> (P) next);
    }

    private FunctionalPipelineBuilder(Function<Pipeline<? super T>, P> nextFactory) {
        this.factory = nextFactory;
    }

    public FunctionalPipelineBuilder<T, P> add(Function<Pipeline<? super T>, ? extends AbstractForwardingPipeline<T>> nextFactory) {
        return new FunctionalPipelineBuilder<>(factory.compose(nextFactory));
    }

    public P end(AbstractEndPipeline<T> abstractEndPipeline) {
        return factory.apply(abstractEndPipeline);
    }
}
