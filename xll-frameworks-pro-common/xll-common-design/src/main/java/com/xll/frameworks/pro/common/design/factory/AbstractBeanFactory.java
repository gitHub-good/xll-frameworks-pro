package com.xll.frameworks.pro.common.design.factory;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Map;
import java.util.Optional;

/**
 * 功能描述: <br>
 * <p>
 *  <抽象bean工厂>
 * </p>
 * @author xuliangliang
 * @since 2024/2/21 16:24
 * @version 1.0.0
 */
@Slf4j
public abstract class AbstractBeanFactory<T> {

    protected AbstractBeanFactory() {
        log.info("AbstractBeanFactory new bean factory:{}", this.getClass().getName());
    }
    private BeanFactory beanFactory;
    protected Map<String, T> beanNameMap;

    @Autowired
    public void setBeanFactory(BeanFactory beanFactory) {
        this.beanFactory = beanFactory;
    }

    @Autowired(required = false)
    public void setBeanNameMap(Map<String, T> beanNameMap) {
        this.beanNameMap = beanNameMap;
    }

    public T getByName(String key) {
        return beanNameMap.get(key);
    }

    public <R extends T> R getByClass(Class<R> cls) {
        return beanFactory.getBean(cls);
    }

    public <R extends T> Optional<R> getOptionalByClass(Class<R> cls) {
        return Optional.of(beanFactory.getBean(cls));
    }

    public T get(String name, Class<? extends T> cls) {
        return Optional.ofNullable(beanNameMap.get(name)).orElse(beanFactory.getBean(cls));
    }

    /**
     * 默认bean
     * @return bean
     */
    protected abstract T getDefaultBean();

}
