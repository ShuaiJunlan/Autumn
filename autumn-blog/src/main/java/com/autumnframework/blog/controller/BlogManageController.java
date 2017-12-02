package com.autumnframework.blog.controller;

import com.autumnframework.blog.dao.mongo.CommonRepository;
import com.autumnframework.blog.model.document.Blog;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Optional;

/**
 * @author Junlan Shuai[shuaijunlan@gmail.com].
 * @date Created on 15:22 2017/11/15.
 */
@Controller
@RequestMapping(value = "blog")
public class BlogManageController {
    private static Logger logger = LoggerFactory.getLogger(BlogManageController.class);
    @Autowired
    private CommonRepository commonRepository;
    @RequestMapping(value = "getBlogById")
    @ResponseBody
    public Blog getBlogById(@RequestParam("id")String id){

        Optional<Blog> blog =  commonRepository.findById(id);
        if (blog.isPresent()){
            return blog.get();
        }else {
            return null;
        }

    }

    @RequestMapping(value = "insertBlog")
    @ResponseBody
    public void insertBlog(@RequestParam("id") String id, @RequestParam("content") String content){
        commonRepository.save(new Blog(id, content));
    }
}
