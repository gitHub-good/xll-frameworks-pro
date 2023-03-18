package com.xll.frameworks.pro.common.core.exception;

/**
 * 功能描述: <br>
 * <P>
 * @Description 应用异常
 * </P>
 * @author liangliang.xu
 * @version 1.0.0
 * @createTime 2023/3/18 23:25
 */
public final class ApplicationException extends RuntimeException {
    public ApplicationException() {
    }

    public ApplicationException(String message) {
        super(message);
    }

    public ApplicationException(String message, Throwable cause) {
        super(message, cause);
    }

    public ApplicationException(Throwable cause) {
        super(cause);
    }

    public ApplicationException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}