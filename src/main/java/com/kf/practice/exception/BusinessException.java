package com.kf.practice.exception;

/**
 * @author tangjinhui
 * @Description：
 * @date 2018/1/30
 */
public class BusinessException extends  RuntimeException {

    private static final long serialVersionUID = 1L;

    private String errorCode;

    private boolean propertiesKey;

    public BusinessException(String message) {
        super(message);
    }

    public BusinessException(String message, Throwable cause) {
        super(message, cause);
    }

    public BusinessException(String message, String errorCode, boolean propertiesKey) {
        super(message);
        this.errorCode = errorCode;
        this.propertiesKey = propertiesKey;
    }

    public BusinessException(String message, Throwable cause, String errorCode, boolean propertiesKey) {
        super(message, cause);
        this.errorCode = errorCode;
        this.propertiesKey = propertiesKey;
    }

    public String getErrorCode() {
        return errorCode;
    }

    public void setErrorCode(String errorCode) {
        this.errorCode = errorCode;
    }

    public boolean isPropertiesKey() {
        return propertiesKey;
    }

    public void setPropertiesKey(boolean propertiesKey) {
        this.propertiesKey = propertiesKey;
    }
}


