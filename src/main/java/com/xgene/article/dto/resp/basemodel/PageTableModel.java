package com.xgene.article.dto.resp.basemodel;

import com.google.common.collect.Lists;
import org.apache.commons.lang3.StringUtils;

import java.lang.reflect.Field;
import java.util.List;

public class PageTableModel<E>{
    private List<ColumnsModel> columns= Lists.newArrayList();
    private List<ReactAntdColumnsModel> antdColumns= Lists.newArrayList();
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
                String dataFormat=reactPageableColumn.dataFormat()==null?null:reactPageableColumn.dataFormat().getValue();
                columns.add(new ColumnsModel(dataField, text, sort,dataFormat));
            }
            ReactAntdPageableColumn reactAntdPageableColumn = field.getAnnotation(ReactAntdPageableColumn.class);
            if (reactAntdPageableColumn != null) {
                String dataFormat = reactAntdPageableColumn.dataFormat() == null ? null : reactAntdPageableColumn.dataFormat().getValue();
                String key = StringUtils.isNotEmpty(reactAntdPageableColumn.key()) ? reactAntdPageableColumn.key() : field.getName();
                String dataIndex = StringUtils.isNotEmpty(reactAntdPageableColumn.dataIndex()) ? reactAntdPageableColumn.dataIndex() : field.getName();
                String title = StringUtils.isNotEmpty(reactAntdPageableColumn.title()) ? reactAntdPageableColumn.title() : field.getName();
                boolean sorter = reactAntdPageableColumn.sorter();
                antdColumns.add(new ReactAntdColumnsModel(dataIndex,title,key,sorter,dataFormat));

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

    public List<ReactAntdColumnsModel> getAntdColumns() {
        return antdColumns;
    }

    public void setAntdColumns(List<ReactAntdColumnsModel> antdColumns) {
        this.antdColumns = antdColumns;
    }
}
