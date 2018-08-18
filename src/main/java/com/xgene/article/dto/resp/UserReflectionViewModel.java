package com.xgene.article.dto.resp;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserReflectionViewModel {
    private int importnewsId;
    private int like;
    private int dislike;
    private int reading;
}
