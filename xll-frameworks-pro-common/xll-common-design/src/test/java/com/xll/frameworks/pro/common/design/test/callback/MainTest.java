package com.xll.frameworks.pro.common.design.test.callback;

import com.xll.frameworks.pro.common.design.callback.Callback;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
/**
 * 功能描述: <br>
 * <p>
 *  <测试>
 * </p>
 * @author xuliangliang
 * @since 2023/11/23 15:04
 * @version 1.0.0
 */
class MainTest {
    private Integer callingCount = 0;

    @Test
    void test() {
        Callback callback = () -> callingCount++;

        var task = new TestSimpleTask();

        assertEquals(Integer.valueOf(0), callingCount, "Initial calling count of 0");

        task.executeWith(callback);

        assertEquals(Integer.valueOf(1), callingCount, "Callback called once");

        task.executeWith(callback);

        assertEquals(Integer.valueOf(2), callingCount, "Callback called twice");

    }
}
