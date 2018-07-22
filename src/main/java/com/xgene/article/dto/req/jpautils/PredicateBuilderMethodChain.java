package com.xgene.article.dto.req.jpautils;

import com.github.wenhao.jpa.PredicateBuilder;
public class PredicateBuilderMethodChain {
    public static <T> PredicateBuilder execute(PredicateBuilder instance,String methodName,boolean condition, String columnName, T columnValue){
        try {
            PredicateBuilderHandler predicateBuilderHandler = new FirstPBHandler(new SecondPBHandler(null));
            return predicateBuilderHandler.handle(instance,methodName,condition, columnName,columnValue );
        } catch (Exception ex) {
            ex.printStackTrace();
            return null;
        }
    }
}
