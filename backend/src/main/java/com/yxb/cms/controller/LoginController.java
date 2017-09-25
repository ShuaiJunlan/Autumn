/**
 * DO NOT ALTER OR REMOVE COPYRIGHT NOTICES OR THIS HEADER.
 *
 * Copyright 2017 © yangxiaobing, 873559947@qq.com
 *
 * This file is part of contentManagerSystem.
 * contentManagerSystem is free software: you can redistribute it and/or modify
 * it under the terms of the GNU Lesser General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * contentManagerSystem is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU Lesser General Public License for more details.
 *
 * You should have received a copy of the GNU Lesser General Public License
 * along with contentManagerSystem.  If not, see <http://www.gnu.org/licenses/>.
 *
 * 这个文件是contentManagerSystem的一部分。
 * 您可以单独使用或分发这个文件，但请不要移除这个头部声明信息.
 * contentManagerSystem是一个自由软件，您可以自由分发、修改其中的源代码或者重新发布它，
 * 新的任何修改后的重新发布版必须同样在遵守GPL3或更后续的版本协议下发布.
 * 关于GPL协议的细则请参考COPYING文件，
 * 您可以在contentManagerSystem的相关目录中获得GPL协议的副本，
 * 如果没有找到，请连接到 http://www.gnu.org/licenses/ 查看。
 *
 * - Author: yangxiaobing
 * - Contact: 873559947@qq.com
 * - License: GNU Lesser General Public License (GPL)
 * - source code availability: http://git.oschina.net/yangxiaobing_175/contentManagerSystem
 */
package com.yxb.cms.controller;

import com.yxb.cms.architect.constant.BussinessCode;
import com.yxb.cms.architect.constant.Constants;
import com.yxb.cms.architect.utils.BussinessMsgUtil;
import com.yxb.cms.architect.utils.CreateImageCode;
import com.yxb.cms.domain.bo.BussinessMsg;
import org.apache.commons.lang3.StringUtils;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AccountException;
import org.apache.shiro.authc.IncorrectCredentialsException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

/**
 * 登陆Controller
 * @author yangxiaobing
 * @date 2017/7/17
 *
 */
@Controller
public class LoginController extends BasicController {

    /**
     * 登陆代理，跳转到顶级父窗口
     **/
    @RequestMapping("/loginProxy.do")
    public String toLoginProxy() {
        return "main/loginProxy";
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
    public void Captcha(HttpServletResponse response,HttpSession session)throws IOException {
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
    public BussinessMsg loginCheck(String username, String password,String code,HttpServletRequest request){
        log.info("登陆验证处理开始");
        long start = System.currentTimeMillis();
        try {
            //1.用户名不能为空
            if (StringUtils.isEmpty(username)) {
                log.error("登陆验证失败,原因:用户名不能为空");
                return BussinessMsgUtil.returnCodeMessage(BussinessCode.GLOBAL_LOGIN_NAME_NULL);
            }
            //2.密码不能为空
            if (StringUtils.isEmpty(password)) {
                log.error("登陆验证失败,原因:密码不能为空");
                return BussinessMsgUtil.returnCodeMessage(BussinessCode.GLOBAL_LOGIN_PASS_NULL);
            }
            //3.验证码不能为空
            if (StringUtils.isEmpty(code)) {
                log.error("登陆验证失败,原因:验证码不能为空");
                return BussinessMsgUtil.returnCodeMessage(BussinessCode.GLOBAL_CAPTCHA_NULL);
            }
            //4.验证码输入错误
            String sessionCode = (String) request.getSession().getAttribute("code");
            if(!code.toLowerCase().equals(sessionCode)) {
                log.error("登陆验证失败,原因:验证码错误：code:"+code+",sessionCode:"+sessionCode);
                return BussinessMsgUtil.returnCodeMessage(BussinessCode.GLOBAL_CAPTCHA_ERROR);
            }

            UsernamePasswordToken token = new UsernamePasswordToken(username, password);
            token.setRememberMe(true);
            Subject currentUser = SecurityUtils.getSubject();

            currentUser.login(token);
            if (currentUser.isAuthenticated()) {
                request.getSession().setAttribute(Constants.SESSION_KEY_LOGIN_NAME,getCurrentUser());

                return BussinessMsgUtil.returnCodeMessage(BussinessCode.GLOBAL_SUCCESS);
            }
            return BussinessMsgUtil.returnCodeMessage(BussinessCode.GLOBAL_LOGIN_FAIL);
        } catch (IncorrectCredentialsException ice) {
            log.error("登陆验证失败,原因:用户名或密码不匹配");
            return BussinessMsgUtil.returnCodeMessage(BussinessCode.GLOBAL_LOGIN_FAIL);
        }catch (AccountException e){
            log.error("登陆验证失败,原因:用户名或密码不匹配");
            return BussinessMsgUtil.returnCodeMessage(BussinessCode.GLOBAL_LOGIN_FAIL);
        }catch (Exception e) {
            log.error("登陆验证失败,原因:系统登陆异常", e);
            return BussinessMsgUtil.returnCodeMessage(BussinessCode.GLOBAL_LOGIN_ERROR);
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





}
