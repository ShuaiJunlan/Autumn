package com.autumnframework.cms.controller.system;

import com.autumnframework.cms.dao.mongo.BlogRepository;
import com.autumnframework.common.architect.constant.ResponseCode;
import com.autumnframework.common.architect.utils.ResponseMsgUtil;
import com.autumnframework.common.model.bo.DataPageResponseMsg;
import com.autumnframework.common.model.bo.ResponseMsg;
import com.autumnframework.common.model.po.BlogDetail;
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
@RequestMapping(value = "article")
public class ArticleManageController {
    @Autowired
    private BlogRepository blogRepository;

    @RequestMapping(value = "list/")
    @ResponseBody
    public DataPageResponseMsg getArticelList(){
        List<BlogDetail> list = blogRepository.findAll();
        int count = list.size();
        return ResponseMsgUtil.returnCodeMessage(ResponseCode.REQUEST_SUCCESS, list, count);
    }
}
