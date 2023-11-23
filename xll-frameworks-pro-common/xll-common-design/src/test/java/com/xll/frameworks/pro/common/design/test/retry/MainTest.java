package com.xll.frameworks.pro.common.design.test.retry;

import com.xll.frameworks.pro.common.design.retry.BusinessException;
import com.xll.frameworks.pro.common.design.retry.Retry;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.List;

class MainTest {

    @Test
    void common_retry_test() throws BusinessException {
        final var retry = new Retry<>(new TestBusinessOperation("123"), 3, 100);
        String perform = retry.perform();
        Assertions.assertEquals("123 已处理", perform);
    }

    @Test
    void error_with_retry_test() throws BusinessException {
        final var retry = new Retry<>(new TestBusinessOperation("error"), 3, 100, e -> e instanceof BusinessException);
        String perform = retry.perform();
        List<Exception> errors = retry.errors();
        Assertions.assertEquals(3, errors.size());
        Assertions.assertEquals("123 已处理", perform);
    }
}
