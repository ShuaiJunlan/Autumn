package com.autumnframework.blog.controller;

import com.autumnframework.blog.dao.mongo.CommonRepository;
import com.autumnframework.blog.model.document.Blog;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
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
    private static Logger logger = LogManager.getLogger(BlogManageController.class);
    @Autowired
    private CommonRepository commonRepository;
    @RequestMapping(value = "getBlogById")
    @ResponseBody
    public Blog getBlogById(@RequestParam("id")String id){

        logger.info(id);
        Optional<Blog> blog =  commonRepository.findById(id);
        logger.info(blog);
        return blog.get();
    }

    @RequestMapping(value = "insertBlog")
    @ResponseBody
    public void insertBlog(@RequestParam("id") String id, @RequestParam("content") String content){
        commonRepository.save(new Blog(id, content));
    }
}
