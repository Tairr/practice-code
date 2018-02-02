package com.kf.practice.exception;

/**
 * @author tangjinhui
 * @Description：
 * @date 2018/1/30
 */
public class ParameterException extends RuntimeException {

    private static final long serialVersionUID = 1L;

    private String errorCode;

    private boolean propertiesKey = true;

    public ParameterException(String errorCode,String message,boolean propertiesKey) {
        super(message);
        this.errorCode = errorCode;
        this.propertiesKey = propertiesKey;
    }

    public ParameterException(String message) {
        super(message);
    }

    public ParameterException(String errorCode, String message, Throwable cause) {
        this(errorCode,message,cause,true);
    }

    public ParameterException(String errorCode, String message, Throwable cause,boolean propertiesKey) {
        super(message,cause);
        this.errorCode = errorCode;
        this.propertiesKey = propertiesKey;
    }

    public String getErrorCode()
    {
        return errorCode;
    }

    public void setErrorCode(String errorCode)
    {
        this.errorCode = errorCode;
    }

    public boolean isPropertiesKey()
    {
        return propertiesKey;
    }

    public void setPropertiesKey(boolean propertiesKey)
    {
        this.propertiesKey = propertiesKey;
    }
}
