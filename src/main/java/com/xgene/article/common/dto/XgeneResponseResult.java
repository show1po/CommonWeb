package com.xgene.article.common.dto;

import com.xgene.article.common.exception.ErrorStatusCode;

import java.io.Serializable;

public class XgeneResponseResult<T> implements Serializable {
    private String message;
    private T data;
    private ErrorStatusCode statusCode;
    private static final long serialVersionUID = 1L;
    /**
     * 返回一个處理失敗的结果集
     * @param statusCode  错误编码
     * @return
     */
    public static XgeneResponseResult failure(ErrorStatusCode statusCode, String message){
        return new XgeneResponseResult(statusCode,message,null);
    }

    /***
     * 返回一个處理正常的结果集
     * @param data   数据参数
     * @param <T>    泛型
     * @return
     */
    public static <T> XgeneResponseResult<T> success(T data){
        return new XgeneResponseResult<T>( ErrorStatusCode.SYSTEM_SUCCESS,data);
    }


    public XgeneResponseResult(ErrorStatusCode statusCode, String message, T data) {
        this.statusCode = statusCode;
        this.message = message;
        this.data = data;
    }
    public XgeneResponseResult(ErrorStatusCode statusCode, T data) {
        this.statusCode = statusCode;
        this.data = data;
    }
}
