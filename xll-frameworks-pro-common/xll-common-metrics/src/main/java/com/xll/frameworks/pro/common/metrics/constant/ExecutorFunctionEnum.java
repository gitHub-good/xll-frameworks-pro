package com.xll.frameworks.pro.common.metrics.constant;

import lombok.Getter;
/**
 * 功能描述: <br>
 * <p>
 *  <线程功能>
 * </p>
 * @author xuliangliang
 * @since 2023/10/22 00:28
 * @version 1.0.0
 */
@Getter
public enum ExecutorFunctionEnum {
    CEP_REPEAT_DATA_CLEAN_POOL("repeat.data.clean.pool", "重复数据清理任务线程池"),
    GLOBAL_PLAN_PROCESS_POOL("global.plan.process.pool", "全局处理线程池"),
    DELAY_PROCESS_POOL("delay.process.pool", "延迟处理线程池"),
    ASYNC_DATA_SOURCE_PROCESS_POOL("async.data.source.process.pool", "异步执行计划实例流程线程池"),
    STREAM_PLAN_PROCESS_POOL("stream.plan.process.pool", "流式处理线程池"),
    TEMP_STREAM_PROCESS_POOL("temp.stream.process.pool", "临时处理线程池"),
    ;
    private final String name;
    private final String msg;

    ExecutorFunctionEnum(String name, String msg) {
        this.name = name;
        this.msg = msg;
    }
}
