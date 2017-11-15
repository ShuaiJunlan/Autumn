package com.autumnframework.blog.controller;

import com.autumnframework.blog.dao.mongo.CommonRepository;
import com.autumnframework.blog.model.document.Blog;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @author Junlan Shuai[shuaijunlan@gmail.com].
 * @date Created on 15:22 2017/11/15.
 */
@Controller
@RequestMapping(value = "blog")
public class BlogManageController {
    @Autowired
    private CommonRepository commonRepository;
    @RequestMapping(value = "getBlogById")
    @ResponseBody
    public void getBlogById(String content){
        commonRepository.insert(new Blog("1", content));
    }

    @RequestMapping(value = "insertBlog")
    @ResponseBody
    public void insertBlog(@RequestParam("content") String content){
        commonRepository.insert(new Blog("1", content));
    }
}
