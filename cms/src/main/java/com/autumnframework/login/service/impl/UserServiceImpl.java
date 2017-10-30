package com.autumnframework.login.service.impl;

import com.autumnframework.login.architect.constant.BusinessConstants;
import com.autumnframework.login.dao.bomapper.UserMapper;
import com.autumnframework.login.model.po.User;
import com.autumnframework.login.service.interfaces.IUserService;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * @author Junlan Shuai[shuaijunlan@gmail.com].
 * @date Created on 15:10 2017/10/25.
 */
@Component
public class UserServiceImpl implements IUserService{
    private Logger logger = LogManager.getLogger(UserServiceImpl.class);

    @Autowired
    private UserMapper userMapper;

    /**
     * 根据用户Id查询用户信息
     * @param userLoginName 登陆用户名
     * @return
     */
    @Override
    public User selectUserByloginName(String  userLoginName){
        logger.info("Method selectUserByLoginName() execute! - Login authenticate by querying DB. test1");
        return userMapper.selectUserByloginNameAndStatus(userLoginName, Long.valueOf(BusinessConstants.SYS_USER_STATUS_1.getCode()));
    }
}
