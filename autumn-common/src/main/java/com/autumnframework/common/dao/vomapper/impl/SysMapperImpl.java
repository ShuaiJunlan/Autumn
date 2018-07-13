package com.autumnframework.common.dao.vomapper.impl;

import com.alibaba.druid.pool.DruidDataSource;
import com.alibaba.druid.pool.DruidPooledConnection;
import com.autumnframework.common.dao.vomapper.interfaces.ISysMapper;
import com.autumnframework.common.model.vo.SysMenu;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;

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
    @Qualifier("dataSource")
    private DruidDataSource druidDataSource;

    @Override
    public List<SysMenu> getMenuBySys(String sys) throws SQLException {

        String sql_select_funcgrp = "SELECT * FROM af_funcgrp WHERE type = 'leftMenu' AND status = 1 AND sys = ? ORDER BY disporder";
        String sq_select_func = "SELECT * FROM af_func WHERE grp_name = ? AND status = 1 ORDER BY disporder";

        DruidPooledConnection connection = druidDataSource.getConnection();
        PreparedStatement statement = connection.prepareStatement(sql_select_funcgrp);
        statement.setString(1, sys);
        ResultSet resultSet = statement.executeQuery();
        List<SysMenu> sysMenuList = new ArrayList<>();
        while (resultSet.next()){
            SysMenu sysMenu = new SysMenu();
            sysMenu.setMenu_name(resultSet.getString("namec"));
            sysMenu.setHref(resultSet.getString("plugin"));
            sysMenu.setIcon(resultSet.getString("icon"));

            PreparedStatement statement1 = connection.prepareStatement(sq_select_func);
            statement1.setString(1, resultSet.getString("name"));
            ResultSet resultSet1 = statement1.executeQuery();
            List<SysMenu.ChildMenu> childMenuList = new ArrayList<>();
            int i = 0;
            while (resultSet1.next()){
                SysMenu.ChildMenu childMenu = sysMenu.new ChildMenu();
                childMenu.setMenu_name(resultSet1.getString("namec"));
                childMenu.setHref(resultSet1.getString("plugin"));
//                childMenu.setIcon(resultSet1.getString("icon"));
                childMenuList.add(childMenu);
                i++;
            }
            statement1.close();
            //resultSet1.close();
            sysMenu.setChild_num(i);
            sysMenu.setChildes(childMenuList);
            sysMenuList.add(sysMenu);
        }
        connection.close();
        resultSet.close();      //  只需关闭一次
        statement.close();
        return sysMenuList;
    }
}
