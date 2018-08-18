package com.xgene.article.po;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.Objects;

@Entity
@Table(name = "importnews", schema = "inside", catalog = "")
public class ImportnewsEntity {
    private int id;
    private String title;
    private Object titleInReact;
    private String category;
    private String summary;
    private String url;
    private String categoryUrl;
    private int likeNumber;
    private int dislikeNumber;
    private int readingNumber;
    private Timestamp createTime;
    private Timestamp updateTime;
    @Transient
    public Object getTitleInReact() {
        return titleInReact;
    }

    @Transient
    public boolean likes = false;
    @Transient
    public boolean dislike = false;

    public boolean isLikes() {
        return likes;
    }

    public void setLikes(boolean likes) {
        this.likes = likes;
    }

    public boolean isDislike() {
        return dislike;
    }

    public void setDislike(boolean dislike) {
        this.dislike = dislike;
    }

    public void setTitleInReact(Object titleInReact) {
        this.titleInReact = titleInReact;
    }

    @Id
    @Column(name = "id", nullable = false)
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Basic
    @Column(name = "title", nullable = false, length = -1)
    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    @Basic
    @Column(name = "category", nullable = true, length = -1)
    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    @Basic
    @Column(name = "summary", nullable = true, length = -1)
    public String getSummary() {
        return summary;
    }

    public void setSummary(String summary) {
        this.summary = summary;
    }

    @Basic
    @Column(name = "url", nullable = false, length = -1)
    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    @Basic
    @Column(name = "category_url", nullable = true, length = -1)
    public String getCategoryUrl() {
        return categoryUrl;
    }

    public void setCategoryUrl(String categoryUrl) {
        this.categoryUrl = categoryUrl;
    }

    @Basic
    @Column(name = "like_number", nullable = false)
    public int getLikeNumber() {
        return likeNumber;
    }

    public void setLikeNumber(int likeNumber) {
        this.likeNumber = likeNumber;
    }

    @Basic
    @Column(name = "dislike_number", nullable = false)
    public int getDislikeNumber() {
        return dislikeNumber;
    }

    public void setDislikeNumber(int dislikeNumber) {
        this.dislikeNumber = dislikeNumber;
    }

    @Basic
    @Column(name = "reading_number", nullable = false)
    public int getReadingNumber() {
        return readingNumber;
    }

    public void setReadingNumber(int readingNumber) {
        this.readingNumber = readingNumber;
    }

    @Basic
    @Column(name = "create_time", nullable = false)
    public Timestamp getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Timestamp createTime) {
        this.createTime = createTime;
    }

    @Basic
    @Column(name = "update_time", nullable = true)
    public Timestamp getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Timestamp updateTime) {
        this.updateTime = updateTime;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ImportnewsEntity that = (ImportnewsEntity) o;
        return id == that.id &&
                likeNumber == that.likeNumber &&
                dislikeNumber == that.dislikeNumber &&
                readingNumber == that.readingNumber &&
                Objects.equals(title, that.title) &&
                Objects.equals(category, that.category) &&
                Objects.equals(summary, that.summary) &&
                Objects.equals(url, that.url) &&
                Objects.equals(categoryUrl, that.categoryUrl) &&
                Objects.equals(createTime, that.createTime) &&
                Objects.equals(updateTime, that.updateTime);
    }

    @Override
    public int hashCode() {

        return Objects.hash(id, title, category, summary, url, categoryUrl, likeNumber, dislikeNumber, readingNumber, createTime, updateTime);
    }
}
