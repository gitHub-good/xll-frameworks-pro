package com.xll.frameworks.pro.common.design.factory;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
/**
 * 功能描述: <br>
 * <p>
 *  <本地缓存>
 * </p>
 * @author xuliangliang
 * @since 2024/2/28 17:18
 * @version 1.0.0
 */
public enum CacheBeanHolder {
    INSTANCE
    ;
    CacheBeanHolder() {
    }
    static final Map<String, AbstractBean> BEAN_MAP_CACHE = new ConcurrentHashMap<>();

}
