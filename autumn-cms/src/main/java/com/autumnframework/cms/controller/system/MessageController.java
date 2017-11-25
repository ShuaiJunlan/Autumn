package com.autumnframework.cms.controller.system;

import com.autumnframework.common.architect.auth.email.WebEmail;
import com.autumnframework.common.architect.constant.ResponseCode;
import com.autumnframework.common.architect.utils.ResponseMsgUtil;
import com.autumnframework.common.model.bo.ResponseMsg;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @author Junlan Shuai[shuaijunlan@gmail.com].
 * @date Created on 16:34 2017/11/8.
 */
@Controller
@RequestMapping(value = "/send")
public class MessageController {

    @Autowired
    private WebEmail webEmail;

    /**
     * 发给管理员反馈消息
     * @param content
     * @param email
     * @return
     */
    @RequestMapping(value = "/admin/")
    @ResponseBody
    public ResponseMsg sendMessToAdmin(@RequestParam("content") String content, @RequestParam("email")String email){
        webEmail.send("用户反馈意见", email + "<br>" + content);

        return ResponseMsgUtil.returnCodeMessage(ResponseCode.REQUEST_SUCCESS);
    }
}
