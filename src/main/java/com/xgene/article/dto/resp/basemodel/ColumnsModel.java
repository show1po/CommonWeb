package com.xgene.article.dto.resp.basemodel;

import lombok.Data;

@Data
public class ColumnsModel {
    private String dataField;
    private String text;
    private boolean sort= true;

    public ColumnsModel(String dataField, String text) {
        this.dataField = dataField;
        this.text = text;
    }

    public ColumnsModel(String dataField, String text, boolean sort) {
        this.dataField = dataField;
        this.text = text;
        this.sort = sort;
    }
}
