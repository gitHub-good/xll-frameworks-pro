package com.xll.frameworks.pro.common.design.factory;

import jakarta.annotation.PostConstruct;

/**
 * 功能描述: <br>
 * <p>
 *  <Bean基类>
 * </p>
 * @author xuliangliang
 * @since 2024/2/28 17:17
 * @version 1.0.0
 */
public abstract class AbstractBean {
    @PostConstruct
    public void init() {
        CacheBeanHolder.BEAN_MAP_CACHE.put("beanHolder", this);
    }
}
