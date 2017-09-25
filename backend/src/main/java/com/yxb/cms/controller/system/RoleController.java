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
import com.yxb.cms.architect.utils.CommonHelper;
import com.yxb.cms.controller.BasicController;
import com.yxb.cms.domain.bo.BussinessMsg;
import com.yxb.cms.domain.bo.ExcelExport;
import com.yxb.cms.domain.bo.Tree;
import com.yxb.cms.domain.vo.Role;
import com.yxb.cms.service.ResourceService;
import com.yxb.cms.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;


/**
 * 角色管理Controller
 *
 * @author yangxiaobing
 * @date 2017/7/6
 */
@Controller
@RequestMapping("role")
public class RoleController extends BasicController {


    @Autowired
    private RoleService roleService;
    @Autowired
    private ResourceService resourceService;


    /**
     *跳转到角色列表页面
     * @return
     */
    @RequestMapping("/role_list.do")
    public String toRoleListPage() {
        return "system/role_list";
    }
    /**
     * 加载角色列表List
     * @param role 角色实体
     * @return
     */
    @RequestMapping("/ajax_role_list.do")
    @ResponseBody
    public String ajaxRoleList(Role role){
        return roleService.selectRoleResultPageList(role);
    }

    /**
     * 导出角色列表信息
     * @param role 角色实体
     * @return
     */
    @RequestMapping("/excel_role_export.do")
    public ModelAndView excelRolesExport(Role role){
        ExcelExport excelExport = roleService.excelExportRoleList(role);
        return CommonHelper.getExcelModelAndView(excelExport);
    }



    /**
     * 跳转到角色新增页面
     * @return
     */
    @RequestMapping("/role_add.do")
    public String toRoleAddPage(Model model) {
        //新增页面标识
        model.addAttribute("pageFlag", "addPage");
        return "system/role_edit";
    }

    /**
     * 跳转到角色修改页面
     * @param roleId 角色Id
     * @return
     */
    @RequestMapping("/role_update.do")
    public String roleUpdatePage(Model model,Integer roleId){
        Role role = roleService.selectRoleById(roleId);
        //修改页面标识
        model.addAttribute("pageFlag", "updatePage");
        model.addAttribute("role", role);
        return "system/role_edit";
    }

    /**
     * 保存角色信息
     * @param role 角色实体
     * @return
     */
    @RequestMapping("/ajax_save_role.do")
    @ResponseBody
    public BussinessMsg ajaxSaveRole(Role role){
        try {
            return roleService.saveOrUpdateRole(role, this.getCurrentLoginName());
        } catch (Exception e) {
            log.error("保存角色信息方法内部错误",e);
            return BussinessMsgUtil.returnCodeMessage(BussinessCode.ROLE_SAVE_ERROR);
        }
    }

    /**
     * 失效角色
     * @param roleId 角色Id
     * @return
     */
    @RequestMapping("/ajax_role_fail.do")
    @ResponseBody
    public BussinessMsg ajaxRoleFail(Integer roleId){
        try {
            return roleService.updateRoleStatus(roleId, this.getCurrentLoginName());
        } catch (Exception e) {
            log.error("失效角色方法内部错误",e);
            return BussinessMsgUtil.returnCodeMessage(BussinessCode.ROLE_FAILK_ERROR);
        }
    }

    /**
     * 批量失效角色
     * @param roleIds 角色Id
     * @return
     */
    @RequestMapping("/ajax_role_batch_fail.do")
    @ResponseBody
    public BussinessMsg ajaxRoleBatchFail(@RequestParam(value = "roleIds[]") Integer[] roleIds){
        try {
            return roleService.updateRoleBatchStatus(roleIds, this.getCurrentLoginName());
        } catch (Exception e) {
            log.error("批量失效角色方法内部错误",e);
            return BussinessMsgUtil.returnCodeMessage(BussinessCode.ROLE_FAILK_ERROR);
        }
    }

    /**
     * 角色授权页面
     * @param model
     * @param roleId 角色Id
     * @return
     */
    @RequestMapping("/role_grant.do")
    public String roleGrantPage(Model model,Integer roleId){
        Role role = roleService.selectRoleResourcesByRoleId(roleId);
        model.addAttribute("role",role);
        return "system/role_grant";
    }

    /**
     * 获取当前用户所属菜单资源Tree菜单展示
     */
    @RequestMapping("/ajax_resource_tree_list")
    @ResponseBody
    public List<Tree> ajaxResourceTreeList(){
        return resourceService.selectResourceAllTree();
    }


    /**
     * 保存角色资源信息
     * @param roleId        角色Id
     * @param resourceIds   资源菜单Ids
     * @return
     */
    @RequestMapping("/ajax_save_role_res.do")
    @ResponseBody
    public BussinessMsg ajaxSaveOrUpdateRoleResource(Integer roleId, @RequestParam(value = "resourceIds[]",required = false) Integer[] resourceIds ){
        try {
            return roleService.saveOrUpdateRoleResource(roleId,resourceIds, this.getCurrentLoginName());
        } catch (Exception e) {
            log.error("保存角色信息授权信息方法内部错误",e);
            return BussinessMsgUtil.returnCodeMessage(BussinessCode.ROLE_RES_SAVE_ERROR);
        }
    }


}
