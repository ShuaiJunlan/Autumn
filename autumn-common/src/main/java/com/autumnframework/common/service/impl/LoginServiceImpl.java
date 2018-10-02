package com.autumnframework.common.service.impl;

import com.alibaba.fastjson.JSON;
import com.autumnframework.common.architect.constant.BussinessCode;
import com.autumnframework.common.architect.constant.Constants;
import com.autumnframework.common.architect.constant.ResponseCode;
import com.autumnframework.common.architect.utils.IpInfoUtil;
import com.autumnframework.common.architect.utils.MD5Util;
import com.autumnframework.common.architect.utils.ResponseMsgUtil;
import com.autumnframework.common.model.bo.ResponseMsg;
import com.autumnframework.common.model.po.LoginInfo;
import com.autumnframework.common.model.po.User;
import com.autumnframework.common.service.interfaces.ILoginService;
import org.apache.commons.lang3.StringUtils;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AccountException;
import org.apache.shiro.authc.IncorrectCredentialsException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletRequest;
import java.util.Date;

/**
 * @author Junlan Shuai[shuaijunlan@gmail.com].
 * @date Created on 13:42 2017/12/2.
 */
@Service
public class LoginServiceImpl implements ILoginService {
    @Autowired
    private LogManageImpl logManage;

    private static final Logger log = LoggerFactory.getLogger(LoginServiceImpl.class);
    @Override
    public ResponseMsg loginCheck(String username, String password, String code, HttpServletRequest request, String sys) {


        log.info("Login verification start:{}", new Date());
        long start = System.currentTimeMillis();
        try {
            // username can not be null
            if (StringUtils.isEmpty(username)) {
                log.error("Login failed, reason:{}", BussinessCode.GLOBAL_LOGIN_NAME_NULL.getMsg());
                return ResponseMsgUtil.returnCodeMessage(BussinessCode.GLOBAL_LOGIN_NAME_NULL);
            }
            // password can not be null
            if (StringUtils.isEmpty(password)) {
                log.error("Login failed, reason:{}", BussinessCode.GLOBAL_LOGIN_PASS_NULL.getMsg());
                return ResponseMsgUtil.returnCodeMessage(BussinessCode.GLOBAL_LOGIN_PASS_NULL);
            }
            // code can not be null
            if (StringUtils.isEmpty(code)) {
                log.error("Login failed, reason:{}", BussinessCode.GLOBAL_CAPTCHA_NULL.getMsg());
                return ResponseMsgUtil.returnCodeMessage(BussinessCode.GLOBAL_CAPTCHA_NULL);
            }
            // wrong code
            String sessionCode = (String) request.getSession().getAttribute("code");
            if(!code.equalsIgnoreCase(sessionCode)) {
                log.error("Login failed, reason:{}[enter-code:{},session-code:{}]", BussinessCode.GLOBAL_CAPTCHA_ERROR.getMsg(), code, sessionCode);
                return ResponseMsgUtil.returnCodeMessage(BussinessCode.GLOBAL_CAPTCHA_ERROR);
            }

            UsernamePasswordToken token = new UsernamePasswordToken(username, MD5Util.getMD5(password));
            token.setRememberMe(true);
            Subject currentUser = SecurityUtils.getSubject();

            currentUser.login(token);
            if (currentUser.isAuthenticated()) {
                User user = getCurrentUser();
                // when login autumn-blog
                if (sys.equals("02") && (user.getEmail() == null || user.getEmail().equals(""))){
                    return ResponseMsgUtil.returnCodeMessage(ResponseCode.HAVE_NOT_AUTH);
                }
                request.getSession().setAttribute(Constants.SESSION_KEY_LOGIN_NAME, user);

                //  record user login ip information
                try {
                    String detail = IpInfoUtil.getIpInforByReq(request).getString("data");

                    if (log.isInfoEnabled()){
                        log.info("User login ip information: " + detail);
                    }
                    //  会抛出异常
                    LoginInfo loginInfo = JSON.parseObject(detail, LoginInfo.class);
                    loginInfo.setUser_login_name(username);
                    String sysNum = "01";
                    if (sysNum.equals(sys)) {
                        loginInfo.setType(1);
                    }else {
                        loginInfo.setType(2);
                    }
                    logManage.insertLoginInfo(loginInfo);
                    return ResponseMsgUtil.returnCodeMessage(BussinessCode.GLOBAL_SUCCESS);
                }catch (Exception e){
                    log.error("Invalid ip, exception{}", e);
                    return ResponseMsgUtil.returnCodeMessage(BussinessCode.GLOBAL_SUCCESS);
                }
            }
            return ResponseMsgUtil.returnCodeMessage(BussinessCode.GLOBAL_LOGIN_FAIL);
        } catch (IncorrectCredentialsException ice) {
            log.error("Login failed, reason:{}", "username and password can not match");
            return ResponseMsgUtil.returnCodeMessage(BussinessCode.GLOBAL_LOGIN_FAIL);
        }catch (AccountException e){
            log.error("Login failed, reason:{}", "username and password can not match");
            return ResponseMsgUtil.returnCodeMessage(BussinessCode.GLOBAL_LOGIN_FAIL);
        }catch (Exception e) {
            log.error("Login failed, system exception：{}", e);
            return ResponseMsgUtil.returnCodeMessage(BussinessCode.GLOBAL_LOGIN_ERROR);
        } finally {
            log.info("Login verification end, spend {}ms", System.currentTimeMillis() - start);
        }
    }

    @Override
    public void logout() {
        Subject currentUser = SecurityUtils.getSubject();
        currentUser.logout();
    }


    private User getCurrentUser() {
        Subject currentUser = SecurityUtils.getSubject();
        return currentUser.getPrincipals().oneByType(User.class);
    }

}
