package com.xll.frameworks.pro.batch;

import com.xll.frameworks.pro.batch.exception.PlanParametersInvalidException;
import org.springframework.lang.Nullable;

/**
 * 功能描述: <br>
 * <p>
 *  <计划属性校验>
 * </p>
 * @author xuliangliang
 * @since 2023/5/31 23:59
 * @version 1.0.0
 */
@FunctionalInterface
public interface PlanParametersValidator {

    /**
     * 校验
     * @param parameters 属性集
     * @throws PlanParametersInvalidException 无效参数异常
     */
    void validate(@Nullable PlanParameters parameters) throws PlanParametersInvalidException;
}
