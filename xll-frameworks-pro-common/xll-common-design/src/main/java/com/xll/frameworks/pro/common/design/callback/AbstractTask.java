package com.xll.frameworks.pro.common.design.callback;

import java.util.Optional;
/**
 * 功能描述: <br>
 * <p>
 *  <执行任务>
 * </p>
 * @author xuliangliang
 * @since 2023/11/23 14:59
 * @version 1.0.0
 */
public abstract class AbstractTask {
    public final void executeWith(Callback callback) {
        execute();
        Optional.ofNullable(callback).ifPresent(Callback::call);
    }

    /**
     * 执行逻辑
     */
    protected abstract void execute();
}
