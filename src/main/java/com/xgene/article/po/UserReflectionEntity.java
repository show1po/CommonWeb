package com.xgene.article.po;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.Objects;

@Entity
@Table(name = "user_reflection", schema = "inside", catalog = "")
public class UserReflectionEntity {
    private Integer id;
    private Integer userId;
    private String userName;
    private Integer importnewsId;
    private String importnewsTitle;
    private boolean likes;
    private boolean dislike;
    private Timestamp createTime;
    private Timestamp updateTime;
    private Integer reading;

    @Basic
    @Id
    @Column(name = "id", nullable = false)
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    @Basic
    @Column(name = "user_id", nullable = false)
    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    @Basic
    @Column(name = "user_name", nullable = false)
    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    @Basic
    @Column(name = "importnews_id", nullable = false)
    public Integer getImportnewsId() {
        return importnewsId;
    }

    public void setImportnewsId(Integer importnewsId) {
        this.importnewsId = importnewsId;
    }

    @Basic
    @Column(name = "importnews_title", nullable = false)
    public String getImportnewsTitle() {
        return importnewsTitle;
    }

    public void setImportnewsTitle(String importnewsTitle) {
        this.importnewsTitle = importnewsTitle;
    }

    @Basic
    @Column(name = "likes", nullable = false)
    public boolean getLikes() {
        return likes;
    }

    public void setLikes(boolean likes) {
        this.likes = likes;
    }

    @Basic
    @Column(name = "dislike", nullable = false)
    public boolean getDislike() {
        return dislike;
    }

    public void setDislike(boolean dislike) {
        this.dislike = dislike;
    }

    @Basic
    @Column(name = "create_time", nullable = true)
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
        UserReflectionEntity that = (UserReflectionEntity) o;
        return id == that.id &&
                userId == that.userId &&
                importnewsId == that.importnewsId &&
                likes == that.likes &&
                dislike == that.dislike &&
                Objects.equals(userName, that.userName) &&
                Objects.equals(importnewsTitle, that.importnewsTitle) &&
                Objects.equals(createTime, that.createTime) &&
                Objects.equals(updateTime, that.updateTime);
    }

    @Override
    public int hashCode() {

        return Objects.hash(id, userId, userName, importnewsId, importnewsTitle, likes, dislike, createTime, updateTime);
    }

    @Basic
    @Column(name = "reading", nullable = false)
    public Integer getReading() {
        return reading;
    }

    public void setReading(Integer reading) {
        this.reading = reading;
    }
}
