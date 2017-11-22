package com.autumnframework.common.service.impl;

import com.autumnframework.common.architect.auth.email.WebEmail;
import com.autumnframework.common.architect.constant.BusinessConstants;
import com.autumnframework.common.architect.constant.Constants;
import com.autumnframework.common.architect.constant.ResponseCode;
import com.autumnframework.common.architect.utils.ResponseMsgUtil;
import com.autumnframework.common.dao.bomapper.UserMapper;
import com.autumnframework.common.model.bo.DataPageResponseMsg;
import com.autumnframework.common.model.bo.ResponseMsg;
import com.autumnframework.common.model.po.User;
import com.autumnframework.common.service.interfaces.IRegisterService;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * @author Junlan Shuai[shuaijunlan@gmail.com].
 * @date Created on 15:10 2017/10/25.
 */
@Component
public class RegisterServiceImpl implements IRegisterService {
    private Logger logger = LogManager.getLogger(RegisterServiceImpl.class);

    @Autowired
    private UserMapper userMapper;

    @Autowired
    private WebEmail webEmail;

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
    public ResponseMsg registerUser(User user) {
        //  判断邮箱是否已经被注册
        if (userMapper.checkUserExist(user.getUser_login_name()) == 1){
            return ResponseMsgUtil.returnCodeMessage(ResponseCode.DATA_EXIT);
        }
//        int re = webEmail.sendHtmlEmail(Constants.REGISTER_AUTH_EMAIL_SUBJECT, Constants.REGISTER_AUTH_LINK.replace("?", user.getUser_login_name()), user.getUser_login_name());
        int re = 0;
        //  判断邮箱是否是有效邮箱
        if (-1 == re){
            return ResponseMsgUtil.returnCodeMessage(ResponseCode.MAIL_SEND_FAIL);
        }else {
            //  插入用户
            int temp = userMapper.insert(user);
            if (temp == -1){
                return ResponseMsgUtil.returnCodeMessage(ResponseCode.REQUEST_FAIL);
            }else{
                return ResponseMsgUtil.returnCodeMessage(ResponseCode.REQUEST_SUCCESS);
            }
        }
    }

    @Override
    public ResponseMsg updateUserStateByLoginName(int state, String user_login_name) {
        int re = userMapper.updateUserStatusByLoginName(state, user_login_name);
        if (re == 1){
            return ResponseMsgUtil.returnCodeMessage(ResponseCode.AUTH_SUCCESS);
        }
        return ResponseMsgUtil.returnCodeMessage(ResponseCode.AUTH_FAIL);
    }
}
