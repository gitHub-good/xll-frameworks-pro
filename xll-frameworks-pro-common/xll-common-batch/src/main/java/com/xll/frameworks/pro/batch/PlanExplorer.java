package com.xll.frameworks.pro.batch;

/**
 * 功能描述: <br>
 * <p>
 *  <计划资源管理器>
 * </p>
 * @author xuliangliang
 * @since 2023/5/31 23:47
 * @version 1.0.0
 */
public interface PlanExplorer {
    /**
     * 获取计划实例
     * @param planName 计划名称
     * @return 实例
     */
    default PlanInstance getPlanInstance(String planName) {
        throw new UnsupportedOperationException();
    }
}
