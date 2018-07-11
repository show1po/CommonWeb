package com.xgene.article.excel;

import com.lkx.util.ExcelUtil;
import com.xgene.article.common.exception.ErrorStatusCode;
import com.xgene.article.common.exception.SystemException;

import java.util.ArrayList;
import java.util.List;

public class ImportNews {

    private static String importNewsKeyValue = "summary:summary,category_url:categoryUrl,title:title,category:category,url:url";
//    private static String importNewsKeyValue = "title:title,category:category,summary:summary,url:url,category_url:categoryUrl";
    private static String filePath = "/Users/albert/Documents/CommonService/src/main/resources/templates/importnewsData.xls";

    public static List<ImportNewsModel> list() throws SystemException{
        List<ImportNewsModel> list=new ArrayList<>();
        try {
            list = ExcelUtil.readXls(filePath, ExcelUtil.getMap(importNewsKeyValue), "com.xgene.article.excel.ImportNewsModel");
        } catch (Exception e) {
            e.printStackTrace();
            throw new SystemException(ErrorStatusCode.SYSTEM_EXCEL_ERROR, e.getMessage());
        }
        return list;
    }

}
