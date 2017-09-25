package com.autumnframework.login.dao1.vomapper.interfaces;

import com.autumnframework.login.model.vo.VoMenu;

import java.sql.SQLException;
import java.util.List;

/**
 * @author Junlan Shuai[shuaijunlan@gmail.com].
 * @date Created on 10:24 2017/9/5.
 */
public interface IMenuManageMapper {
    List<VoMenu> getMenuByPage(int page, int limit, int level) throws SQLException;
    int count(String table) throws SQLException;
}
