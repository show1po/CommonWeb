package com.xgene.article.excel;

import com.xgene.article.dto.resp.basemodel.ReactPageableColumn;
import com.xgene.article.dto.resp.basemodel.ReactTableDataFormat;

//@Data
public class ImportNewsModel {
    @ReactPageableColumn(text = "ID")
    private String id;
//    @ReactPageableColumn(text = "標題",dataFormat = ReactTableDataFormat.LinkFormatter)
    private String title;
    @ReactPageableColumn(text = "標題",dataFormat = ReactTableDataFormat.LinkFormatter)
    private String titleInReact;
    @ReactPageableColumn(text = "分類")
    private String category;
    @ReactPageableColumn(text = "摘要")
    private String summary;
//    @ReactPageableColumn(text = "來源")
    private String url;
//    @ReactPageableColumn(text = "分類來源")
    private String categoryUrl;
    @ReactPageableColumn(text = "讚數",dataFormat = ReactTableDataFormat.PriceFormatter)
    private int likeNumber;
    @ReactPageableColumn(text = "噓數")
    private int dislikeNumber;
    @ReactPageableColumn(text = "閱讀數")
    private int readingNumber;

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

    public int getLikeNumber() {
        return likeNumber;
    }

    public void setLikeNumber(int likeNumber) {
        this.likeNumber = likeNumber;
    }

    public int getDislikeNumber() {
        return dislikeNumber;
    }

    public void setDislikeNumber(int dislikeNumber) {
        this.dislikeNumber = dislikeNumber;
    }

    public int getReadingNumber() {
        return readingNumber;
    }

    public void setReadingNumber(int readingNumber) {
        this.readingNumber = readingNumber;
    }

    public String getTitleInReact() {
        return titleInReact;
    }

    public void setTitleInReact(String titleInReact) {
        this.titleInReact = titleInReact;
    }
}
