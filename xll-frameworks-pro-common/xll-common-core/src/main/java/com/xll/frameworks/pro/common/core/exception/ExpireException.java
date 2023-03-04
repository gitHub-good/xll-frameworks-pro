package com.xll.frameworks.pro.common.core.exception;

public class ExpireException extends RuntimeException {
	/**
	 * 
	 */
	private static final long serialVersionUID = 3056819439922242913L;
	public ExpireException(String msg, Throwable cause) {
        super(msg, cause);
    }
    public ExpireException(String s) {
        super(s);
    }
    @Override
    public Throwable fillInStackTrace() {
        return this;
    }
}