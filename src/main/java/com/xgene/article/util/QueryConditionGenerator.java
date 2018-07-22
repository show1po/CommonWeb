package com.xgene.article.util;

import com.github.wenhao.jpa.PredicateBuilder;
import com.github.wenhao.jpa.Specifications;
import com.xgene.article.dto.req.ComparisonOperator;
import com.xgene.article.dto.req.QueryModelProperty;
import com.xgene.article.dto.req.jpautils.PredicateBuilderMethodChain;
import org.apache.commons.lang3.StringUtils;
import org.springframework.data.jpa.domain.Specification;

import java.lang.reflect.Field;
import java.lang.reflect.Type;

public class QueryConditionGenerator {
    //    final static Logger logger = Logger.getLogger(QueryGenerato.class);
    public static <T, E> Specification<E> create(T queryModel) throws Exception {
        PredicateBuilder<E> builder = Specifications.<E>and();
        for (Field field : queryModel.getClass().getDeclaredFields()) {
            QueryModelProperty queryModelPropertyAnnotation = field.getAnnotation(QueryModelProperty.class);
            if (queryModelPropertyAnnotation != null) {
                if (queryModelPropertyAnnotation.enable()) {
                    QueryModelProperty.Type type = queryModelPropertyAnnotation.type();
                    if (type == QueryModelProperty.Type.DEFAULT) {
                        Type genericType = field.getGenericType();
                        if (genericType.getTypeName().equals("java.lang.String")) {
                            type = QueryModelProperty.Type.STRING;
                        } else if (genericType.getTypeName().equalsIgnoreCase("java.lang.Integer")) {
                            type = QueryModelProperty.Type.INTEGER;
                        }
                    }
                    field.setAccessible(true);
                    switch (type) {
                        case STRING: {
                            String value = field.get(queryModel).toString();
                            String columnName = queryModelPropertyAnnotation.columnName().equals("") ? field.getName() : queryModelPropertyAnnotation.columnName();
                            if (queryModelPropertyAnnotation.operator() == ComparisonOperator.like) {
                                builder.like(StringUtils.isNotEmpty(value), columnName, value);
                            } else if (queryModelPropertyAnnotation.operator() == ComparisonOperator.eq) {
                                builder.eq(StringUtils.isNotEmpty(value), columnName, value);
                            } else if (queryModelPropertyAnnotation.operator() == ComparisonOperator.notLike) {
                                builder.notLike(StringUtils.isNotEmpty(value), columnName, value);
                            } else if (queryModelPropertyAnnotation.operator() == ComparisonOperator.ne) {
                                builder.ne(StringUtils.isNotEmpty(value), columnName, value);
                            } else {
//                                logger.warn(queryModelPropertyAnnotation.type()+" :: comparison operator is default.");
                            }
                        }
                        break;
                        case INTEGER: {
                            Integer value=null;
//                            try {
                                value =(Integer) field.get(queryModel);
//                            } catch (Exception e) {
//                                e.printStackTrace();
//                                continue;
//                            }
                            String columnName = queryModelPropertyAnnotation.columnName().equals("") ? field.getName() : queryModelPropertyAnnotation.columnName();
//                            Method method = builder.getClass().getMethod(queryModelPropertyAnnotation.operator().name(),boolean.class,String.class, Object.class);
                              builder =PredicateBuilderMethodChain.execute(builder,queryModelPropertyAnnotation.operator().name(),value!=null,columnName , value);
//                            Method method = PredicateBuilderMethodChain.execute(queryModelPropertyAnnotation.operator().name(),columnName , value);
//                            builder = ((PredicateBuilder<E>) method.invoke(builder, null != value, columnName, new Object[]{value}));
//                            if (queryModelPropertyAnnotation.operator() == ComparisonOperator.ge) {
//                                builder.ge(null!=value, columnName, value);
//                            } else if (queryModelPropertyAnnotation.operator() == ComparisonOperator.gt) {
//                                builder.gt(null!=value, columnName, value);
//                            } else if (queryModelPropertyAnnotation.operator() == ComparisonOperator.le) {
//                                builder.le(null!=value, columnName, value);
//                            } else if (queryModelPropertyAnnotation.operator() == ComparisonOperator.lt) {
//                                builder.lt(null!=value, columnName, value);
//                            } else if (queryModelPropertyAnnotation.operator() == ComparisonOperator.eq) {
//                                builder.eq(null!=value, columnName, value);
//                            } else if (queryModelPropertyAnnotation.operator() == ComparisonOperator.ne) {
//                                builder.ne(null!=value, columnName, value);
//                            } else {
////                                logger.warn(queryModelPropertyAnnotation.type()+" :: comparison operator is default.");
//                            }
                        }
                        break;

                    }
                } else {
                }
            } else {
//                logger.info("Query model::true.");
            }
        }
        return builder.build();
    }
}
