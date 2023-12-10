package com.xll.frameworks.pro.common.design.test.pipeline.v1;

import com.xll.frameworks.pro.common.design.pipeline.v1.Pipeline;
import org.junit.jupiter.api.Test;
import org.junit.platform.commons.util.StringUtils;

import static org.junit.jupiter.api.Assertions.assertTrue;

/**
 * 功能描述: <br>
 * <p>
 *  <测试用例>
 * </p>
 * @author xuliangliang
 * @since 2023/11/23 15:30
 * @version 1.0.0
 */
class MainTest {


    @Test
    void test() {
        var pipeline = new Pipeline<>(new TestHandlerA());
        String test = pipeline.register(new TestHandlerB()).register((x) -> x + " custom").execute("test");
        assertTrue(StringUtils.isNotBlank(test));
    }
}
