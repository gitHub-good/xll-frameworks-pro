package com.xll.frameworks.pro.common.design.test.pipeline.v2;

import com.xll.frameworks.pro.common.design.pipeline.v2.AbstractForwardingPipeline;
import com.xll.frameworks.pro.common.design.pipeline.v2.Pipeline;
import com.xll.frameworks.pro.common.design.pipeline.v2.PipelineContext;
import lombok.NonNull;
import lombok.extern.slf4j.Slf4j;

/**
 * 功能描述: <br>
 * <p>
 *  <函数支持>
 * </p>
 * @author xuliangliang
 * @since 2023/12/10 18:26
 * @version 1.0.0
 */
@Slf4j
public final class DefaultForwardingPipeline extends AbstractForwardingPipeline<String> {

    public DefaultForwardingPipeline(@NonNull String name, @NonNull Pipeline<? super String> next) {
        super(name, next);
    }

    @Override
    protected void doProcess(PipelineContext ctx, String inputArgs) {
        log.info("DefaultForwardingPipeline.process inputArgs {}", inputArgs + getName());
    }
}
