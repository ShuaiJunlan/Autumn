package com.autumnframework.login.dao1.vomapper.impl;

import com.autumnframework.login.dao1.vomapper.interfaces.IMenuManageMapper;
import com.autumnframework.login.model.vo.VoMenu;
import com.mchange.v2.c3p0.ComboPooledDataSource;
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
    private ComboPooledDataSource comboPooledDataSource;

    @Override
    public List<VoMenu> getMenuByPage(int page, int limit, int level) throws SQLException {
        String sql_select_menu = "SELECT * FROM af_funcgrp LIMIT " + (page - 1) * limit + "," + (page * limit);
        Connection connection = comboPooledDataSource.getConnection();
        PreparedStatement statement = connection.prepareStatement(sql_select_menu);
        ResultSet resultSet = statement.executeQuery();
        List<VoMenu> voMenuList = new ArrayList<>();
        while(resultSet.next()){
            VoMenu voMenu = new VoMenu();
            voMenu.setId(resultSet.getInt("id"));
            voMenu.setDisporder(resultSet.getInt("disporder"));
            voMenu.setLevel(level + "级菜单");
            voMenu.setName(resultSet.getString("namec"));
            voMenu.setSys(resultSet.getInt("sys"));
            if (level == 1)
                voMenu.setParent_name("");
            else if (level == 2)
                voMenu.setParent_name(resultSet.getString("grp_name"));
            voMenu.setStatus("");
            voMenu.setType("");
            voMenuList.add(voMenu);
        }
        return voMenuList;
    }

    @Override
    public int count(String table) throws SQLException {
        String sql = "SELECT count(*) num FROM " + table;
        Connection connection = comboPooledDataSource.getConnection();
        PreparedStatement statement = connection.prepareStatement(sql);
        ResultSet resultSet = statement.executeQuery();
        if (resultSet.next())
            return resultSet.getInt("num");
        else
            return 0;
    }


}
