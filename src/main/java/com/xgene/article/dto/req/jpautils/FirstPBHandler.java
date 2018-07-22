package com.xgene.article.dto.req.jpautils;

import com.github.wenhao.jpa.PredicateBuilder;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class FirstPBHandler extends PredicateBuilderHandler {
    public FirstPBHandler(PredicateBuilderHandler next) {
        super(next);
    }

    @Override
    <T> PredicateBuilder handle(PredicateBuilder newInstance,String methodName,boolean condition, String columnName, T columnValue)throws IllegalAccessException,InvocationTargetException {
        try {
            Method method = PredicateBuilder.class.getMethod(methodName, boolean.class, String.class, Object[].class);
            return ((PredicateBuilder) method.invoke(newInstance, condition, columnName, new Object[]{columnValue}));
        } catch (NoSuchMethodException nsme) {
            System.out.println(methodName+"::"+getClass().getName()+"::"+nsme.getMessage());
            return doNext(newInstance, methodName, condition, columnName, columnValue);
        }
    }
}
