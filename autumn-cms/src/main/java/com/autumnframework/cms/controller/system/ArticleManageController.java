package com.autumnframework.cms.controller.system;

import com.autumnframework.cms.dao.mongo.BlogRepository;
import com.autumnframework.common.architect.constant.ResponseCode;
import com.autumnframework.common.architect.utils.ResponseMsgUtil;
import com.autumnframework.common.model.bo.DataPageResponseMsg;
import com.autumnframework.common.model.bo.ResponseMsg;
import com.autumnframework.common.model.po.ArticleInfo;
import com.autumnframework.common.model.po.BlogDetail;
import com.autumnframework.common.service.impl.ArticleServiceImpl;
import com.autumnframework.common.service.interfaces.IArticleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

/**
 * @author Junlan Shuai[shuaijunlan@gmail.com].
 * @date Created on 10:52 2017/12/4.
 */
@Controller
@RequestMapping(value = "manage/article")
public class ArticleManageController {
    private BlogRepository blogRepository;
    private IArticleService iArticleService;

    public ArticleManageController(BlogRepository blogRepository, ArticleServiceImpl articleService){
        this.blogRepository = blogRepository;
        this.iArticleService = articleService;
    }

    @RequestMapping(value = "list/")
    @ResponseBody
    public DataPageResponseMsg getArticleList(){
        List<ArticleInfo> list = iArticleService.getArticleList();
        int count = list.size();
        return ResponseMsgUtil.returnCodeMessage(ResponseCode.REQUEST_SUCCESS, list, count);
    }
}
