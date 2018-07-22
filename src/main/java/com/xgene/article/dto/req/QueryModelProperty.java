package com.xgene.article.dto.req;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.TYPE,ElementType.FIELD})
public @interface QueryModelProperty {
    enum Type{
        DEFAULT(Object.class),
        STRING(String.class),
        INTEGER(Integer.class),
        ;
        Class aClass;
        Type(Class aClass){
            this.aClass = aClass;
        }
    }
    Type type() default Type.DEFAULT;
    boolean enable() default true;

    String columnName() default "";

    ComparisonOperator operator() default ComparisonOperator.NO;
}
