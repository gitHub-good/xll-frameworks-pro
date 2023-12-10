package com.xll.frameworks.pro.common.design.pipeline.v2;

/**
 * 功能描述: <br>
 * <p>
 *  <管道>
 * </p>
 * @author xuliangliang
 * @since 2023/12/10 18:05
 * @version 1.0.0
 */
public interface Pipeline<T> {

    /**
     * 执行
     * @param ctx 上下文
     * @param inputArgs 业务请求参数
     */
    void process(PipelineContext ctx, T inputArgs);

    /**
     * 转发
     * @param ctx 上下文
     * @param inputArgs 业务请求参数
     */
    void forward(PipelineContext ctx, T inputArgs);

}
