package com.xgene.article.dto.resp.basemodel;

import lombok.Data;

@Data
public class ReactAntdColumnsModel {
    private String dataIndex;
    private String title;
    private String key;
    private boolean sorter = true;
    private String dataFormat;

    public ReactAntdColumnsModel(String dataField, String title) {
        this.dataIndex = dataField;
        this.title = title;
    }

    public ReactAntdColumnsModel(String dataField, String title, boolean sorter) {
        this.dataIndex = dataField;
        this.title = title;
        this.sorter = sorter;
    }

    public ReactAntdColumnsModel(String dataField, String title, boolean sorter, String dataFormat) {
        this.dataIndex = dataField;
        this.title = title;
        this.sorter = sorter;
        this.dataFormat = dataFormat;
    }

    public ReactAntdColumnsModel(String dataIndex, String title, String key, boolean sorter, String dataFormat) {
        this.dataIndex = dataIndex;
        this.title = title;
        this.key = key;
        this.sorter = sorter;
        this.dataFormat = dataFormat;
    }
}
