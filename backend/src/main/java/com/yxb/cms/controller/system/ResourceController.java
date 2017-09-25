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
package com.yxb.cms.controller.system;

import com.yxb.cms.architect.constant.BussinessCode;
import com.yxb.cms.architect.utils.BussinessMsgUtil;
import com.yxb.cms.controller.BasicController;
import com.yxb.cms.dao.ResourceMapper;
import com.yxb.cms.domain.bo.BussinessMsg;
import com.yxb.cms.domain.vo.Resource;
import com.yxb.cms.service.ResourceService;
import org.nutz.json.Json;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.ArrayList;
import java.util.List;


/**
 * 资源Controller
 *
 * @author yangxiaobing
 * @date 2017/7/6
 */
@Controller
@RequestMapping("res")
public class ResourceController extends BasicController {

    @Autowired
    private ResourceService resourceService;

    @Autowired
    private ResourceMapper resourceMapper;

    /**
     *跳转到资源列表页面
     * @return
     */
    @RequestMapping("/res_list.do")
    public String toResListPage() {
        return "system/res_list";
    }


    /**
     * 加载资源列表List
     * @param resource
     * @return
     */
    @RequestMapping("/ajax_res_list.do")
    @ResponseBody
    public String ajaxResourceList(Resource resource){
        return resourceService.selectResourceResultPageList(resource);
    }

    /**
     * 加载资源列表List
     * @param resource
     * @return
     */
    @RequestMapping("/ajax_res_tree_list.do")
    @ResponseBody
    public String ajaxResourceTreeList(Resource resource){
        List<Resource> resourceList = resourceMapper.selectResourceAllList();
        return Json.toJson(resourceList);
    }


    /**
     * 选择图标
     * @return
     */
    @RequestMapping("/res_img.do")
    public String toResImgPage() {
        return "system/res_img";
    }
    /**
     * 资源添加页面
     * @return
     */
    @RequestMapping("/res_edit.do")
    public String toResEditPage(Model model) {
        //新增页面标识
        model.addAttribute("pageFlag", "addPage");
        return "system/res_edit";
    }

    /**
     * 菜单资源修改页面
     * @param resId 菜单Id
     * @return
     */
    @RequestMapping("/res_update.do")
    public String userUpdatePage(Model model, Integer resId){
        Resource res = resourceService.selectByPrimaryKey(resId);
        Long resParentCount = resourceMapper.selectCountResParentByResId(resId);
        //修改页面标识
        model.addAttribute("pageFlag", "updatePage");
        model.addAttribute("res", res);
        model.addAttribute("resParentCount", resParentCount);
        return "system/res_edit";
    }


    /**
     * 根据菜单类型和菜单级别查询菜单信息
     * @param resType   菜单类型
     * @param resLevel  菜单级别
     * @param resId 菜单Id
     * @return
     */
    @RequestMapping("ajax_res_parent_menu.do")
    @ResponseBody
    public List<Resource> ajaxResParentMenu(Integer resType,Integer resLevel,Integer resId){
        return resourceService.selectParentResListByResTypeAndResLevel(resType,resLevel,resId);
    }


    /**
     * 保存角色信息
     * @param res 角色实体
     * @return
     */
    @RequestMapping("/ajax_save_resource.do")
    @ResponseBody
    public BussinessMsg ajaxSaveResource(Resource res){
        try {
            return resourceService.saveOrUpdateResource(res, this.getCurrentLoginName() );
        } catch (Exception e) {
            log.error("保存用户信息方法内部错误",e);
            return BussinessMsgUtil.returnCodeMessage(BussinessCode.RES_SAVE_ERROR);
        }
    }


    @RequestMapping("/ajax_res_menu_top.do")
    @ResponseBody
    public String ajaxResMenuTop(){
        return resourceService.selectResMenuTop();
    }

    @RequestMapping("/ajax_res_menu_left.do")
    @ResponseBody
    public String ajaxResMenuLeft(Integer resParentid){
        return resourceService.selectResLevelListByParentid(resParentid);
    }




}
