package com.xgene.article.dto.req.jpautils;

import com.github.wenhao.jpa.PredicateBuilder;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class SecondPBHandler extends PredicateBuilderHandler {
    public SecondPBHandler(PredicateBuilderHandler next) {
        super(next);
    }

    @Override
    <T> PredicateBuilder handle(PredicateBuilder newInstance, String methodName,boolean condition, String columnName, T columnValue)throws IllegalAccessException,InvocationTargetException {
        try {
            Method method = PredicateBuilder.class.getMethod(methodName, boolean.class, String.class, Comparable.class);
            return (PredicateBuilder)  method.invoke(newInstance, condition, columnName, columnValue);
        } catch (NoSuchMethodException nsme) {
            System.out.println(methodName+"::"+getClass().getName()+"::"+nsme.getMessage());
            return doNext(newInstance, methodName, condition, columnName, columnValue);
        }
    }
}
