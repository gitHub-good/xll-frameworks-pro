package com.xll.frameworks.pro.common.metrics.executor;

import java.util.concurrent.ThreadFactory;

/**
 * <p>
 *  自定义线程工厂
 * </p>
 *
 * @author liangliang.xu
 * @since 2021/11/3 7:41 下午
 */
public class TaskCustomThreadFactory implements ThreadFactory {

    private final String msg;
    public TaskCustomThreadFactory(String msg){
        this.msg = msg;
    }

    @Override
    public Thread newThread(Runnable r) {
        return new Thread(r, "xll_task_"+msg+"_"+r.hashCode());
    }
}
