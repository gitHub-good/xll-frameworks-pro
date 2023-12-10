package com.xll.frameworks.pro.common.design.test.pipeline.v2;

import cn.hutool.core.lang.Assert;
import com.xll.frameworks.pro.common.design.pipeline.v2.*;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

/**
 * 功能描述: <br>
 * <p>
 *  <test>
 * </p>
 * @author xuliangliang
 * @since 2023/12/10 18:21
 * @version 1.0.0
 */
@Slf4j
class PipelineTest {

    /**
     * 管到实例化
     */
    @Test
    void pipeline_instance_test() {
        Pipeline<String> pipeline = AbstractOrdinaryPipeline.getInstance(Arrays.asList(new DemoPipelineAbstract("1"),
                new DemoPipelineAbstract("2"), new DemoPipelineAbstract("3")));

        pipeline.process(new DefaultPipelineContext("pipeline_instance_test"), "test");
        Assert.equals("1->2->3", pipeline.toString());
    }

    private static final class DemoPipelineAbstract extends AbstractOrdinaryPipeline<String> {

        public DemoPipelineAbstract(String name) {
            super(name);
        }

        @Override
        public void doProcess(PipelineContext ctx, String inputArgs) {
            log.info("DemoPipelineAbstract.process inputArgs {}", inputArgs + getName());
        }
    }


    @Test
    void functional_test() {
        Pipeline<String> p1 = new FunctionalPipelineBuilder<String, Pipeline<String>>().end(new DefaultEndPipeline("1"));
        Assert.equals("1", p1.toString());

        Pipeline<String> p2 = new FunctionalPipelineBuilder<String, Pipeline<String>>()
                        .add(next -> new DefaultForwardingPipeline("1", next))
                        .add(next -> new DefaultForwardingPipeline("2", next))
                        .end(new DefaultEndPipeline("3"));
        p2.process(new DefaultPipelineContext("functional_test"), "test");
        Assert.equals("1->2->3", p2.toString());
    }


    @Test
    void stack_test() {
        Pipeline<String> pipeline = new StackPipelineBuilder<String>()
                        .add(next -> new DefaultForwardingPipeline("1", next))
                        .add(next -> new DefaultForwardingPipeline("2", next))
                        .end(new DefaultEndPipeline("3"));
        pipeline.process(new DefaultPipelineContext("stack_test"), "test");
        Assert.equals("1->2->3", pipeline.toString());
    }
}
