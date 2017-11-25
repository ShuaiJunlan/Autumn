package com.autumnframework.blog.controller;

import com.autumnframework.common.architect.constant.ResponseCode;
import com.autumnframework.common.architect.utils.ResponseMsgUtil;
import com.autumnframework.common.model.bo.DataPageResponseMsg;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.ArrayList;

/**
 * 主页Controller
 *
 * @author yangxiaobing
 * @date 2017/7/6
 */
@Controller
public class IndexController extends BasicController {

    /**
     *跳转到主页
     * @return
     */
    @RequestMapping("/index.do")
    public String toIndexPage() {
        return "main/main";
    }

    /**
     * 跳转到欢迎页
     * @return
     */
    @RequestMapping("/home.do")
    public String toHomePage() {
        return "main/main";
    }

    /**
     * 跳转到权限不足页面
     * @return
     */
    @RequestMapping("/unauthorized.do")
    @ResponseBody
    public DataPageResponseMsg toUnauthorizedPage() {
        return ResponseMsgUtil.returnCodeMessage(ResponseCode.GET_DATA_UNAUTHORIZED, new ArrayList<>(), 2);
    }


}
