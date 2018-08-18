package com.xgene.article.dto.resp.basemodel;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.FIELD)
public @interface ReactAntdPageableColumn {
    String key() default "";
    String dataIndex() default "";
    String title() default "";
    boolean sorter() default true;
    ReactTableDataFormat dataFormat() default ReactTableDataFormat.NoFormatter;
}
