package com.xll.frameworks.pro.common.design.test.pipeline.v1;

import com.xll.frameworks.pro.common.design.pipeline.v1.Handler;

public class TestHandlerB implements Handler<String, String> {
    @Override
    public String process(String input) {
        return input + " @B";
    }
}
