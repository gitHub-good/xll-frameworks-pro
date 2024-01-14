package com.xll.frameworks.pro.common.design.test.wrapper;

import com.xll.frameworks.pro.common.design.wrapper.TransactionalWrapper;
import org.junit.jupiter.api.Test;

/**
 * 功能描述: <br>
 * <p>
 *  <测试>
 * </p>
 * @author xuliangliang
 * @since 2024/1/14 18:09
 * @version 1.0.0
 */
public class TransactionalWrapperTest {

    @Test
    public void test() {
        TransactionalWrapper.getInstance().wrap((params) -> {
            System.out.println("1");
            throw new RuntimeException("1");
        });
    }
}
