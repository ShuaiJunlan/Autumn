package com.autumnframework.common.service.interfaces;

import com.autumnframework.common.model.bo.ResponseMsg;

import javax.servlet.http.HttpServletRequest;

/**
 * @author Junlan Shuai[shuaijunlan@gmail.com].
 * @date Created on 13:41 2017/12/2.
 */
public interface ILoginService {
    ResponseMsg loginCheck(String username, String password, String code, HttpServletRequest request, String sys);
    void logout();
}
