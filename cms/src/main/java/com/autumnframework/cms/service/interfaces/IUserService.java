package com.autumnframework.cms.service.interfaces;


import com.autumnframework.cms.model.po.User;

/**
 * @author Junlan Shuai[shuaijunlan@gmail.com].
 * @date Created on 15:09 2017/10/25.
 */
public interface IUserService {
    User selectUserByloginName(String  userLoginName);
}
