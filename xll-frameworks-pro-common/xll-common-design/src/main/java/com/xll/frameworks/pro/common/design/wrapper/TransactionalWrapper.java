package com.xll.frameworks.pro.common.design.wrapper;

import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.function.Function;
import java.util.function.Supplier;

/**
 * 功能描述: <br>
 * <p>
 *  <事物包装器>
 *  使用场景：业务私有方法原子化数据库操作可做事物包装
 * </p>
 * @author xuliangliang
 * @since 2024/1/14 17:55
 * @version 1.0.0
 */
@Component
public class TransactionalWrapper extends AbstractWrapper {

    private static final TransactionalWrapper INSTANCE = new TransactionalWrapper();

    public static TransactionalWrapper getInstance() {
        return TransactionalWrapper.INSTANCE;
    }

    @Transactional(rollbackFor = Exception.class)
    @Override
    public <T> T wrap(Function<Object[], T> function, Object... params) {
        return function.apply(params);
    }

    @Transactional(rollbackFor = Exception.class)
    @Override
    public <T> T wrap(Supplier<T> supplier) {
        return supplier.get();
    }

    @Transactional(rollbackFor = Exception.class)
    @Override
    public void wrap(Runnable runnable) {
        runnable.run();
    }
}
