package com.autumnframework.login.dao1.vomapper.impl;

import com.autumnframework.login.dao1.vomapper.interfaces.ISysMapper;
import com.autumnframework.login.model.vo.SysMenu;
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
 * @date Created on 16:37 2017/9/4.
 */
@Repository
public class SysMapperImpl implements ISysMapper {

    @Autowired
    ComboPooledDataSource comboPooledDataSource;

    @Override
    public List<SysMenu> getMenuBySys(String sys) throws SQLException {
        String sql_select_funcgrp = "SELECT * FROM af_funcgrp WHERE type = 'sysMenu' AND sys = ? ORDER BY disporder";
        String sq_select_func = "SELECT * FROM af_func WHERE grp_name = ? ORDER BY disporder";
        Connection connection = comboPooledDataSource.getConnection();
        PreparedStatement statement = connection.prepareStatement(sql_select_funcgrp);
        statement.setString(1, sys);
        ResultSet resultSet = statement.executeQuery();
        List<SysMenu> sysMenuList = new ArrayList<>();
        while (resultSet.next()){

            SysMenu sysMenu = new SysMenu();
            sysMenu.setMenu_name(resultSet.getString("namec"));
            sysMenu.setHref(resultSet.getString("plugin"));
            statement = connection.prepareStatement(sq_select_func);
            statement.setString(1, resultSet.getString("name"));

            ResultSet resultSet1 = statement.executeQuery();
            List<SysMenu.ChildMenu> childMenuList = new ArrayList<>();
            int i = 0;
            while (resultSet1.next()){
                SysMenu.ChildMenu childMenu = sysMenu.new ChildMenu();
                childMenu.setMenu_name(resultSet1.getString("namec"));
                childMenu.setHref(resultSet1.getString("plugin"));
                childMenuList.add(childMenu);
                i++;
            }

            sysMenu.setChild_num(i);
            sysMenu.setChildes(childMenuList);
            sysMenuList.add(sysMenu);
        }
//        connection.commit();
        resultSet.close();
        statement.close();
        return sysMenuList;
    }
}
