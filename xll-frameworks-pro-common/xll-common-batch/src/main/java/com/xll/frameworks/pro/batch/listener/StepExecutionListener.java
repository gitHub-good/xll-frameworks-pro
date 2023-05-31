package com.xll.frameworks.pro.batch.listener;

import com.xll.frameworks.pro.batch.StepExecution;
import com.xll.frameworks.pro.batch.core.ExitStatus;

/**
 * 功能描述: <br>
 * <p>
 *  <步骤执行监听器>
 * </p>
 * @author xuliangliang
 * @since 2023/6/1 00:02
 * @version 1.0.0
 */
public interface StepExecutionListener extends StepListener {

    /**
     * 步骤执行前回调
     * @param stepExecution 步骤执行器
     */
    default void beforeStep(StepExecution stepExecution) {
    }

    /**
     * 步骤执行后回调
     * @param stepExecution 执行器
     * @return 执行状态
     */
    default ExitStatus afterStep(StepExecution stepExecution) {
        return null;
    }
}
