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
package com.autumnframework.login.service;


import com.autumnframework.login.architect.constant.BusinessConstants;
import com.autumnframework.login.architect.constant.BussinessCode;
import com.autumnframework.login.architect.utils.KeyConfig;
import com.autumnframework.login.architect.utils.ResponseMsgUtil;
import com.autumnframework.login.dao.ResourceMapper;
import com.autumnframework.login.domain.bo.ResponseMsg;
import com.autumnframework.login.domain.bo.Tree;
import com.autumnframework.login.domain.dto.ResourceChildrenMenuDto;
import com.autumnframework.login.domain.dto.ResourceMenuDto;
import com.autumnframework.login.domain.vo.Resource;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.nutz.json.Json;
import org.nutz.json.JsonFormat;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.*;

/**
 * 菜单资源服务类
 * @author yangxiaobing
 * @date 2017/7/14
 *
 */
@Service
public class ResourceService {
	
	private  Log log = LogFactory.getLog(ResourceService.class);
	@Autowired
	private ResourceMapper resourceMapper;



    /**
     * 资源信息分页显示
     * @param resource
     * @return
     */
    public String selectResourceResultPageList(Resource resource){

        List<Resource> resourceList = resourceMapper.selectResourceListByPage(resource);

        Long count = resourceMapper.selectCountResource(resource);

        Map<String, Object> map = new HashMap<String, Object>();

        map.put("code",0);
        map.put("msg","");
        map.put("count",count);
        map.put("data", resourceList);

        return Json.toJson(map);
    }

    public  Resource selectByPrimaryKey(Integer resId){
        return resourceMapper.selectByPrimaryKey(resId);
    }


    /**
     * 顶部菜单展示封装
     * @return
     */
    public String selectResMenuTop(){

        List<ResourceMenuDto> parentResList =  resourceMapper.selectParentIdResList();
        if(null != parentResList && !parentResList.isEmpty()){
            return Json.toJson(parentResList, JsonFormat.full());
        }
        return null;

    }

    /**
     * 根据父级菜单Id查询各级菜单信息
     * @param resParentid 父级菜单
     * @return
     */
    public  String selectResLevelListByParentid(Integer resParentid) {

        //二级菜单
        List<Resource> ResLevel2List =resourceMapper.selectResLevelListByParentid(resParentid);
        if(null != ResLevel2List && !ResLevel2List.isEmpty()){

            List<ResourceMenuDto> resourceMenu = new ArrayList<>();

            for (Resource resource2 : ResLevel2List) {
                ResourceMenuDto menuDto = new ResourceMenuDto();
                menuDto.setTitle(resource2.getResName());
                menuDto.setIcon(resource2.getResImage());
                menuDto.setHref(resource2.getResLinkAddress());

                //三级菜单
                List<Resource> ResLevel3List =resourceMapper.selectResLevelListByParentid(resource2.getResId());
                if(null != ResLevel3List && !ResLevel3List.isEmpty()) {
                    List<ResourceChildrenMenuDto> childrens = new ArrayList<>();
                    for (Resource resource3 : ResLevel3List) {

                        ResourceChildrenMenuDto children = new ResourceChildrenMenuDto();
                        children.setTitle(resource3.getResName());
                        children.setIcon(resource3.getResImage());
                        children.setHref(resource3.getResLinkAddress());
                        childrens.add(children);
                    }
                    menuDto.setChildren(childrens);
                }
                resourceMenu.add(menuDto);

            }
            return Json.toJson(resourceMenu, JsonFormat.full());

        }
        return null;
    }


    /**
     * 查询所有资源信息用以角色赋权限的时候Tree菜单显示
     */
    public List<Tree> selectResourceAllTree() {
        // 菜单资源集合
        List<Resource> resList = resourceMapper.selectResourceAllList();

        // tree 树形集合
        List<Tree> trees = new ArrayList<Tree>();
        if (null != resList && !resList.isEmpty()) {
            for (Resource r : resList) {
                Tree tree = new Tree();
                tree.setId(r.getResId());
                if (null != r.getResParentid()) {
                    tree.setPid(r.getResParentid());
                }
                tree.setText(r.getResName());
                tree.setIconCls(r.getResImage());
                Map<String, Object> attr = new HashMap<String, Object>();
                attr.put("url", r.getResLinkAddress());
                tree.setAttributes(attr);
                trees.add(tree);
            }
        }
        return trees;
    }

    /**
     * 根据菜单类型和菜单级别查询菜单信息
     * @param resType
     * @param resLevel
     * @param resId 菜单Id
     * @return
     */
    public List<Resource> selectParentResListByResTypeAndResLevel(Integer resType,Integer resLevel,Integer resId){

        //1.菜单类型为0-菜单，菜单级别为1级菜单 父级菜单为空
        if(BusinessConstants.SYS_RES_TYPE_0.getCode().equals(resType) && BusinessConstants.SYS_RES_LEVEL_1.getCode().equals(resLevel)){
            return null;
        }
        //2.菜单类型为0-菜单，菜单级别为2级菜单 查询1级父级菜单
        if(BusinessConstants.SYS_RES_TYPE_0.getCode().equals(resType) && BusinessConstants.SYS_RES_LEVEL_2.getCode().equals(resLevel)){
            return  resourceMapper.selectParentResListByResTypeAndResLevel(BusinessConstants.SYS_RES_TYPE_0.getCode(),BusinessConstants.SYS_RES_LEVEL_1.getCode(),resId);
        }
        //3.菜单类型为0-菜单，菜单级别为3级菜单 查询2级父级菜单
        if(BusinessConstants.SYS_RES_TYPE_0.getCode().equals(resType) && BusinessConstants.SYS_RES_LEVEL_3.getCode().equals(resLevel)){
            return  resourceMapper.selectParentResListByResTypeAndResLevel(BusinessConstants.SYS_RES_TYPE_0.getCode(),BusinessConstants.SYS_RES_LEVEL_2.getCode(),resId);
        }
        //4.菜单类型为1-按钮，菜单级别为3级菜单 查询3级菜单
        if(BusinessConstants.SYS_RES_TYPE_1.getCode().equals(resType) && BusinessConstants.SYS_RES_LEVEL_3.getCode().equals(resLevel)){
            return  resourceMapper.selectParentResListByResTypeAndResLevel(BusinessConstants.SYS_RES_TYPE_0.getCode(),BusinessConstants.SYS_RES_LEVEL_3.getCode(),resId);
        }
        return null;
    }



    /**
     * 新增或者修改资源信息
     * @param res 资源对象
     * @param loginName 当前登录用户
     * @return
     * @throws Exception
     */
    @Transactional
    public ResponseMsg saveOrUpdateResource(Resource res, String loginName) throws Exception{
        log.info("保存菜单信息开始");
        long start = System.currentTimeMillis();
        try {
            //保存菜单资源信息
            if (null == res.getResId()) {
                res.setResModelCode(KeyConfig.randomResourceModeCode());
                res.setCreator(loginName);
                res.setCreateTime(new Date());
                resourceMapper.insertSelective(res);
            } else {
                //更新菜单资源信息
                res.setModifier(loginName);
                res.setModifyTime(new Date());
                resourceMapper.updateByPrimaryKeySelective(res);
            }

          

        } catch (Exception e) {
            log.error("保存菜单信息方法内部错误",e);
            throw e;
        }finally {
            log.info("保存菜单信息结束,用时" + (System.currentTimeMillis() - start) + "毫秒");
        }
        return ResponseMsgUtil.returnCodeMessage(BussinessCode.GLOBAL_SUCCESS);
    }

    /**
     * 查询有效的,URL不为空的所有菜单信息
     * @return
     */
    public List<Resource>selectResUrlAllList(){
        return resourceMapper.selectResUrlAllList();
    }

    /**
     * 根据用户Id查询用户资源菜单信息
     * @param userId 用户Id
     * @return
     */
    public List<Resource>selectResListByUserId(Integer userId){
        return resourceMapper.selectResListByUserId(userId);

    }
}
