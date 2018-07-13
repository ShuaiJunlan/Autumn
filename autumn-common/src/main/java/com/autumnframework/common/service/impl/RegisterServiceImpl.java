package com.autumnframework.common.service.impl;

import com.autumnframework.common.architect.auth.email.RegisterAuth;
import com.autumnframework.common.architect.auth.email.WebEmail;
import com.autumnframework.common.architect.constant.BusinessConstants;
import com.autumnframework.common.architect.constant.Constants;
import com.autumnframework.common.architect.constant.ResponseCode;
import com.autumnframework.common.architect.utils.MD5Util;
import com.autumnframework.common.architect.utils.RandomNumUtil;
import com.autumnframework.common.architect.utils.ResponseMsgUtil;
import com.autumnframework.common.dao.bomapper.UserMapper;
import com.autumnframework.common.model.bo.DataPageResponseMsg;
import com.autumnframework.common.model.bo.ResponseMsg;
import com.autumnframework.common.model.po.User;
import com.autumnframework.common.service.interfaces.IRegisterService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * @author Junlan Shuai[shuaijunlan@gmail.com].
 * @date Created on 15:10 2017/10/25.
 */
@Component
public class RegisterServiceImpl implements IRegisterService {
    private Logger logger = LoggerFactory.getLogger(RegisterServiceImpl.class);

    @Autowired
    private UserMapper userMapper;

    @Autowired
    private WebEmail webEmail;

    @Autowired
    private RegisterAuth register_auth;

    private static Map<String, String> register_code = new ConcurrentHashMap<>();

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
    public synchronized ResponseMsg registerUser(User user) {

        //  判断用户登录名是否已经被注册
        if (userMapper.checkUserExist(user.getUser_login_name()) == 1){
            return ResponseMsgUtil.returnCodeMessage(ResponseCode.DATA_EXIT);
        }
        //  生成一个随机的五位整数，并使用MD5加密，作为激活码
        String active_code = MD5Util.getMD5(String.valueOf(RandomNumUtil.generateNbitNum(5)));

        //  当前时间戳
        long current_time = System.currentTimeMillis();
        String to = user.getEmail();
        String content = Constants.REGISTER_AUTH_TEMPLATE.replace("?", Constants.REGISTER_AUTH_LINK
                .replace("#1", user.getUser_login_name())
                .replace("#2", active_code)
                .replace("#3", String.valueOf(current_time)));

        int check_email = register_auth.checkEmailIsValid(to);

        //  判断邮箱是否有效
        if (-1 == check_email){
            logger.error("invalid email address:" + to);
            return ResponseMsgUtil.returnCodeMessage(ResponseCode.EMAIL_NOT_VALID);
        }

        int send_email = webEmail.sendHtmlEmail(Constants.REGISTER_AUTH_EMAIL_SUBJECT, content, to);
        //  判断邮件是否发送成功
        if (-1 == send_email){
            return ResponseMsgUtil.returnCodeMessage(ResponseCode.MAIL_SEND_FAIL);
        }else {
            //  插入用户
            int temp = userMapper.insert(user);
            if (temp == -1){
                return ResponseMsgUtil.returnCodeMessage(ResponseCode.REQUEST_FAIL);
            }else{
                register_code.put(user.getUser_login_name(), active_code);
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

    @Override
    public ResponseMsg registerAuth(String user_login_name, String activation_code, String time) {

        logger.info("Register authentication start[user_login_name:{}-activation_code:{}-time:{}]", user_login_name, activation_code, time);
        long current_time = System.currentTimeMillis();

        //  判断链接是否失效（超24小时失效）
        if (((current_time-Long.valueOf(time))/(1000.0*60*60)) > 24.0){
            logger.info("Register authentication end! Reason:{}", ResponseCode.AUTH_LINK_TIMEOUT.getMsg());
            return ResponseMsgUtil.returnCodeMessage(ResponseCode.AUTH_LINK_TIMEOUT);
        }

        //  判断是否已经认证
        if (selectUserByloginName(user_login_name) != null){
            logger.info("Register authentication end! Reason:{}", ResponseCode.HAVE_AUTH.getMsg());
            return ResponseMsgUtil.returnCodeMessage(ResponseCode.HAVE_AUTH);
        }

        //  判断激活码和用户名是否匹配
        if (register_code.containsKey(user_login_name) && register_code.get(user_login_name).equals(activation_code)){
            register_code.remove(user_login_name);
            return updateUserStateByLoginName(1, user_login_name);
        }
        logger.info("Register authentication end! Reason:{}", ResponseCode.AUTH_FAIL.getMsg());
        return ResponseMsgUtil.returnCodeMessage(ResponseCode.AUTH_FAIL);
    }
}
