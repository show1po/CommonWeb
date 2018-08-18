package com.xgene.article.dto.req;

import lombok.Data;
@Data
public class AddUserReflectionReq {
    private boolean likes;
    private boolean dislike;
    private Integer userId;
    private String userName;
    private String importnewsTitle;
    private Integer importnewsId;
}
