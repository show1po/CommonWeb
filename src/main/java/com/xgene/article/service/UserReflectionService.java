package com.xgene.article.service;

import com.github.wenhao.jpa.Specifications;
import com.google.common.base.Preconditions;
import com.sun.istack.internal.logging.Logger;
import com.xgene.article.dto.req.AddUserReflectionReq;
import com.xgene.article.dto.resp.UserReflectionViewModel;
import com.xgene.article.persistence.ImportnewsRepository;
import com.xgene.article.persistence.UserReflectionRepository;
import com.xgene.article.po.ImportnewsEntity;
import com.xgene.article.po.UserReflectionEntity;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Component;

import java.sql.Timestamp;
import java.util.Date;
import java.util.List;
import java.util.Optional;
import java.util.concurrent.atomic.AtomicInteger;

@Component
public class UserReflectionService {
    final static Logger logger = Logger.getLogger(UserReflectionService.class);
    @Autowired
    private UserReflectionRepository userReflectionRepository;

    @Autowired
    private ImportnewsRepository importnewsRepository;

    public void save(AddUserReflectionReq addUserReflectionReq) {
        Specification<ImportnewsEntity> specification = Specifications.<ImportnewsEntity>and()
                .eq("id", addUserReflectionReq.getImportnewsId())
                .eq("title", addUserReflectionReq.getImportnewsTitle())
                .build();
        Preconditions.checkArgument(importnewsRepository.findOne(specification).isPresent(), "該篇文章不存在。");
        //user 暫時統一交由alvis處理

        Specification<UserReflectionEntity> build = Specifications.<UserReflectionEntity>and()
                .eq("importnewsId", Integer.valueOf(addUserReflectionReq.getImportnewsId()))
                .eq("importnewsTitle", addUserReflectionReq.getImportnewsTitle())
                .eq("userId", (addUserReflectionReq.getUserId() == null ? 0 : addUserReflectionReq.getUserId()))
                .build();
        Optional<UserReflectionEntity> one = userReflectionRepository.findOne(build);
        UserReflectionEntity target;
        if (!one.isPresent()) {
            // insert
            target = new UserReflectionEntity();
            BeanUtils.copyProperties(addUserReflectionReq, target);
            target.setUserId(addUserReflectionReq.getUserId()==null? 0:addUserReflectionReq.getUserId());
            target.setUserName(addUserReflectionReq.getUserName()==null?"Admin":addUserReflectionReq.getUserName());
            target.setReading(1);
            target.setCreateTime(new Timestamp(new Date().getTime()));
        } else {
            // update
            target = one.get();
            target.setUpdateTime(new Timestamp(new Date().getTime()));
            BeanUtils.copyProperties(addUserReflectionReq, target);
            if (addUserReflectionReq.getUserId() == null) {
                target.setUserId(0);
            }
            target.setUserName(addUserReflectionReq.getUserName()==null?"Admin":addUserReflectionReq.getUserName());
        }
        UserReflectionEntity save = userReflectionRepository.save(target);
        Preconditions.checkArgument(save != null, "用戶行為儲存失敗。");

    }

    public UserReflectionViewModel findUserReflectionViewModel(AddUserReflectionReq addUserReflectionReq) {
        Specification<ImportnewsEntity> specification = Specifications.<ImportnewsEntity>and()
                .eq("id", addUserReflectionReq.getImportnewsId())
                .eq("title", addUserReflectionReq.getImportnewsTitle())
                .build();
        Optional<ImportnewsEntity> one = importnewsRepository.findOne(specification);
        Preconditions.checkArgument(one.isPresent(), "該篇文章不存在。");
        Specification<UserReflectionEntity> build = Specifications.<UserReflectionEntity>and()
                .eq("importnewsId", addUserReflectionReq.getImportnewsId())
                .eq("importnewsTitle", addUserReflectionReq.getImportnewsTitle())
                .build();
        List<UserReflectionEntity> all = userReflectionRepository.findAll(build);
        AtomicInteger likecount = new AtomicInteger(0);
        AtomicInteger dislikecount = new AtomicInteger(0);
        AtomicInteger readingcount = new AtomicInteger(0);
        all.stream().forEach((UserReflectionEntity userReflectionEntity) -> {
            if (userReflectionEntity.getLikes()) {
                likecount.incrementAndGet();
            }
            if (userReflectionEntity.getDislike()) {
                dislikecount.incrementAndGet();
            }
            readingcount.addAndGet(userReflectionEntity.getReading());
        });
        one.get().setLikeNumber(likecount.get());
        one.get().setDislikeNumber(dislikecount.get());
        one.get().setReadingNumber(readingcount.get());
        one.get().setUpdateTime(new Timestamp(new Date().getTime()));
        ImportnewsEntity save = importnewsRepository.save(one.get());
        return new UserReflectionViewModel(one.get().getId(), save.getLikeNumber(), save.getDislikeNumber(), save.getReadingNumber());

    }
}
