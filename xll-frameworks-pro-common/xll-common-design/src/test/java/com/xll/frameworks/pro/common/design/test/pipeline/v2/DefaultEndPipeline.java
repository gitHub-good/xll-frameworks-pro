package com.xll.frameworks.pro.common.design.test.pipeline.v2;

import com.xll.frameworks.pro.common.design.pipeline.v2.AbstractEndPipeline;
import com.xll.frameworks.pro.common.design.pipeline.v2.PipelineContext;
import lombok.extern.slf4j.Slf4j;

/**
 * 功能描述: <br>
 * <p>
 *  <默认结束管道>
 * </p>
 * @author xuliangliang
 * @since 2023/12/10 18:29
 * @version 1.0.0
 */
@Slf4j
public final class DefaultEndPipeline extends AbstractEndPipeline<String> {

    public DefaultEndPipeline(String name) {
        super(name);
    }

    @Override
    public void doProcess(PipelineContext ctx, String inputArgs) {
        log.info("DefaultEndPipeline.process actionName {} inputArgs {}", ctx.getActionName(), inputArgs + getName());
    }
}
