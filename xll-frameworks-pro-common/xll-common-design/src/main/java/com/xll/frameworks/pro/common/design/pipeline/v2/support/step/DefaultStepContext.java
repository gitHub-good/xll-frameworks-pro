package com.xll.frameworks.pro.common.design.pipeline.v2.support.step;

import com.xll.frameworks.pro.common.design.pipeline.v2.PipelineContext;
import lombok.extern.slf4j.Slf4j;
import org.springframework.util.ObjectUtils;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * 功能描述: <br>
 * <p>
 *  <默认上下文>
 * </p>
 * @author xuliangliang
 * @since 2023/12/10 20:49
 * @version 1.0.0
 */
@Slf4j
public class DefaultStepContext implements PipelineContext {

    /**
     * 业务管道组合功能描述
     */
    private final String actionName;

    private final Map<String, Object> propertyMap = new ConcurrentHashMap<>(128);


    public DefaultStepContext(String actionName) {
        this.actionName = actionName;
    }


    @Override
    public String getActionName() {
        return actionName;
    }

    @SuppressWarnings(value = "unchecked")
    @Override
    public <T> T getProperty(String key) {
        if(ObjectUtils.isEmpty(key)) {
            return null;
        }
        return (T) propertyMap.get(key);
    }

    @Override
    public <T> void setProperty(String key, T value) {
        if(ObjectUtils.isEmpty(key) || ObjectUtils.isEmpty(value)) {
            return;
        }
        propertyMap.put(key, value);
    }

    @Override
    public void removeProperty(String key) {
        if(ObjectUtils.isEmpty(key)) {
            return;
        }
        propertyMap.remove(key);
    }
}
