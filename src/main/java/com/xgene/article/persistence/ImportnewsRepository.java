package com.xgene.article.persistence;

import com.xgene.article.po.ImportnewsEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

/**
 * Created by albert on 2017/10/21.
 */
@RepositoryRestResource(collectionResourceRel = "importnews", path = "importnews")
public interface ImportnewsRepository extends CrudRepository<ImportnewsEntity, Integer> {
    boolean existsByTitle(String title);
}
