package com.autumnframework.common.service.impl;

import com.autumnframework.common.dao.bomapper.ArticleInfoMapper;
import com.autumnframework.common.model.po.ArticleInfo;
import com.autumnframework.common.service.interfaces.IArticleService;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author Junlan Shuai[shuaijunlan@gmail.com].
 * @date Created on 18:42 2018/4/20.
 */
@Service
public class ArticleServiceImpl implements IArticleService {
    @Autowired
    private ArticleInfoMapper articleInfoMapper;

    @Override
    public List<ArticleInfo> getArticleList() {
        return articleInfoMapper.getArticleList();
    }

    @Override
    public int insrt(ArticleInfo articleInfo) {
        return articleInfoMapper.insert(articleInfo);
    }

    @Override
    public int updateVisitTimes(Integer visitTimes, String visitId) {
        return articleInfoMapper.updateVisitTimes(visitTimes, visitId);
    }

    @Override
    public List<ArticleInfo> getArticleByVisitId(String visitId) {
        return articleInfoMapper.getArticleByVisitId(visitId);
    }


}
