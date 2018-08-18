package com.xgene.article.controller;

import com.xgene.article.dto.req.AddUserReflectionReq;
import com.xgene.article.dto.resp.UserReflectionViewModel;
import com.xgene.article.service.UserReflectionService;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@Api(value = "UserReflection服務")
@RestController
@RequestMapping(value = "/userReflection")
public class UserReflectionController extends XgeneResponse{
    @Autowired
    private UserReflectionService userReflectionService;

    @RequestMapping(value = "/merge",method = RequestMethod.POST)
    private String merge(@RequestBody AddUserReflectionReq addUserReflectionReq) {
        // 按讚/按噓/閱讀數量，儲存到個人行為。
        userReflectionService.save(addUserReflectionReq);
        // 所有的個人行為數據經過統計後，儲存到文章總計。
        UserReflectionViewModel userReflectionViewModel = userReflectionService.findUserReflectionViewModel(addUserReflectionReq);
        // 回傳該文章所有最新統計數據。
        return success(userReflectionViewModel);
    }
}

