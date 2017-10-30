package com.autumnframework.login.dao.vomapper.impl;

import com.alibaba.druid.pool.DruidDataSource;
import com.alibaba.druid.pool.DruidPooledConnection;
import com.autumnframework.login.architect.constant.BusinessConstants;
import com.autumnframework.login.dao.vomapper.interfaces.IMenuManageMapper;
import com.autumnframework.login.model.vo.VoMenu;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * @author Junlan Shuai[shuaijunlan@gmail.com].
 * @date Created on 10:31 2017/9/5.
 */
@Repository
public class MenuManageMapperImpl implements IMenuManageMapper {
    @Autowired
    private DruidDataSource druidDataSource;

    @Override
    public List<VoMenu> getMenuByPage(int page, int limit, int level, String type, String sys) throws SQLException {
//        String sql_select_menu = "SELECT id, sys, name, state, disporder, type, level, parent_name";
//        String sql_select_menu = "SELECT id, sys, name, state, disporder, type, level, parent_name";
        String sql_select_menu = "SELECT * FROM ! WHERE type = ? AND sys = ? LIMIT " + (page - 1) * limit + "," + (page * limit);

        if (level == 1){
            sql_select_menu = sql_select_menu.replace("!", "af_funcgrp");
        }else if(level == 2){
            sql_select_menu = sql_select_menu.replace("!", "af_func");
        }
        DruidPooledConnection connection = druidDataSource.getConnection();
        PreparedStatement statement = connection.prepareStatement(sql_select_menu);
        statement.setString(1, type);
        statement.setString(2, sys);
        ResultSet resultSet = statement.executeQuery();
        List<VoMenu> voMenuList = new ArrayList<>();
        while(resultSet.next()){
            VoMenu voMenu = new VoMenu();
            voMenu.setId(resultSet.getInt("id"));
            voMenu.setDisporder(resultSet.getInt("disporder"));
            voMenu.setLevel(level + "级菜单");
            voMenu.setName(resultSet.getString("name"));
            voMenu.setNamee(resultSet.getString("namee"));
            voMenu.setNamec(resultSet.getString("namec"));
            voMenu.setSys(resultSet.getString("sys"));
            if (level == 1) {
                voMenu.setParent_name("");
            }
            else if (level == 2) {
                voMenu.setParent_name(resultSet.getString("grp_name"));
            }
            if (resultSet.getInt("status") == 0){
                voMenu.setStatus(BusinessConstants.SYS_MENU_STATUS_0.getMsg());
            }else if (resultSet.getInt("status") == 1){
                voMenu.setStatus(BusinessConstants.SYS_MENU_STATUS_1.getMsg());
            }
            voMenu.setType(type);
            voMenuList.add(voMenu);
        }

        resultSet.close();
        statement.close();
        connection.close();
        return voMenuList;
    }

    @Override
    public int count(String table) throws SQLException {
        String sql = "SELECT count(*) num FROM " + table;
        DruidPooledConnection connection = druidDataSource.getConnection();
        PreparedStatement statement = connection.prepareStatement(sql);
        ResultSet resultSet = statement.executeQuery();
        int count = 0;
        if (resultSet.next()) {
             count = resultSet.getInt("num");
        }
        connection.close();
        statement.close();
        resultSet.close();
        return count;
    }


}
