package com.xll.frameworks.pro.common.design.retry;

import lombok.extern.slf4j.Slf4j;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.function.Predicate;
/**
 * 功能描述: <br>
 * <p>
 *  <业务逻辑重试模式>
 * </p>
 * @author xuliangliang
 * @since 2023/11/23 15:56
 * @version 1.0.0
 */
@Slf4j
public final class Retry<T> implements BusinessOperation<T> {
    /**
     * 业务逻辑
     */
    private final BusinessOperation<T> op;
    /**
     * 最大重试次数
     */
    private final int maxAttempts;
    /**
     * 重试间隔
     */
    private final long delay;
    /**
     * 重试次数
     */
    private final AtomicInteger attempts;
    /**
     * 忽略的异常
     */
    private final Predicate<Exception> test;
    /**
     * 错误信息
     */
    private final List<Exception> errors;

    /**
     * 构造函数
     * @param op 业务逻辑
     * @param maxAttempts 最大重试次数
     * @param delay 重试间隔
     * @param ignoreTests 忽略的异常
     */
    @SafeVarargs
    public Retry(BusinessOperation<T> op, int maxAttempts, long delay, Predicate<Exception>... ignoreTests) {
        this.op = op;
        this.maxAttempts = maxAttempts;
        this.delay = delay;
        this.attempts = new AtomicInteger();
        this.test = Arrays.stream(ignoreTests).reduce(Predicate::or).orElse(e -> false);
        this.errors = new ArrayList<>();
    }

    public List<Exception> errors() {
        return Collections.unmodifiableList(this.errors);
    }

    public int attempts() {
        return this.attempts.intValue();
    }
    @Override
    public T perform() throws BusinessException {
        do {
            try {
                return this.op.perform();
            } catch (BusinessException e) {
                doRetry(e);
            }
        } while (true);
    }

    private void doRetry(BusinessException e) throws BusinessException {
        log.warn("Retry.doRetry attempts {}", attempts.get());
        this.errors.add(e);
        if (this.attempts.incrementAndGet() >= this.maxAttempts || !this.test.test(e)) {
            throw e;
        }
        sleep();
    }

    private void sleep() {
        try {
            // 睡眠
            Thread.sleep(this.delay);
        } catch (InterruptedException f) {
            Thread.currentThread().interrupt();
        }
    }
}
