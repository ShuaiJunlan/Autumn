package com.autumnframework.cms.dao.vomapper.interfaces;

import com.autumnframework.cms.model.vo.VoMenu;

import java.sql.SQLException;
import java.util.List;

/**
 * @author Junlan Shuai[shuaijunlan@gmail.com].
 * @date Created on 10:24 2017/9/5.
 */
public interface IMenuManageMapper {
    /**
     * get menu
     * @param page
     * @param limit
     * @param level
     * @param type
     * @param sys
     * @return
     * @throws SQLException
     */
    List<VoMenu> getMenuByPage(int page, int limit, int level, String type, String sys) throws SQLException;

    /**
     * get count
     * @param table
     * @return
     * @throws SQLException
     */
    int count(String table) throws SQLException;
}
