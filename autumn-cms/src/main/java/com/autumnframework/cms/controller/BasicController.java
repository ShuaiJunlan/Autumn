package com.autumnframework.cms.controller;

import com.autumnframework.common.model.po.User;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.subject.Subject;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

/**
 * @author Junlan Shuai[shuaijunlan@gmail.com].
 * @date Created on 11:32 2017/8/30.
 */
@Controller
@Scope("prototype")
public class BasicController {
    /**
     * 登录用户名
     */
    public String getCurrentLoginName() {
        Subject currentUser = SecurityUtils.getSubject();
        User user = currentUser.getPrincipals().oneByType(User.class);
        return user.getUser_login_name();
    }

    /**
     * 登录用户对象
     */
    public User getCurrentUser() {
        Subject currentUser = SecurityUtils.getSubject();
        User user = currentUser.getPrincipals().oneByType(User.class);
        return user;
    }
}
