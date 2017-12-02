package com.autumnframework.blog.service.impl;

import com.autumnframework.blog.dao.mongo.BlogRepository;
import com.autumnframework.blog.dao.mongo.CommonRepository;
import com.autumnframework.blog.model.document.BlogDetail;
import com.autumnframework.blog.service.interfaces.IBlogManage;
import com.autumnframework.common.architect.constant.ResponseCode;
import com.autumnframework.common.architect.utils.MD5Util;
import com.autumnframework.common.architect.utils.ResponseMsgUtil;
import com.autumnframework.common.model.bo.ResponseMsg;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;

/**
 * @author Junlan Shuai[shuaijunlan@gmail.com].
 * @date Created on 16:30 2017/11/17.
 */
@Service
public class BlogManageImpl implements IBlogManage{

    private static Logger logger = LoggerFactory.getLogger(BlogManageImpl.class);

    @Autowired
    private BlogRepository blogRepository;

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

    @Override
    public ResponseMsg shareBlog(BlogDetail blogDetail) {

        if (StringUtils.isNoneEmpty(blogDetail.getUsername())){
            String id = MD5Util.getMD5(blogDetail.getUsername() + new Date().toString());
            blogDetail.setId(id);
        }else {
            return ResponseMsgUtil.returnCodeMessage(ResponseCode.REQUEST_FAIL);
        }

        //  default value
        blogDetail.setTime(new Date());
        blogDetail.setComment_times(0);
        blogDetail.setVisit_times(0);
        blogDetail.setState(1);

        blogRepository.save(blogDetail);
        return ResponseMsgUtil.returnCodeMessage(ResponseCode.REQUEST_SUCCESS, blogDetail.getId());
    }
}
