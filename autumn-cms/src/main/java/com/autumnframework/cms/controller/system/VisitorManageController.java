package com.autumnframework.cms.controller.system;

import com.alibaba.fastjson.JSON;
import com.autumnframework.common.architect.utils.IpInfoUtil;
import com.autumnframework.common.model.po.LoginInfo;
import com.autumnframework.common.service.impl.LogManageImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import sun.misc.Request;

import javax.servlet.http.HttpServletRequest;

/**
 * @author Junlan Shuai[shuaijunlan@gmail.com].
 * @date Created on 17:46 2018/4/10.
 */
@Controller
@ResponseBody
public class VisitorManageController {
    @Autowired
    private LogManageImpl logManage;

    @RequestMapping(value = "/personal/page/visit")
    public void insertVisitorInformation(HttpServletRequest request){
        String detail = null;
        try {
            detail = IpInfoUtil.getIpInforByReq(request).getString("data");
            //  会抛出异常
            LoginInfo loginInfo = JSON.parseObject(detail, LoginInfo.class);
//            loginInfo.setUser_login_name(username);

            loginInfo.setType(3);
            logManage.insertLoginInfo(loginInfo);
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}
