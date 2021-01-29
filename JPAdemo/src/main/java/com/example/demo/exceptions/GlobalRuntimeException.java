package com.example.demo.exceptions;

import com.example.demo.model.enums.ResponseCode;
import lombok.Getter;
import lombok.Setter;

/**
 * @author kuanglifang
 * @date 2021/1/19 10:50
 */
public class GlobalRuntimeException extends RuntimeException {
    @Setter
    @Getter
    private String msg;
    @Setter
    @Getter
    private int code;

    public GlobalRuntimeException(Throwable a, int code, String message) {
        super(a);
        this.code = code;
        this.msg = message;
    }

    public GlobalRuntimeException(int code, String message) {
        super(message);
        this.code = code;
        this.msg = message;
    }

    public GlobalRuntimeException(ResponseCode responseCode) {
        super("code =" + responseCode.getCode() + "message = " + responseCode.getDesc());
        this.code = responseCode.getCode();
        this.msg = responseCode.getDesc();
    }

    public static GlobalRuntimeException exception(String message) {
        return new GlobalRuntimeException(ResponseCode.INTERNAL_ERROR.getCode(), message);
    }

    public static GlobalRuntimeException exceptionExternal(String message) {
        return new GlobalRuntimeException(ResponseCode.INTERNAL_SERVICE_ERROR.getCode(), message);
    }

    /***
     * 通用提示信息
     * @param message 异常信息
     * @return 全局异常
     */
    public static GlobalRuntimeException exceptionError(String message) {
        return new GlobalRuntimeException(ResponseCode.ERROR.getCode(), message);
    }
}
