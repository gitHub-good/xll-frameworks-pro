package com.xll.frameworks.pro.common.metrics.executor;

import java.util.concurrent.RejectedExecutionHandler;
import java.util.concurrent.ThreadPoolExecutor;

/**
 * <p>
 *  任务拒绝执行处理器
 * </p>
 *
 * @author liangliang.xu
 * @since 2021/11/2 3:14 下午
 */
public class TaskRejectedExecutionHandler implements RejectedExecutionHandler {
    @Override
    public void rejectedExecution(Runnable r, ThreadPoolExecutor executor) {
        try {
            Thread.sleep(500);
            executor.submit(r);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }
}
