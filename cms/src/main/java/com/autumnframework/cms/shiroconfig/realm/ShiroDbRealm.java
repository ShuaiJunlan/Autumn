/**
 * DO NOT ALTER OR REMOVE COPYRIGHT NOTICES OR THIS HEADER.
 *
 * Copyright 2017 © yangxiaobing, 873559947@qq.com
 *
 * This file is part of contentManagerSystem.
 * contentManagerSystem is free software: you can redistribute it and/or modify
 * it under the terms of the GNU Lesser General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * contentManagerSystem is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU Lesser General Public License for more details.
 *
 * You should have received a copy of the GNU Lesser General Public License
 * along with contentManagerSystem.  If not, see <http://www.gnu.org/licenses/>.
 *
 * 这个文件是contentManagerSystem的一部分。
 * 您可以单独使用或分发这个文件，但请不要移除这个头部声明信息.
 * contentManagerSystem是一个自由软件，您可以自由分发、修改其中的源代码或者重新发布它，
 * 新的任何修改后的重新发布版必须同样在遵守GPL3或更后续的版本协议下发布.
 * 关于GPL协议的细则请参考COPYING文件，
 * 您可以在contentManagerSystem的相关目录中获得GPL协议的副本，
 * 如果没有找到，请连接到 http://www.gnu.org/licenses/ 查看。
 *
 * - Author: yangxiaobing
 * - Contact: 873559947@qq.com
 * - License: GNU Lesser General Public License (GPL)
 * - source code availability: http://git.oschina.net/yangxiaobing_175/contentManagerSystem
 */
package com.autumnframework.cms.shiroconfig.realm;

import com.autumnframework.cms.model.po.Resource;
import com.autumnframework.cms.model.po.User;
import com.autumnframework.cms.service.impl.ResourceServiceImpl;
import com.autumnframework.cms.service.impl.UserServiceImpl;
import org.apache.commons.lang3.StringUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.shiro.authc.*;
import org.apache.shiro.authz.AuthorizationException;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;

import java.util.List;


/**
 * 自定义Realm 实现Shiro权限验证
 *
 * @author yangxiaobing
 * @date 2017/7/10
 */
//@Component
public class ShiroDbRealm extends AuthorizingRealm {

    private Log log = LogFactory.getLog(ShiroDbRealm.class);

//    private boolean authenticationCachingEnabled;

    @Autowired
    @Lazy
    private UserServiceImpl userService;
    @Autowired
    @Lazy
    private ResourceServiceImpl resourceService;

    /**
     * 获取认证信息
     *
     * @return
     * @throws AuthenticationException
     */
    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken token) throws AuthenticationException {
//        if (!super.isAuthenticationCachingEnabled()) {
//            super.setCachingEnabled(authenticationCachingEnabled);
//        }
        UsernamePasswordToken userToken = (UsernamePasswordToken) token;
        String username = userToken.getUsername();
        if (StringUtils.isEmpty(username)) {
            log.error("获取认证信息失败，原因:用户名为空");
            throw new AccountException("用户名为空");
        }
        // 根据登陆用户名查询用户信息
        User user = userService.selectUserByloginName(username);
        if (user == null) {
            throw new AccountException("用户信息为空");
        }
        log.debug("authenticationCachingEnabled:" + super.isAuthenticationCachingEnabled());
        SimpleAuthenticationInfo info = new SimpleAuthenticationInfo(user, user.getPassword(), getName());
        if (null != info) {
            log.info("用户认证通过:登陆用户名:" + user.getUser_login_name());
            return info;
        }

        return null;
    }


    /**
     * 获取授权信息
     *
     * @param principals
     * @return
     */
    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principals) {
//        if (!super.isAuthenticationCachingEnabled()) {
//            super.setCachingEnabled(authenticationCachingEnabled);
//        }
        if (principals == null) {
            throw new AuthorizationException("Principal对象不能为空");
        }

        User user = (User) getAvailablePrincipal(principals);
        log.info("加载用户权限信息，当前登陆用户名:" + user.getUser_login_name());
        log.info("load user information:" + user.getUser_login_name());
        SimpleAuthorizationInfo info = new SimpleAuthorizationInfo();
//        //如果登陆用户是admin,拥有所有权限
//        if(user.getUser_login_name().equals("admin")){
//            List<Resource> resList = resourceService.selectResUrlAllList();
//            for (Resource resource : resList) {
//                info.addStringPermission(resource.getResModelCode());
//
//            }
//        }else{
//            List<Resource> resUserList = resourceService.selectResListByUserId(user.getId());
//            for (Resource resUser : resUserList) {
//                info.addStringPermission(resUser.getResModelCode());
//            }
//        }

        List<Resource> resUserList = resourceService.selectResListByUserId(user.getId());
        for (Resource resUser : resUserList) {
            info.addStringPermission(String.valueOf(resUser.getId()));
        }
        return  info;
    }



    /**
     * 清除所有用户授权信息缓存.
     */
//    public void clearAllCachedAuthorizationInfo(){
//        log.info("清除所有账号缓存");
//        Cache<Object, AuthorizationInfo> cache = getAuthorizationCache();
//        if (cache != null){
//            for (Object key : cache.keys()) {
//                cache.remove(key);
//            }
//        }
//    }
}
