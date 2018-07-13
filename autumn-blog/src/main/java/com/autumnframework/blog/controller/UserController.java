package com.autumnframework.blog.controller;

import com.autumnframework.blog.dao.mongo.BlogRepository;
import com.autumnframework.blog.model.document.BlogDetail;
import com.autumnframework.common.architect.constant.ResponseCode;
import com.autumnframework.common.architect.utils.ResponseMsgUtil;
import com.autumnframework.common.model.bo.DataPageResponseMsg;
import org.springframework.data.domain.Sort;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

/**
 * @author Junlan Shuai[shuaijunlan@gmail.com].
 * @date Created on 17:09 2018/4/15.
 */
@Controller
@ResponseBody
public class UserController {
    private BlogRepository blogRepository;
    private MongoTemplate mongoTemplate;
    public UserController(BlogRepository blogRepository, MongoTemplate mongoTemplate){
        this.blogRepository = blogRepository;
        this.mongoTemplate = mongoTemplate;
    }
    @RequestMapping(value = "user/{user_name}")
    public DataPageResponseMsg getUserArticle(@PathVariable("user_name") String username){
        //按访问次数降序查询
        Query query = new Query();
        query.addCriteria(new Criteria("username").is(username));
        List<BlogDetail> list = mongoTemplate.find(query, BlogDetail.class);
        int count = list.size();
        return ResponseMsgUtil.returnCodeMessage(ResponseCode.REQUEST_SUCCESS, list, count);
    }
}
