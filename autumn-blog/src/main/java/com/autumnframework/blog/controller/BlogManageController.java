package com.autumnframework.blog.controller;

import com.autumnframework.blog.dao.mongo.BlogRepository;
import com.autumnframework.blog.dao.mongo.CommonRepository;
import com.autumnframework.blog.model.document.Blog;
import com.autumnframework.blog.model.document.BlogDetail;
import com.autumnframework.blog.service.impl.BlogManageImpl;
import com.autumnframework.common.model.bo.ResponseMsg;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

/**
 * @author Junlan Shuai[shuaijunlan@gmail.com].
 * @date Created on 15:22 2017/11/15.
 */
@Controller
@RequestMapping(value = "blog")
public class BlogManageController {
    private static final Logger logger = LoggerFactory.getLogger(BlogManageController.class);
    @Autowired
    private BlogRepository blogRepository;

    @Autowired
    private BlogManageImpl blogManage;

    @RequestMapping(value = "getBlogById/{id}")
    @ResponseBody
    public BlogDetail getBlogById(@PathVariable("id") String id){

        Optional<BlogDetail> blog =  blogRepository.findById(id);
        if (blog.isPresent()){
            return blog.get();
        }else {
            return null;
        }
    }

    @RequestMapping(value = "insertBlog/")
    @ResponseBody
    public ResponseMsg insertBlog(@RequestBody BlogDetail blogDetail){
        return blogManage.shareBlog(blogDetail);
    }

    @RequestMapping(value = "shareBlog/")
    @ResponseBody
    public ResponseMsg shareBlog(BlogDetail blogDetail){

        return blogManage.shareBlog(blogDetail);
    }

    @RequestMapping(value = "getBlogByIdD/{id}", method = RequestMethod.GET)
    public String getBlogDetail(@PathVariable("id") String id, Model model){

        Optional<BlogDetail> blog =  blogRepository.findById(id);

        if (blog.isPresent()){
            // increment visiting times by one
            BlogDetail blogDetail = blog.get();

//            BlogDetail blogDetailCp = new BlogDetail(blogDetail.getId(),
//                    blogDetail.getUsername(),
//                    blogDetail.getTime(),
//                    blogDetail.getTitle(),
//                    blogDetail.getContent_md(),
//                    blogDetail.getContent_html(),
//                    blogDetail.getByte_count(),
//                    blogDetail.getVisit_times(),
//                    blogDetail.getComment_times(),
//                    blogDetail.getState());
            long times = blogDetail.getVisit_times();

            times++;
            blogDetail.setVisit_times(times);
            blogRepository.save(blogDetail);
            logger.info("Blog detail:{}", blogDetail);

            model.addAttribute("title", blogDetail.getTitle());
            model.addAttribute("username", blogDetail.getUsername());
            model.addAttribute("time", blogDetail.getTime());
            model.addAttribute("visit_times", blogDetail.getVisit_times());
            model.addAttribute("content", blogDetail.getContent_md());
        }else {
            return "detail";
        }
        return "detail";
    }
}
