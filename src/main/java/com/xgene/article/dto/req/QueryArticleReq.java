package com.xgene.article.dto.req;
@QueryModel
public class QueryArticleReq {

    private Integer id;
    @QueryModelProperty(operator = ComparisonOperator.like)
    private String title;
    @QueryModelProperty(operator = ComparisonOperator.like)
    private String category;
    private String summary;
    @QueryModelProperty(type = QueryModelProperty.Type.INTEGER,operator = ComparisonOperator.gt)
    private Integer likeNumber;
    @QueryModelProperty(type = QueryModelProperty.Type.INTEGER,operator = ComparisonOperator.gt)
    private Integer dislikeNumber;
    @QueryModelProperty(operator = ComparisonOperator.gt)
    private Integer readingNumber;
    private String url;
    private String categoryUrl;
    private Integer userId;

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
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

    public Integer getLikeNumber() {
        return likeNumber;
    }

    public void setLikeNumber(Integer likeNumber) {
        this.likeNumber = likeNumber;
    }

    public Integer getDislikeNumber() {
        return dislikeNumber;
    }

    public void setDislikeNumber(Integer dislikeNumber) {
        this.dislikeNumber = dislikeNumber;
    }

    public Integer getReadingNumber() {
        return readingNumber;
    }

    public void setReadingNumber(Integer readingNumber) {
        this.readingNumber = readingNumber;
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
