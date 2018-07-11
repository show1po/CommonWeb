package com.xgene.article.dto.resp.basemodel;

import com.google.common.collect.Lists;
import org.apache.commons.lang3.StringUtils;

import java.lang.reflect.Field;
import java.util.List;

public class PageTableModel<E>{
    private List<ColumnsModel> columns= Lists.newArrayList();
    private List<E> products;

    public PageTableModel(List<E> products,Class<?> aClass) {
        this.products = products;
        try {
            initCoulumns(aClass);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    private void initCoulumns(Class<?> tClass) throws Exception{
        for (Field field :tClass .getDeclaredFields()) {
            ReactPageableColumn reactPageableColumn = field.getAnnotation(ReactPageableColumn.class);
            if (reactPageableColumn != null) {
                boolean sort = reactPageableColumn.sort();
                String dataField = StringUtils.isNotEmpty(reactPageableColumn.dataField()) ? reactPageableColumn.dataField() : field.getName();
                String text = StringUtils.isNotEmpty(reactPageableColumn.text()) ? reactPageableColumn.text(): field.getName();
                columns.add(new ColumnsModel(dataField, text, sort));
            }
        }
    }

    public List<ColumnsModel> getColumns() {
        return columns;
    }

    public void setColumns(List<ColumnsModel> columns) {
        this.columns = columns;
    }

    public List<E> getProducts() {
        return products;
    }

    public void setProducts(List<E> products) {
        this.products = products;
    }
}
