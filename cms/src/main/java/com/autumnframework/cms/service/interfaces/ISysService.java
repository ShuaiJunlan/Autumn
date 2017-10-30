package com.autumnframework.cms.service.interfaces;

import com.autumnframework.cms.model.vo.SysMenu;

import java.util.List;

/**
 * @author Junlan Shuai[shuaijunlan@gmail.com].
 * @date Created on 20:36 2017/9/4.
 */
public interface ISysService {
    List<SysMenu> getMenuBySys(String sys);
}
