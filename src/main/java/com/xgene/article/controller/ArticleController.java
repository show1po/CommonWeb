package com.xgene.article.controller;

import com.xgene.article.dto.req.QueryArticleReq;
import com.xgene.article.service.TopicService;
import com.xgene.article.facade.TransferFacade;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
@RestController
@RequestMapping(value = "/article")
public class ArticleController extends XgeneResponse {

    @Autowired
    private TopicService topicService;

    @Autowired
    private TransferFacade transferFacade;


    @RequestMapping(value = "/find",method = {RequestMethod.POST})
    public String findArticles(@RequestBody QueryArticleReq queryArticleReq)throws Exception{
        return success(topicService.query(queryArticleReq));
    }
    @RequestMapping(value = "/create",method = RequestMethod.GET)
    public String createArticle(){
        return success(transferFacade.execute());
    }
}
