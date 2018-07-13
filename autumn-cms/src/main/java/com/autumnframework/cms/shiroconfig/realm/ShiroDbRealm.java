package com.autumnframework.cms.shiroconfig.realm;

import com.autumnframework.common.dao.bomapper.PluginMapper;
import com.autumnframework.common.model.po.Plugin;
import com.autumnframework.common.model.po.Resource;
import com.autumnframework.common.model.po.User;
import com.autumnframework.common.service.impl.ResourceServiceImpl;
import com.autumnframework.common.service.impl.UserServiceImpl;
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
 * @author Junlan Shuai[shuaijunlan@gmail.com].
 * @date Created on 10:51 2017/9/2.
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

    @Autowired
    @Lazy
    private PluginMapper pluginMapper;

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

        List<Resource> resUserList = resourceService.selectResListByUserId(user.getId());
        for (Resource resUser : resUserList) {
            info.addStringPermission(String.valueOf(resUser.getId()));
        }

        List<Plugin> pluginList = pluginMapper.selectPluginByUserId(user.getId());
        for (Plugin plugin : pluginList){
            info.addStringPermission(String.valueOf(plugin.getId()));
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
