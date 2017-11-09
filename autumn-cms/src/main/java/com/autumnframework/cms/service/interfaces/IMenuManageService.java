package com.autumnframework.cms.service.interfaces;

import com.autumnframework.cms.model.bo.DataPageResponseMsg;

/**
 * @author Junlan Shuai[shuaijunlan@gmail.com].
 * @date Created on 10:48 2017/9/5.
 */
public interface IMenuManageService {
    DataPageResponseMsg getMenuByPage(int page, int limit, int level, String type, String sys);
}
