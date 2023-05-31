package com.xll.frameworks.pro.batch;

/**
 * 功能描述: <br>
 * <p>
 * 〈计划启动器〉
 * </p>
 * @author xuliangliang
 * @since 2023/5/31 22:47
 * @version 1.0.0
 */
public interface PlanLauncher {

    /**
     * 启动
     * @param plan 计划任务
     * @param planParameters 任务参数
     * @return 计划执行器
     */
    PlanExecution run(Plan plan, PlanParameters planParameters);
}
