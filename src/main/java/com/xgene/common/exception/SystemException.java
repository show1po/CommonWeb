package com.xgene.common.exception;

public class SystemException extends RuntimeException {
    private ErrorStatusCode statusCode;
    public SystemException(String message){
        super(message);
        statusCode = ErrorStatusCode.SYSTEM_UNKNOWN_ERROR;
    }
    public SystemException(ErrorStatusCode statusCode, String errorMessage){
        super(errorMessage);
        statusCode = statusCode;
    }

    public ErrorStatusCode getStatusCode() {
        return statusCode;
    }
}
