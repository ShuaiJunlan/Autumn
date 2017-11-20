package com.autumnframework.cms.service.impl;


import com.autumnframework.cms.dao.vomapper.interfaces.IMenuManageMapper;
import com.autumnframework.common.architect.constant.ResponseCode;
import com.autumnframework.common.architect.utils.ResponseMsgUtil;
import com.autumnframework.common.model.bo.DataPageResponseMsg;
import com.autumnframework.cms.model.vo.VoMenu;
import com.autumnframework.cms.service.interfaces.IMenuManageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * @author Junlan Shuai[shuaijunlan@gmail.com].
 * @date Created on 10:48 2017/9/5.
 */
@Service
public class MenuManageServiceImpl implements IMenuManageService {

    @Autowired
    private IMenuManageMapper iMenuManageMapper;

    @Override
    public DataPageResponseMsg getMenuByPage(int page, int limit, int level, String type, String sys) {
        List<VoMenu> voMenuList = new ArrayList<>();
        int count = 0;
        try {
            if (level == 1){
                count = iMenuManageMapper.count("af_funcgrp");
            }
            else if (level == 2) {
                count = iMenuManageMapper.count("af_func");
            }
            voMenuList = iMenuManageMapper.getMenuByPage(page, limit, level, type, sys);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return ResponseMsgUtil.returnCodeMessage(ResponseCode.REQUEST_SUCCESS, voMenuList, count);
    }
}
