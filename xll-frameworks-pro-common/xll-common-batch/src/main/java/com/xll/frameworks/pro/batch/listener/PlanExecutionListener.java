package com.xll.frameworks.pro.batch.listener;

import com.xll.frameworks.pro.batch.PlanExecution;

/**
 * 功能描述: <br>
 * <p>
 *  <计划执行监听器>
 * </p>
 * @author xuliangliang
 * @since 2023/5/31 23:54
 * @version 1.0.0
 */
public interface PlanExecutionListener {
    /**
     * 计划之前的回调
     * @param planExecution the current {@link PlanExecution}
     */
    default void beforePlan(PlanExecution planExecution) {
    }

    /**
     * 计划执行后的回调
     * @param planExecution the current {@link PlanExecution}
     */
    default void afterPlan(PlanExecution planExecution) {
    }
}
