package com.xll.frameworks.pro.common.design.retry;
/**
 * 功能描述: <br>
 * <p>
 *  <业务处理异常类>
 * </p>
 * @author xuliangliang
 * @since 2023/11/23 16:20
 * @version 1.0.0
 */
public class BusinessException extends Exception{
    public BusinessException(String message) {
        super(message);
    }
}
