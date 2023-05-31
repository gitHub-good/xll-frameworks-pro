package com.xll.frameworks.pro.batch.exception;

/**
 * 功能描述: <br>
 * <p>
 *  <属性校验异常>
 * </p>
 * @author xuliangliang
 * @since 2023/5/31 23:59
 * @version 1.0.0
 */
public class PlanParametersInvalidException extends RuntimeException{
    public PlanParametersInvalidException(String msg) {
        super(msg);
    }
}
