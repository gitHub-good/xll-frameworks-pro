package com.xll.frameworks.pro.common.design.test.callback;

import com.xll.frameworks.pro.common.design.callback.AbstractTask;
import lombok.extern.slf4j.Slf4j;

/**
 * 功能描述: <br>
 * <p>
 *  <测试用例>
 * </p>
 * @author xuliangliang
 * @since 2023/11/23 15:02
 * @version 1.0.0
 */
@Slf4j
class TestSimpleTask extends AbstractTask {
    @Override
    protected void execute() {
        log.info("SimpleTaskTest.execute todo......");
    }
}
