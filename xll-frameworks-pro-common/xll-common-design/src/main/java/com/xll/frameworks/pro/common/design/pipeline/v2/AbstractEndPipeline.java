package com.xll.frameworks.pro.common.design.pipeline.v2;

import lombok.Getter;
import lombok.extern.slf4j.Slf4j;

/**
 * 功能描述: <br>
 * <p>
 *  <结束管道>
 * </p>
 * @author xuliangliang
 * @since 2023/12/10 18:18
 * @version 1.0.0
 */
@Getter
@Slf4j
public abstract class AbstractEndPipeline<T> extends AbstractPipeline<T> {

    protected AbstractEndPipeline(String name) {
        super(name);
    }

    @Override
    public void process(PipelineContext ctx, T inputArgs) {
        //处理当前流水线节点 结束节点不向下流转
        this.doProcess(ctx, inputArgs);
    }

    @Override
    public final void forward(PipelineContext ctx, T t) {
        log.error("结束管道 不支持转发");
        throw new UnsupportedOperationException("结束管道 不支持转发");
    }

    @Override
    public String toString() {
        return getName();
    }
}
