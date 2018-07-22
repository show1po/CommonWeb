package com.xgene.article.dto.resp.basemodel;

public enum ReactTableDataFormat {
    NoFormatter(null),LinkFormatter("linkFormatter"),PriceFormatter("priceFormatter"),;
    private String value;
    ReactTableDataFormat(String value){
        this.value = value;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }
}
