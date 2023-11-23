package com.xll.frameworks.pro.common.design.test.retry;

import com.xll.frameworks.pro.common.design.retry.BusinessException;
import com.xll.frameworks.pro.common.design.retry.BusinessOperation;

public class TestBusinessOperation implements BusinessOperation<String> {

    private final String name;
    public TestBusinessOperation(String name) {
        this.name = name;
    }
    @Override
    public String perform() throws BusinessException {
        if (name.equals("error")) {
            throw new BusinessException("error 异常");
        }
        return name + " 已处理";
    }
}
