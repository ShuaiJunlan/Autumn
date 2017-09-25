package com.autumnframework.login.dao1.vomapper.interfaces;

import com.autumnframework.login.model.vo.SysMenu;

import java.sql.SQLException;
import java.util.List;

/**
 * @author Junlan Shuai[shuaijunlan@gmail.com].
 * @date Created on 16:28 2017/9/4.
 */
public interface ISysMapper {
    List<SysMenu> getMenuBySys(Integer sys) throws SQLException;
}
