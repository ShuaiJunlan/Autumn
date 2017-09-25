package com.autumnframework.login.service.interfaces;

import com.alibaba.fastjson.JSONObject;
import com.autumnframework.login.model.bo.DataPageResponseMsg;
import com.autumnframework.login.model.vo.VoMenu;

import java.util.List;

/**
 * @author Junlan Shuai[shuaijunlan@gmail.com].
 * @date Created on 10:48 2017/9/5.
 */
public interface IMenuManageService {
    DataPageResponseMsg getMenuByPage(int page, int limit, int level);
}
