package com.xll.frameworks.pro.common.design.aggregate;

import lombok.Getter;
import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.util.Assert;

import java.util.Map;

/**
 * 功能描述: <br>
 * <p>
 *  <抽象类>
 * </p>
 * @author xuliangliang
 * @since 2024/1/14 18:43
 * @version 1.0.0
 */
@Getter
public abstract class AbstractActionAggregate implements ActionAggregate, ApplicationContextAware {


    private ApplicationContext context;

    @Override
    public <T> T getAction(Class<T> t) {
        Map<Class<T>, T> actionMapperMap = getActionMapperMap();
        Assert.notNull(actionMapperMap, "actionMapperMap is null");
        return actionMapperMap.get(t);
    }

    protected abstract <T> Map<Class<T>, T> getActionMapperMap();




    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        context = applicationContext;
    }
}
