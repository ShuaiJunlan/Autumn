package com.autumnframework.common.service.impl;

import com.autumnframework.common.dao.bomapper.UserMapper;
import com.autumnframework.common.model.po.User;
import com.autumnframework.common.service.interfaces.IUserService;
import com.autumnframework.common.architect.constant.BusinessConstants;
import com.autumnframework.common.architect.constant.ResponseCode;
import com.autumnframework.common.architect.utils.ResponseMsgUtil;
import com.autumnframework.common.model.bo.DataPageResponseMsg;
import com.autumnframework.common.model.bo.ResponseMsg;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * @author Junlan Shuai[shuaijunlan@gmail.com].
 * @date Created on 15:10 2017/10/25.
 */
@Component
public class UserServiceImpl implements IUserService{
    private Logger logger = LoggerFactory.getLogger(UserServiceImpl.class);

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
