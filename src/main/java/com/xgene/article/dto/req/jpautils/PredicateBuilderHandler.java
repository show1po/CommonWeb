package com.xgene.article.dto.req.jpautils;

import com.github.wenhao.jpa.PredicateBuilder;

import java.lang.reflect.InvocationTargetException;

public abstract class PredicateBuilderHandler {
    protected PredicateBuilderHandler next;
//    protected String methodName;
//    protected String columnName;
//    protected T columnValue;

    public PredicateBuilderHandler(PredicateBuilderHandler next) {
        this.next = next;
    }

    <T> PredicateBuilder  doNext(PredicateBuilder newInstance, String methodName, boolean condition, String columnName, T columnValue)throws IllegalAccessException,InvocationTargetException {
        if (next != null) {
           return next.handle(newInstance,methodName,condition,columnName , columnValue);
        }else {
            return null;
        }
    }

    abstract <T> PredicateBuilder handle(PredicateBuilder instance,String methodName,boolean condition, String columnName, T columnValue)throws IllegalAccessException,InvocationTargetException;
}
