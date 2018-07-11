package com.xgene.article.excel;

import com.xgene.article.dto.resp.basemodel.ReactPageableColumn;

//@Data
public class ImportNewsModel {
    @ReactPageableColumn(text = "ID")
    private String id;
    @ReactPageableColumn(text = "標題")
    private String title;
    @ReactPageableColumn(text = "分類")
    private String category;
    @ReactPageableColumn(text = "摘要")
    private String summary;
    @ReactPageableColumn(text = "來源")
    private String url;
    @ReactPageableColumn(text = "分類來源")
    private String categoryUrl;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getSummary() {
        return summary;
    }

    public void setSummary(String summary) {
        this.summary = summary;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getCategoryUrl() {
        return categoryUrl;
    }

    public void setCategoryUrl(String categoryUrl) {
        this.categoryUrl = categoryUrl;
    }
}
