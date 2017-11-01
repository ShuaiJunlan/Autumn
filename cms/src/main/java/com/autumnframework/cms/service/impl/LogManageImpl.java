package com.autumnframework.cms.service.impl;

import com.autumnframework.cms.dao.bomapper.LoginInfoMapper;
import com.autumnframework.cms.model.po.LoginInfo;
import com.autumnframework.cms.service.interfaces.ILogManage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author Junlan Shuai[shuaijunlan@gmail.com].
 * @date Created on 19:43 2017/10/31.
 */
@Service
public class LogManageImpl implements ILogManage {
    @Autowired
    private LoginInfoMapper loginInfoMapper;
    @Override
    public List<LoginInfo> selectAllLoginInfo(int page, int limit) {
        return loginInfoMapper.selectAllLoginInfo((page-1)*limit, page*limit);
    }

    @Override
    public List<LoginInfo> selectLoginInfoByUserName(String username, int page, int limit) {
        return loginInfoMapper.selectLoginInfoByUserName(username, (page-1)*limit, page*limit);
    }

    @Override
    public int insertLoginInfo(LoginInfo loginInfo) {
        return loginInfoMapper.insert(loginInfo);
    }
}
