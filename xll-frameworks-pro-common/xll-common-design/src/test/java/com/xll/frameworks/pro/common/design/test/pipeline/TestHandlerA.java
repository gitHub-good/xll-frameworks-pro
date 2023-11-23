package com.xll.frameworks.pro.common.design.test.pipeline;

import com.xll.frameworks.pro.common.design.pipeline.Handler;

public class TestHandlerA implements Handler<String, String> {
    @Override
    public String process(String input) {
        return input + " @A";
    }
}
