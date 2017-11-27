package com.autumnframework.blog.controller;

import com.alibaba.fastjson.JSON;
import com.autumnframework.common.model.po.LoginInfo;
import com.autumnframework.common.architect.constant.BussinessCode;
import com.autumnframework.common.architect.constant.Constants;
import com.autumnframework.common.architect.utils.CreateImageCode;
import com.autumnframework.common.architect.utils.IpInfoUtil;
import com.autumnframework.common.architect.utils.MD5Util;
import com.autumnframework.common.architect.utils.ResponseMsgUtil;
import com.autumnframework.common.model.bo.ResponseMsg;
import com.autumnframework.common.model.po.User;
import com.autumnframework.common.service.impl.LogManageImpl;
import org.apache.commons.lang3.StringUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AccountException;
import org.apache.shiro.authc.IncorrectCredentialsException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

/**
 * @author Junlan Shuai[shuaijunlan@gmail.com].
 * @date Created on 11:15 2017/8/30.
 */
@Controller
public class LoginController extends BasicController{
    private static final Logger log = LogManager.getLogger(LoginController.class);

    @Autowired
    private LogManageImpl logManage;
    /**
     * 登陆代理，跳转到顶级父窗口
     **/
    @RequestMapping("/loginProxy.do")
    public String toLoginProxy() {
        return "login";
    }

    /**
     * 跳转到登录页面
     *
     * @return
     */
    @RequestMapping("/login.do")
    public String toLoginPage()  {
        return "login";
    }

    /**
     * 生成验证码
     */
    @RequestMapping("/captcha.do")
    public void Captcha(HttpServletResponse response, HttpSession session)throws IOException {
        CreateImageCode vCode = new CreateImageCode(116,36,5,10);
        session.setAttribute("code", vCode.getCode());
        vCode.write(response.getOutputStream());
    }

    /**
     *  登录验证处理
     * @param username 用户名
     * @param password 密码
     * @return
     */
    @RequestMapping("/loginCheck.do")
    @ResponseBody
    public ResponseMsg loginCheck(String username, String password, String code, HttpServletRequest request){

        log.info("登陆验证处理开始");
        long start = System.currentTimeMillis();
        try {
            //1.用户名不能为空
            if (StringUtils.isEmpty(username)) {
                log.error("登陆验证失败,原因:用户名不能为空");
                return ResponseMsgUtil.returnCodeMessage(BussinessCode.GLOBAL_LOGIN_NAME_NULL);
            }
            //2.密码不能为空
            if (StringUtils.isEmpty(password)) {
                log.error("登陆验证失败,原因:密码不能为空");
                return ResponseMsgUtil.returnCodeMessage(BussinessCode.GLOBAL_LOGIN_PASS_NULL);
            }
            //3.验证码不能为空
            if (StringUtils.isEmpty(code)) {
                log.error("登陆验证失败,原因:验证码不能为空");
                return ResponseMsgUtil.returnCodeMessage(BussinessCode.GLOBAL_CAPTCHA_NULL);
            }
            //4.验证码输入错误
            String sessionCode = (String) request.getSession().getAttribute("code");
            if(!code.toLowerCase().equals(sessionCode)) {
                log.error("登陆验证失败,原因:验证码错误：code:"+code+",sessionCode:"+sessionCode);
                return ResponseMsgUtil.returnCodeMessage(BussinessCode.GLOBAL_CAPTCHA_ERROR);
            }

            UsernamePasswordToken token = new UsernamePasswordToken(username, MD5Util.getMD5(password));
            token.setRememberMe(true);
            Subject currentUser = SecurityUtils.getSubject();

            currentUser.login(token);
            if (currentUser.isAuthenticated()) {
                request.getSession().setAttribute(Constants.SESSION_KEY_LOGIN_NAME, getCurrentUser());

                //  记录用户登录ip信息
                try {
                    String detail = IpInfoUtil.getIpInforByReq(request).getString("data");
                    //  会抛出异常
                    LoginInfo loginInfo = JSON.parseObject(detail, LoginInfo.class);
                    loginInfo.setUser_login_name(username);
                    loginInfo.setType(1);
                    logManage.insertLoginInfo(loginInfo);
                }catch (Exception e){
                    log.error("invalid ip");
                }finally {
                    return ResponseMsgUtil.returnCodeMessage(BussinessCode.GLOBAL_SUCCESS);
                }
            }
            return ResponseMsgUtil.returnCodeMessage(BussinessCode.GLOBAL_LOGIN_FAIL);
        } catch (IncorrectCredentialsException ice) {
            log.error("登陆验证失败,原因:用户名或密码不匹配");
            return ResponseMsgUtil.returnCodeMessage(BussinessCode.GLOBAL_LOGIN_FAIL);
        }catch (AccountException e){
            log.error("登陆验证失败,原因:用户名或密码不匹配");
            return ResponseMsgUtil.returnCodeMessage(BussinessCode.GLOBAL_LOGIN_FAIL);
        }catch (Exception e) {
            log.error("登陆验证失败,原因:系统登陆异常", e);
            return ResponseMsgUtil.returnCodeMessage(BussinessCode.GLOBAL_LOGIN_ERROR);
        } finally {
            log.info("登陆验证处理结束,用时" + (System.currentTimeMillis() - start) + "毫秒");
        }
    }

    /**
     * 用户退出
     */
    @RequestMapping("/logout.do")
    public String logout(){
        Subject currentUser = SecurityUtils.getSubject();
        currentUser.logout();
        return "login";
    }

    @RequestMapping("/init.do")
    @ResponseBody
    public User initInfo(HttpServletRequest request){
        return (User) request.getSession().getAttribute(Constants.SESSION_KEY_LOGIN_NAME);
    }
}
