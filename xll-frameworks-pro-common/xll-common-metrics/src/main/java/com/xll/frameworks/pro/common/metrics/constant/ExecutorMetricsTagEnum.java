package com.xll.frameworks.pro.common.metrics.constant;

import com.xll.frameworks.pro.common.metrics.executor.ThreadPoolTaskExecutorMetric;
import lombok.Getter;

import java.util.function.ToLongFunction;
/**
 * 功能描述: <br>
 * <p>
 *  <指标tag定义>
 * </p>
 * @author xuliangliang
 * @since 2023/10/22 00:49
 * @version 1.0.0
 */
@Getter
public enum ExecutorMetricsTagEnum {
    CORE_SIZE("core.size", ThreadPoolTaskExecutorMetric::getCorePoolSize,"核心数"),
    MAX_SIZE("max.size", ThreadPoolTaskExecutorMetric::getMaxPoolSize,"最大数"),
    ACTIVE_SIZE("active.size", ThreadPoolTaskExecutorMetric::getActiveCount,"活跃数"),
    QUEUE_SIZE("queue.size", (executor)-> executor.getThreadPoolExecutor().getQueue().size(),"容量数"),
    COMPLETED_SIZE("completed.size", (executor) -> executor.getThreadPoolExecutor().getCompletedTaskCount(),"完成数"),
    ;
    private final String tagKey;
    private final ToLongFunction<ThreadPoolTaskExecutorMetric> function;
    private final String msg;

    ExecutorMetricsTagEnum(String tagKey, ToLongFunction<ThreadPoolTaskExecutorMetric> function, String msg) {
        this.tagKey = tagKey;
        this.function = function;
        this.msg = msg;
    }
}
