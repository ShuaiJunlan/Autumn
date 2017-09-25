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
import com.yxb.cms.domain.vo.User;
import com.yxb.cms.service.RoleService;
import com.yxb.cms.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;


/**
 * 用户管理Controller
 *
 * @author yangxiaobing
 * @date 2017/7/6
 */
@Controller
@RequestMapping("user")
public class UserController extends BasicController {


    @Autowired
    private UserService userService;
    @Autowired
    private RoleService roleService;

    /**
     *跳转到用户列表页面
     * @return
     */
    @RequestMapping("/user_list.do")
    public String toUserListPage() {
        return "system/user_list";
    }
    /**
     * 加载用户列表List
     * @param user
     * @return
     */
    @RequestMapping("/ajax_user_list.do")
    @ResponseBody
    public String ajaxUserList(User user){
        return userService.selectUserResultPageList(user);
    }

    /**
     * 导出用户列表信息
     * @param user 用户实体
     * @return
     */
    @RequestMapping("/excel_users_export.do")
    public ModelAndView excelUsersExport(User user){
        ExcelExport excelExport = userService.excelExportUserList(user);
        return CommonHelper.getExcelModelAndView(excelExport);
    }

    /**
     * 跳转到用户新增页面
     * @return
     */
    @RequestMapping("/user_add.do")
    public String toUserAddPage(Model model) {
        //新增页面标识
        model.addAttribute("pageFlag", "addPage");
        return "system/user_edit";
    }

    /**
     * 跳转到用户修改页面
     * @param userId 用户Id
     * @return
     */
    @RequestMapping("/user_update.do")
    public String userUpdatePage(Model model,Integer userId){
        User user = userService.selectUserById(userId);
        //修改页面标识
        model.addAttribute("pageFlag", "updatePage");
        model.addAttribute("user", user);
        return "system/user_edit";
    }
    /**
     * 保存用户信息
     * @param user 用户实体
     * @return
     */
    @RequestMapping("/ajax_save_user.do")
    @ResponseBody
    public BussinessMsg ajaxSaveUser(User user){
        try {
            return userService.saveOrUpdateUser(user, this.getCurrentLoginName());
        } catch (Exception e) {
            log.error("保存用户信息方法内部错误",e);
            return BussinessMsgUtil.returnCodeMessage(BussinessCode.USER_SAVE_ERROR);
        }
    }

    /**
     * 失效用户
     * @param userId 用户Id
     * @return
     */
    @RequestMapping("/ajax_user_fail.do")
    @ResponseBody
    public BussinessMsg ajaxUserFail(Integer userId){
        try {
            return userService.updateUserStatus(userId, this.getCurrentLoginName());
        } catch (Exception e) {
            log.error("失效用户方法内部错误",e);
            return BussinessMsgUtil.returnCodeMessage(BussinessCode.USER_FAIL_ERROR);
        }
    }

    /**
     * 批量失效用户
     * @param userIds 用户Id
     * @return
     */
    @RequestMapping("/ajax_user_batch_fail.do")
    @ResponseBody
    public BussinessMsg ajaxUserBatchFail(@RequestParam(value = "userIds[]") Integer[] userIds){
        try {
            return userService.updateUserBatchStatus(userIds, this.getCurrentLoginName());
        } catch (Exception e) {
            log.error("批量失效用户方法内部错误",e);
            return BussinessMsgUtil.returnCodeMessage(BussinessCode.USER_FAIL_ERROR);
        }
    }

    /**
     * 跳转到用户角色分配页面
     * @param userId 用户Id
     * @return
     */
    @RequestMapping("/user_grant.do")
    public String userGrantPage(Model model,Integer userId){
        User user = userService.selectUserRolesByUserId(userId);
        model.addAttribute("user", user);
        return "system/user_grant";
    }



    /**
     * 查询待分配的角色信息(用以给用户分配角色时显示)
     * @param  roleIds 已分配角色Id
     */
    @RequestMapping("/ajax_undistributed_role_list.do")
    @ResponseBody
    public String ajaxUndistributedRoleList(String roleIds){
        return roleService.selectUserRoleByRoleIdList(roleIds);
    }
    /**
     * 查询状态为有效,已分配的角色信息(用已用户分配角色显示)
     * @param roleIds 已分配角色Id
     */
    @RequestMapping("/ajax_deceased_role_list.do")
    @ResponseBody
    public String ajaxDeceasedRoleList(String roleIds){
        return roleService.selectDeceasedUserRoleByRoleIdList(roleIds);
    }

    /**
     * 保存用户分配角色信息
     * @param userId 用户Id
     * @param roleIds 分配的角色信息
     * @return
     */
    @RequestMapping("/ajax_save_user_role.do")
    @ResponseBody
    public BussinessMsg ajaxSaveUserRole(Integer userId,String roleIds){
        try {
           return  userService.saveUserRole(userId,roleIds, this.getCurrentLoginName());
        } catch (Exception e) {
            log.error("用户分配角色信息方法内部错误",e);
            return BussinessMsgUtil.returnCodeMessage(BussinessCode.USER_ROLE_SAVE_ERROR);

        }}


}
