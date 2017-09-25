package com.autumnframework.login.controller.system;

import com.autumnframework.login.model.bo.DataPageResponseMsg;
import com.autumnframework.login.service.interfaces.IMenuManageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;


/**
 * @author Junlan Shuai[shuaijunlan@gmail.com].
 * @date Created on 10:53 2017/9/5.
 */
@Controller
@RequestMapping(value = "/menu")
public class MenuManageController {
    @Autowired
    IMenuManageService iMenuManageService;
    @RequestMapping(value = "/getMenuList")
    @ResponseBody
    public DataPageResponseMsg getMenuList(@RequestParam("page") int page, @RequestParam("limit") int limit, @RequestParam int level){
        return this.iMenuManageService.getMenuByPage(page, limit, level);
    }

}
