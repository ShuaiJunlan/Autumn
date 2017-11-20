package com.autumnframework.blog.service.impl;

import com.autumnframework.blog.model.document.BlogDetail;
import com.autumnframework.blog.service.interfaces.IBlogManage;
import org.springframework.stereotype.Service;

import java.util.Date;

/**
 * @author Junlan Shuai[shuaijunlan@gmail.com].
 * @date Created on 16:30 2017/11/17.
 */
@Service
public class BlogManageImpl implements IBlogManage{

    @Override
    public BlogDetail getBlogById(String id) {
        return null;
    }

    @Override
    public void insertBlog(String username, String title, int byte_count, String content_md, String content_html) {
        BlogDetail blogDetail = new BlogDetail();
        blogDetail.setUsername(username);
        blogDetail.setByte_count(byte_count);
        blogDetail.setContent_html(content_html);
        blogDetail.setContent_md(content_md);
        blogDetail.setTitle(title);

        //  default value
        blogDetail.setTime(new Date());
        blogDetail.setComment_times(0);
        blogDetail.setVisit_times(0);
        blogDetail.setId("");
        blogDetail.setState(1);
    }
}
