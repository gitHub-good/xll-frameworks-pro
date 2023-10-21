package com.xll.frameworks.pro.common.metrics.executor;

import cn.hutool.core.map.MapUtil;
import com.xll.frameworks.pro.common.metrics.constant.ExecutorFunctionEnum;
import com.xll.frameworks.pro.common.metrics.constant.ExecutorMetricsTagEnum;
import io.micrometer.core.instrument.Gauge;
import io.micrometer.core.instrument.MeterRegistry;
import jakarta.annotation.Resource;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * 功能描述: <br>
 * <p>
 *  <线程池指标监控>
 * </p>
 * @author xuliangliang
 * @since 2023/10/22 00:26
 * @version 1.0.0
 */
@Component
public class ExecutorServiceFactoryMetrics implements InitializingBean {
    @Resource
    private MeterRegistry meterRegistry;
    private static ExecutorServiceFactoryMetrics executorFactory;


    private final Map<ExecutorFunctionEnum, Map<String, ThreadPoolTaskExecutorMetric>> executorMap = new ConcurrentHashMap<>();


    /**
     * 线程池
     *
     * @param nameEnum        线程池使用名称
     * @param corePoolSize    核心线程数
     * @param maximumPoolSize 最大线程数据
     * @param queueCapacity   队列容量
     * @return 线程池
     */
    public ThreadPoolTaskExecutorMetric openExecutor(ExecutorFunctionEnum nameEnum, int corePoolSize,
                                                     int maximumPoolSize, int queueCapacity) {
        return openExecutor(nameEnum, corePoolSize, maximumPoolSize, queueCapacity, nameEnum.getName(), false);
    }

    /**
     * 线程池
     *
     * @param nameEnum        线程池使用名称
     * @param corePoolSize    核心线程数
     * @param maximumPoolSize 最大线程数据
     * @param queueCapacity   队列容量
     * @param tag             线程标签 全局唯一
     * @return 线程池
     */
    public ThreadPoolTaskExecutorMetric openExecutor(ExecutorFunctionEnum nameEnum, int corePoolSize,
                                                     int maximumPoolSize, int queueCapacity, String tag) {
        return openExecutor(nameEnum, corePoolSize, maximumPoolSize, queueCapacity, tag, false);
    }

    /**
     * 线程池
     *
     * @param nameEnum        线程池使用名称
     * @param corePoolSize    核心线程数
     * @param maximumPoolSize 最大线程数据
     * @param queueCapacity   队列容量
     * @param tag             线程标签 全局唯一
     * @param tempPoolFlag    临时线程池标识
     * @return 线程池
     */
    public ThreadPoolTaskExecutorMetric openExecutor(ExecutorFunctionEnum nameEnum, int corePoolSize,
                                                     int maximumPoolSize, int queueCapacity, String tag, boolean tempPoolFlag) {
        ThreadPoolTaskExecutorMetric executor = new ThreadPoolTaskExecutorMetric.Builder()
                .nameEnum(nameEnum)
                .tag(tag)
                .tempPoolFlag(tempPoolFlag)
                .corePoolSize(corePoolSize)
                .maximumPoolSize(maximumPoolSize)
                .queueCapacity(queueCapacity)
                .meterRegistry(meterRegistry)
                .build();
        if (executorMap.containsKey(nameEnum)) {
            executorMap.get(nameEnum).put(executor.getTag(), executor);
        } else {
            executorMap.put(nameEnum, MapUtil.of(executor.getTag(), executor));
        }
        return executor;
    }

    public static void remove(ExecutorFunctionEnum nameEnum, String tag) {
        if (executorFactory.executorMap.containsKey(nameEnum)) {
            executorFactory.executorMap.get(nameEnum).remove(tag);
        }
    }

    @Override
    public void afterPropertiesSet() throws Exception {
        ExecutorServiceFactoryMetrics.executorFactory = this;

        Arrays.stream(ExecutorFunctionEnum.values()).forEach(nameEnum ->
                Arrays.stream(ExecutorMetricsTagEnum.values()).forEach(tagKeyEnum ->  registerMetric(nameEnum, tagKeyEnum)));
    }

    private void registerMetric(ExecutorFunctionEnum nameEnum, ExecutorMetricsTagEnum tagKeyEnum) {
        Gauge.builder("xll.executor." + nameEnum.getName(), () -> {
            Map<String, ThreadPoolTaskExecutorMetric> wrapperMap = executorMap.get(nameEnum);
            if (MapUtil.isEmpty(wrapperMap)) {
                return 0;
            }
            return wrapperMap.values().stream().mapToLong(tagKeyEnum.getFunction()).sum();
        }).description(nameEnum.getMsg()).tag("name", tagKeyEnum.getTagKey()).register(meterRegistry);
    }
}
