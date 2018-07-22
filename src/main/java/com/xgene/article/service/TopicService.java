package com.xgene.article.service;

import com.sun.istack.internal.logging.Logger;
import com.xgene.article.dto.req.QueryArticleReq;
import com.xgene.article.dto.resp.basemodel.PageTableModel;
import com.xgene.article.excel.ImportNews;
import com.xgene.article.excel.ImportNewsModel;
import com.xgene.article.po.ImportnewsEntity;
import com.xgene.article.persistence.ImportnewsRepository;
import com.xgene.article.util.QueryConditionGenerator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Component;

import javax.persistence.EntityExistsException;
import java.util.List;

@Component
public class TopicService {
    final static Logger logger = Logger.getLogger(TopicService.class);
    @Autowired
    private ImportnewsRepository importnewsRepository;

    public PageTableModel<ImportNewsModel>  load(){
        List<ImportNewsModel> datas = ImportNews.list();
        PageTableModel<ImportNewsModel> listPageTableModel = new PageTableModel(datas,ImportNewsModel.class);
//        PageTableModel<ImportNewsModel> result =  PageTableModel.create(findByPageable());
        return listPageTableModel;
    }

    public PageTableModel<ImportNewsModel> query(QueryArticleReq queryArticleReq) throws Exception {
        List<ImportnewsEntity> datas = importnewsRepository.findAll(QueryConditionGenerator.<QueryArticleReq, ImportnewsEntity>create(queryArticleReq));
        datas.parallelStream().forEach(data->{
            data.setCategory(String.format("<a href=\"%s\">%s</a>",data.getCategoryUrl(),data.getCategory()));
            data.setTitleInReact(String.format("<a href=\"%s\">%s</a>",data.getUrl(),data.getTitle()));
        });
        PageTableModel<ImportNewsModel> listPageTableModel = new PageTableModel(datas,ImportNewsModel.class);
        return listPageTableModel;
    }

//    public List<ImportNewsModel> findByPageable() {
//        return new ArrayList<>(datas.subList(0, 10));
//    }

    public boolean exist(String title) {
        return importnewsRepository.existsByTitle(title);
    }

    public String save(List<ImportnewsEntity> importnewsEntities) {
        int total = importnewsEntities.size();
        int exist = 0;
        int exception = 0;
        int success = 0;
        for (ImportnewsEntity importnewsEntity : importnewsEntities) {
            try {
                importnewsRepository.save(importnewsEntity);
            } catch (EntityExistsException entityExistsException) {
                ++exist;
            }  catch (DataIntegrityViolationException div) {
                ++exist;
            } catch (Exception ex) {
                ++exception;
                ex.printStackTrace();
            }
        }
        success = total - exist - exception;
        String log = String.format("{total=%d, existEntity=%d, otherException=%d, success=%d}", total, exist, exception, success);
        return log;
    }
}
