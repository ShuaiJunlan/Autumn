package com.autumnframework.blog.controller;

import com.autumnframework.common.architect.utils.MD5Util;
import com.autumnframework.common.model.bo.ResponseMsg;
import com.autumnframework.common.model.po.User;
import com.autumnframework.common.service.impl.RegisterServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @author Junlan Shuai[shuaijunlan@gmail.com].
 * @date Created on 10:53 2017/11/21.
 */
@Controller
@RequestMapping(value = "register")
public class RegisterController {
    @Autowired
    private RegisterServiceImpl userService;

    @RequestMapping(value = "userRegister/")
    @ResponseBody
    public ResponseMsg doRegister(User user){
        user.setPassword(MD5Util.getMD5(user.getPassword()));
        return userService.registerUser(user);
    }
}
