package com.xll.frameworks.pro.common.design.wrapper;

import java.util.List;
import java.util.function.Function;
import java.util.function.Supplier;

/**
 * 功能描述: <br>
 * <p>
 *  <抽象包装器-可扩展>
 * </p>
 * @author xuliangliang
 * @since 2024/1/14 18:01
 * @version 1.0.0
 */
public abstract class AbstractWrapper implements CommonWrapper{

    @Override
    public <T> T wrap(Function<Object[], T> function, Object... params) {
        return null;
    }

    @Override
    public <T> T wrap(Supplier<T> supplier) {
        return null;
    }

    public <T> List<T> wrap(PageWrapper.Query<T> query) {
        return query.doQuery();
    }

    @Override
    public void wrap(Runnable runnable) {

    }
}
