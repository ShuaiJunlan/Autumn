package com.autumnframework.cms.service.impl;

import com.autumnframework.cms.architect.constant.BusinessConstants;
import com.autumnframework.cms.architect.constant.ResponseCode;
import com.autumnframework.cms.architect.utils.ResponseMsgUtil;
import com.autumnframework.cms.dao.bomapper.UserMapper;
import com.autumnframework.cms.model.bo.DataPageResponseMsg;
import com.autumnframework.cms.model.bo.ResponseMsg;
import com.autumnframework.cms.model.po.User;
import com.autumnframework.cms.service.interfaces.IUserService;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

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

    @Override
    public DataPageResponseMsg selectAllUser(int page, int limit) {
        return ResponseMsgUtil.returnCodeMessage(ResponseCode.REQUEST_SUCCESS
                , userMapper.selectAllUser((page-1)*limit, limit)
                , userMapper.getUserCount());
    }

    @Override
    public ResponseMsg insertUser(User user) {
        if (userMapper.checkUserExist(user.getUser_login_name()) == 1){
            return ResponseMsgUtil.returnCodeMessage(ResponseCode.DATA_EXIT);
        }else if (userMapper.insert(user) == -1){
            return ResponseMsgUtil.returnCodeMessage(ResponseCode.REQUEST_FAIL);
        }else {
            return ResponseMsgUtil.returnCodeMessage(ResponseCode.REQUEST_SUCCESS);
        }
    }
}
