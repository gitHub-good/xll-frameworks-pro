package com.xll.frameworks.pro.common.metrics.executor;

import com.xll.frameworks.pro.common.metrics.constant.ExecutorFunctionEnum;
import io.micrometer.core.instrument.MeterRegistry;
import io.micrometer.core.instrument.Tags;
import io.micrometer.core.instrument.Timer;
import lombok.Getter;
import lombok.extern.slf4j.Slf4j;
import org.apache.skywalking.apm.toolkit.trace.RunnableWrapper;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;

import javax.annotation.Nonnull;
import java.util.concurrent.Callable;
import java.util.concurrent.Future;

/**
 * <p>
 * 自定义线程池
 * </p>
 *
 * @author liangliang.xu
 * @since 2021/11/2 3:12 下午
 */
@Getter
@Slf4j
public class ThreadPoolTaskExecutorMetric extends ThreadPoolTaskExecutor {
    private boolean tempPoolFlag;
    private ExecutorFunctionEnum nameEnum;
    private String tag;
    private Timer executionTimer;
    private Timer idleTimer;
    private MeterRegistry registry;



    @Override
    public void execute(Runnable task) {
        super.execute(new TimedRunnable(task));
    }

    @Override
    public Future<?> submit(Runnable task) {
        return super.submit(new TimedRunnable(task));
    }

    @Override
    public <T> Future<T> submit(Callable<T> task) {
        return super.submit(new TimedCallable<>(task));
    }

    class TimedRunnable implements Runnable {

        private final Runnable command;
        private final Timer.Sample idleSample;

        public TimedRunnable(Runnable command) {
            this.command = command;
            this.idleSample = Timer.start(registry);
        }

        @Override
        public void run() {
            idleSample.stop(idleTimer);
            Timer.Sample executionSample = Timer.start(registry);
            try {
                command.run();
            } finally {
                executionSample.stop(executionTimer);
            }
        }

    }

    class TimedCallable<T> implements Callable<T> {

        private final Callable<T> command;
        private final Timer.Sample idleSample;

        public TimedCallable(Callable<T> command) {
            this.command = command;
            this.idleSample = Timer.start(registry);
        }

        @Override
        public T call() throws Exception {
            idleSample.stop(idleTimer);
            Timer.Sample executionSample = Timer.start(registry);
            try {
                return command.call();
            } finally {
                executionSample.stop(executionTimer);
            }
        }
    }


    public void setTag(String tag) {
        this.tag = tag;
    }

    public void setNameEnum(ExecutorFunctionEnum nameEnum) {
        this.nameEnum = nameEnum;
    }

    public void setTempPoolFlag(boolean tempPoolFlag) {
        this.tempPoolFlag = tempPoolFlag;
    }

    public void setRegistry(MeterRegistry registry) {
        this.registry = registry;
    }

    public void setExecutionTimer(Timer executionTimer) {
        this.executionTimer = executionTimer;
    }

    public void setIdleTimer(Timer idleTimer) {
        this.idleTimer = idleTimer;
    }

    public static class Builder {
        private boolean tempPoolFlag;
        private ExecutorFunctionEnum nameEnum;
        private String tag;
        private int corePoolSize;
        private int maximumPoolSize;
        private int queueCapacity;

        private MeterRegistry registry;

        public Builder tempPoolFlag(boolean tempPoolFlag) {
            this.tempPoolFlag = tempPoolFlag;
            return this;
        }

        public Builder nameEnum(ExecutorFunctionEnum nameEnum) {
            this.nameEnum = nameEnum;
            return this;
        }

        public Builder tag(String tag) {
            this.tag = tag;
            return this;
        }

        public Builder corePoolSize(int corePoolSize) {
            this.corePoolSize = corePoolSize;
            return this;
        }

        public Builder maximumPoolSize(int maximumPoolSize) {
            this.maximumPoolSize = maximumPoolSize;
            return this;
        }

        public Builder queueCapacity(int queueCapacity) {
            this.queueCapacity = queueCapacity;
            return this;
        }


        public Builder meterRegistry(MeterRegistry registry) {
            this.registry = registry;
            return this;
        }

        public ThreadPoolTaskExecutorMetric build() {
            ThreadPoolTaskExecutorMetric executor = new ThreadPoolTaskExecutorMetric();
            executor.setNameEnum(nameEnum);
            executor.setTag(tag);
            executor.setTempPoolFlag(tempPoolFlag);
            executor.setRegistry(registry);
            executor.setExecutionTimer(registry.timer("executor.execution", Tags.of("name", nameEnum.getName())));
            executor.setIdleTimer(registry.timer("executor.idle", Tags.of("name", nameEnum.getName())));

            executor.setCorePoolSize(corePoolSize);
            executor.setMaxPoolSize(maximumPoolSize);
            executor.setQueueCapacity(queueCapacity);
            executor.setKeepAliveSeconds(60);
            executor.setThreadNamePrefix("cepDataSourceExecutor-");
            executor.setRejectedExecutionHandler(new TaskRejectedExecutionHandler());
            executor.setThreadFactory(new TaskCustomThreadFactory(tag));
            executor.setWaitForTasksToCompleteOnShutdown(true);
            executor.setAwaitTerminationSeconds(60);
            executor.setTaskDecorator(RunnableWrapper::new);
            executor.initialize();
            return executor;
        }

    }

    @Override
    public void shutdown() {
        log.info("线程池关闭流程 - 线程池 {} 关闭", nameEnum.getName());
        try {
            ExecutorServiceFactoryMetrics.remove(nameEnum, tag);
        } finally {
            super.shutdown();
        }
    }
}
