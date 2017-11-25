package com.autumnframework.common.service.interfaces;

import com.alibaba.fastjson.JSONObject;
import com.autumnframework.common.model.po.LoginInfo;
import com.autumnframework.common.model.vo.AreaView;
import com.autumnframework.common.model.bo.DataPageResponseMsg;

import java.util.List;


/**
 * @author Junlan Shuai[shuaijunlan@gmail.com].
 * @date Created on 19:43 2017/10/31.
 */
public interface ILogManage {
    DataPageResponseMsg selectAllLoginInfo(int page, int limit);
    DataPageResponseMsg selectLoginInfoByUserName(String username, int page, int limit);
    int insertLoginInfo(LoginInfo loginInfo);
    JSONObject getLoginInfoCharts();
    List<AreaView> getLoginInfoArea();
}
