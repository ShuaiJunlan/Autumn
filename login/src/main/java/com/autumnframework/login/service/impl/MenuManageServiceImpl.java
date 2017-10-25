package com.autumnframework.login.service.impl;


import com.autumnframework.login.dao.vomapper.interfaces.IMenuManageMapper;
import com.autumnframework.login.extern.constant.ResponseCode;
import com.autumnframework.login.extern.utils.ResponseMsgUtil;
import com.autumnframework.login.model.bo.DataPageResponseMsg;
import com.autumnframework.login.model.vo.VoMenu;
import com.autumnframework.login.service.interfaces.IMenuManageService;
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
    public DataPageResponseMsg getMenuByPage(int page, int limit, int level) {
        List<VoMenu> voMenuList = new ArrayList<>();
        int count = 0;
        try {
            if (level == 1){
                count = iMenuManageMapper.count("af_funcgrp");
            }
            else if (level == 2) {
                count = iMenuManageMapper.count("af_func");
            }
            voMenuList = iMenuManageMapper.getMenuByPage(page, limit, level);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return ResponseMsgUtil.returnCodeMessage(ResponseCode.GET_DATA_SUCCESS, voMenuList, count);
    }
}
