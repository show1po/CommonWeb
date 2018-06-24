package com.xgene.common.exception;

/**
 * Created by lailai on 2017/9/19.
 * 定义统一的json格式异常的返回对象
 */
public class ErrorInfo<T> {
    private ErrorStatusCode statusCode; //信息类型
    private String message; //信息内容
//    private T data; //请求返回内容

    public ErrorInfo() {
    }

    public ErrorStatusCode getStatusCode() {
        return statusCode;
    }

    public void setStatusCode(ErrorStatusCode statusCode) {
        this.statusCode = statusCode;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

//    public T getData() {
//        return data;
//    }
//
//    public void setData(T data) {
//        this.data = data;
//    }
}
