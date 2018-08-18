package com.xgene.article.persistence;

import com.xgene.article.po.UserReflectionEntity;
import io.swagger.models.auth.In;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;

/**
 * Created by albert on 2017/10/21.
 */
public interface UserReflectionRepository extends CrudRepository<UserReflectionEntity, Integer>,JpaSpecificationExecutor<UserReflectionEntity> {
    @Query(value = "select id from  UserReflectionEntity where name=:name")
    Integer findIdByName(@Param("name") String name);

    //    @Query(value = "select max(orderNum)  as maxOrderNum  from  UserReflectionEntity")
//    Integer findMaxOrderNum();
    List<UserReflectionEntity> findAllByUserId(Integer userId);
}
