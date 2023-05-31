package com.xll.frameworks.pro.batch;

import java.util.HashMap;
import java.util.Map;

/**
 * 功能描述: <br>
 * <p>
 *  <计划属性集>
 * </p>
 * @author xuliangliang
 * @since 2023/5/31 23:17
 * @version 1.0.0
 */
public class PlanParameters {
    private final Map<String, PlanParameter<?>> parameters;
    public PlanParameters() {
        this.parameters = new HashMap<>();
    }
    public PlanParameters(Map<String, PlanParameter<?>> parameters) {
        this.parameters = new HashMap<>(parameters);
    }

    public String getString(String key) {
        if (!parameters.containsKey(key)) {
            return null;
        }
        PlanParameter<?> planParameter = parameters.get(key);
        if (!planParameter.getType().equals(String.class)) {
            throw new IllegalArgumentException("Key " + key + " is not of type String");
        }
        return (String) planParameter.getValue();
    }
}
