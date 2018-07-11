package com.xgene.article.facade;

import com.xgene.article.excel.ImportNewsModel;
import com.xgene.article.po.ImportnewsEntity;
import com.xgene.article.common.exception.SystemException;
import com.xgene.article.service.TopicService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

/**
 * 寫入數據庫的工具：將透過python 抓取資料存成excel的資料，撈取後轉寫入 #mysql inside.importnews 表格中。
 */
@Component
public class TransferFacade {
    @Autowired
    private TopicService topicService;

    public String execute() throws SystemException {
        try {
            List<ImportNewsModel> products = topicService.load().getProducts();
            List<ImportnewsEntity> collect = products.parallelStream()
                    .filter(importNewsModel -> !topicService.exist(importNewsModel.getTitle()))
                    .map(importNewsModel -> {
                        ImportnewsEntity importnewsEntity = new ImportnewsEntity();
                        importnewsEntity.setCategory(importNewsModel.getCategory());
                        importnewsEntity.setCategoryUrl(importNewsModel.getCategoryUrl());
                        importnewsEntity.setDislikeNumber(0);
                        importnewsEntity.setLikeNumber(0);
                        importnewsEntity.setReadingNumber(0);
                        importnewsEntity.setSummary(importNewsModel.getSummary());
                        importnewsEntity.setTitle(importNewsModel.getTitle());
                        importnewsEntity.setUrl(importNewsModel.getUrl());
                        return importnewsEntity;
                    }).collect(Collectors.toList());
            String log = topicService.save(collect);
            return log;
        } catch (Exception ex) {
            ex.printStackTrace();
            throw new SystemException(ex.getMessage());
        }
    }


}
