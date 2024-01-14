package com.xll.frameworks.pro.common.design.pipeline.v2.support;

import com.xll.frameworks.pro.common.design.pipeline.v2.AbstractForwardingPipeline;
import com.xll.frameworks.pro.common.design.pipeline.v2.Pipeline;
import com.xll.frameworks.pro.common.design.pipeline.v2.PipelineContext;
import lombok.NonNull;
import lombok.extern.slf4j.Slf4j;

/**
 * 功能描述: <br>
 * <p>
 *  <转发扩展步骤支持>
 * </p>
 * @author xuliangliang
 * @since 2023/12/10 21:56
 * @version 1.0.0
 */
@Slf4j
public class ForwardingPipelineExtStepSupport extends AbstractForwardingPipeline<String> {
    public ForwardingPipelineExtStepSupport(@NonNull String name, @NonNull Pipeline<? super String> next) {
        super(name, next);
    }

    @Override
    protected void doProcess(PipelineContext ctx, String inputArgs) {
        log.info("ForwardingPipelineExtChannelSupport.process inputArgs {}", inputArgs + getName());


    }
}
