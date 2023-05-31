package com.xll.frameworks.pro.batch;

import com.xll.frameworks.pro.batch.core.DefaultPlanParametersValidator;

/**
 * 功能描述: <br>
 * <p>
 * @Description 任务计划
 * </p>
 * @author xuliangliang
 * @createTime 2023/5/31 23:15
 * @version 1.0.0
 */
public interface Plan {
    /**
     * 获取计划Key
     * @return key
     */
    String getKey();

    /**
     * 计划一下
     * @param execution 执行
     */
    void execute(PlanExecution execution);

    /**
     * 获取校验器
     * @return 校验
     */
    default PlanParametersValidator getPlanParametersValidator() {
        return new DefaultPlanParametersValidator();
    }

}
