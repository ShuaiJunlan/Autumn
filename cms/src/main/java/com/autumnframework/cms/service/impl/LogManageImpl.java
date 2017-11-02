package com.autumnframework.cms.service.impl;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.autumnframework.cms.architect.utils.ResponseMsgUtil;
import com.autumnframework.cms.dao.bomapper.LoginInfoMapper;
import com.autumnframework.cms.architect.constant.ResponseCode;
import com.autumnframework.cms.model.bo.DataPageResponseMsg;
import com.autumnframework.cms.model.po.LoginInfo;
import com.autumnframework.cms.model.vo.ChartsView;
import com.autumnframework.cms.service.interfaces.ILogManage;
import netscape.javascript.JSObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
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
    public DataPageResponseMsg selectAllLoginInfo(int page, int limit) {
        return ResponseMsgUtil.returnCodeMessage(ResponseCode.REQUEST_SUCCESS, loginInfoMapper.selectAllLoginInfo((page-1)*limit, page*limit), loginInfoMapper.getAllLoginInfoConut());
    }

    @Override
    public DataPageResponseMsg selectLoginInfoByUserName(String username, int page, int limit) {
        return ResponseMsgUtil.returnCodeMessage(ResponseCode.REQUEST_SUCCESS, loginInfoMapper.selectLoginInfoByUserName(username, (page-1)*limit, page*limit), loginInfoMapper.getUserLoginInfoConut(username));
    }

    @Override
    public int insertLoginInfo(LoginInfo loginInfo) {
        return loginInfoMapper.insert(loginInfo);
    }

    @Override
    public JSONObject getLoginInfoCharts() {
        List<String> stringList = new ArrayList<>();
        List<Integer> integerList = new ArrayList<>();
        for (ChartsView chartsView : loginInfoMapper.getLoginInfoCharts()){
            stringList.add(chartsView.getX());
            integerList.add(chartsView.getY());
        }
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("X", stringList);
        jsonObject.put("Y", integerList);
        return jsonObject;
    }
}
