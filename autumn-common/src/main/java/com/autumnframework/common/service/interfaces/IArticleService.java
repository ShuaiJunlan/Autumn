package com.autumnframework.common.service.interfaces;

import com.autumnframework.common.model.po.ArticleInfo;

import java.util.List;

/**
 * @author Junlan Shuai[shuaijunlan@gmail.com].
 * @date Created on 18:42 2018/4/20.
 */
public interface IArticleService {
    /**
     * 获取文章列表
     * @return
     */
    List<ArticleInfo> getArticleList();

    int insrt(ArticleInfo articleInfo);

    int updateVisitTimes(Integer visitTimes, String visitId);

    List<ArticleInfo> getArticleByVisitId(String visitId);
}
