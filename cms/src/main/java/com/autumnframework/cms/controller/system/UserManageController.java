package com.autumnframework.cms.controller.system;

import com.autumnframework.cms.model.bo.DataPageResponseMsg;
import com.autumnframework.cms.model.bo.ResponseMsg;
import com.autumnframework.cms.service.impl.UserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @author Junlan Shuai[shuaijunlan@gmail.com].
 * @date Created on 14:07 2017/11/5.
 */
@Controller
@RequestMapping(value = "/user")
public class UserManageController {
    @Autowired
    private UserServiceImpl userService;
    @RequestMapping(value = "/getAllUser/")
    @ResponseBody
    public DataPageResponseMsg getAllUser(){
        return userService.selectAllUser();
    }
}
