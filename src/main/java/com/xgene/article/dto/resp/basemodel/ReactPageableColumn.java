package com.xgene.article.dto.resp.basemodel;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.FIELD)
public @interface ReactPageableColumn {
    public String dataField() default "";
    public String text() default "";
    public boolean sort() default true;

}
