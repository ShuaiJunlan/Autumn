package com.autumnframework.cms.controller;



import com.autumnframework.common.architect.constant.Constants;
import com.autumnframework.common.architect.utils.CreateImageCode;
import com.autumnframework.common.model.bo.ResponseMsg;
import com.autumnframework.common.model.po.User;
import com.autumnframework.common.service.impl.LoginServiceImpl;
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
public class LoginController{

    @Autowired
    private LoginServiceImpl loginService;

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

        return loginService.loginCheck(username, password, code, request);
    }

    /**
     * 用户退出
     */
    @RequestMapping("/logout.do")
    public String logout(){
        loginService.logout();
        return "login";
    }

    @RequestMapping("/init.do")
    @ResponseBody
    public User initInfo(HttpServletRequest request){
        return (User) request.getSession().getAttribute(Constants.SESSION_KEY_LOGIN_NAME);
    }
}
