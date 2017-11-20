package com.autumnframework.cms.service.interfaces;

import com.autumnframework.common.model.bo.DataPageResponseMsg;

/**
 * @author Junlan Shuai[shuaijunlan@gmail.com].
 * @date Created on 14:24 2017/11/10.
 */
public interface IRoleService {
    /**
     * 获取所有的角色
     * @return
     */
    DataPageResponseMsg selectAllRole(int page, int limit);
}
