package com.autumnframework.blog.service.interfaces;

import com.autumnframework.blog.model.document.BlogDetail;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * @author Junlan Shuai[shuaijunlan@gmail.com].
 * @date Created on 16:30 2017/11/17.
 */
public interface IBlogManage {
    BlogDetail getBlogById(String id);
    void insertBlog(String username, String title, int byte_count, String content_md, String content_html);
}
