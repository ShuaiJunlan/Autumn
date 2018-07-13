package com.autumnframework.cms.controller.system;

import com.autumnframework.common.model.bo.DataPageResponseMsg;
import com.autumnframework.cms.service.impl.RoleServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @author Junlan Shuai[shuaijunlan@gmail.com].
 * @date Created on 14:28 2017/11/10.
 */
@Controller
@RequestMapping(value = "/role")
public class RoleManageController {
    @Autowired
    private RoleServiceImpl roleService;
    @RequestMapping(value = "getAllRole/")
    @ResponseBody
    public DataPageResponseMsg getAllRole(@RequestParam("page") int page, @RequestParam("limit") int limit){
        return roleService.selectAllRole(page, limit);
    }

}
