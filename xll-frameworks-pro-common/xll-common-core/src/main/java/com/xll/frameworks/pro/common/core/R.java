package com.xll.frameworks.pro.common.core;

import com.xll.frameworks.pro.common.core.constant.Constant;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

/**
 * 功能描述: <br>
 * <P>
 * @Description RPC响应封装报文
 * </P>
 * @author liangliang.xu
 * @version 1.0.0
 * @createTime 2023/3/19 00:04 
 */
@Getter
@Setter
public class R<T> implements Serializable {

    /**
     * 成功
     */
    public static final int SUCCESS = Constant.SUCCESS;

    /**
     * 失败
     */
    public static final int FAIL = Constant.FAIL;

    private int code;

    private String msg;

    private T data;

    public static <T> R<T> ok() {
        return result(null, SUCCESS, null);
    }

    public static <T> R<T> ok(T data) {
        return result(data, SUCCESS, null);
    }

    public static <T> R<T> ok(T data, String msg) {
        return result(data, SUCCESS, msg);
    }

    public static <T> R<T> fail() {
        return result(null, FAIL, null);
    }

    public static <T> R<T> fail(String msg) {
        return result(null, FAIL, msg);
    }

    public static <T> R<T> fail(T data) {
        return result(data, FAIL, null);
    }

    public static <T> R<T> fail(T data, String msg) {
        return result(data, FAIL, msg);
    }

    public static <T> R<T> fail(int code, String msg) {
        return result(null, code, msg);
    }

    private static <T> R<T> result(T data, int code, String msg) {
        R<T> apiResult = new R<>();
        apiResult.setCode(code);
        apiResult.setData(data);
        apiResult.setMsg(msg);
        return apiResult;
    }
}
