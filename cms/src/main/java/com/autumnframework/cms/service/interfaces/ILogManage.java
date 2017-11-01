package com.autumnframework.cms.service.interfaces;

import com.autumnframework.cms.model.po.LoginInfo;

import java.util.List;

/**
 * @author Junlan Shuai[shuaijunlan@gmail.com].
 * @date Created on 19:43 2017/10/31.
 */
public interface ILogManage {
    List<LoginInfo> selectAllLoginInfo(int page, int limit);
    List<LoginInfo> selectLoginInfoByUserName(String username, int page, int limit);
    int insertLoginInfo(LoginInfo loginInfo);
}
