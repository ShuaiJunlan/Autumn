package com.autumnframework.cms.service.impl;

import com.autumnframework.cms.dao.bomapper.RoleMapper;
import com.autumnframework.common.architect.constant.ResponseCode;
import com.autumnframework.common.architect.utils.ResponseMsgUtil;
import com.autumnframework.common.model.bo.DataPageResponseMsg;
import com.autumnframework.cms.service.interfaces.IRoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author Junlan Shuai[shuaijunlan@gmail.com].
 * @date Created on 14:25 2017/11/10.
 */
@Service
public class RoleServiceImpl implements IRoleService {
    @Autowired
    private RoleMapper roleMapper;
    @Override
    public DataPageResponseMsg selectAllRole(int page, int limit) {
        return ResponseMsgUtil.returnCodeMessage(ResponseCode.REQUEST_SUCCESS
                , roleMapper.selectAllRole((page-1)*limit, limit)
                , roleMapper.getRoleCount());
    }
}
