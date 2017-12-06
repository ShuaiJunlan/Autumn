package com.autumnframework.common.service.interfaces;


import com.autumnframework.common.model.vo.SysMenu;

import java.util.List;

/**
 * @author Junlan Shuai[shuaijunlan@gmail.com].
 * @date Created on 20:36 2017/9/4.
 */
public interface ISysService {
    /**
     * 根据系统号获取菜单
     * @param sys
     * @return
     */
    List<SysMenu> getMenuBySys(String sys);
}
