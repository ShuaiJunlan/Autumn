package com.autumnframework.blog.controller;

import com.autumnframework.blog.dao.mongo.BlogRepository;
import com.autumnframework.blog.model.document.BlogDetail;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.Optional;

/**
 * @author Junlan Shuai[shuaijunlan@gmail.com].
 * @date Created on 17:23 2018/4/20.
 */
@Controller
@RequestMapping(value = "article")
public class ArticleController {
    private static final Logger LOGGER = LoggerFactory.getLogger(ArticleController.class);
    private BlogRepository blogRepository;
    public ArticleController(BlogRepository blogRepository){
        this.blogRepository = blogRepository;
    }
    @RequestMapping(value = "{id}", method = RequestMethod.GET)
    public String getBlogDetail(@PathVariable("id") String id, Model model){

        Optional<BlogDetail> blog =  blogRepository.findById(id);

        if (blog.isPresent()){
            // increment visiting times by one
            BlogDetail blogDetail = blog.get();

            long times = blogDetail.getVisit_times();

            times++;
            blogDetail.setVisit_times(times);
            blogRepository.save(blogDetail);
            if (LOGGER.isInfoEnabled()){
                LOGGER.info("Blog detail:{}", blogDetail);
            }
            model.addAttribute("title", blogDetail.getTitle());
            model.addAttribute("username", blogDetail.getUsername());
            model.addAttribute("time", blogDetail.getTime());
            model.addAttribute("visit_times", blogDetail.getVisit_times());
            model.addAttribute("content", blogDetail.getContent_md());
        }
        return "detail";
    }
}
