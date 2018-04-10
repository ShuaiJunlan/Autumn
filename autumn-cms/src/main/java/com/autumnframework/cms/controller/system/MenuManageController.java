package com.autumnframework.cms.controller.system;

import com.autumnframework.common.architect.constant.ResponseCode;
import com.autumnframework.common.architect.utils.ResponseMsgUtil;
import com.autumnframework.common.model.bo.DataPageResponseMsg;
import com.autumnframework.common.model.bo.ResponseMsg;
import com.autumnframework.cms.service.interfaces.IMenuManageService;
import com.autumnframework.common.service.interfaces.IResourceService;
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
    private IMenuManageService iMenuManageService;

    @Autowired
    private IResourceService iResourceService;
    @RequestMapping(value = "/getMenuList/")
    @ResponseBody
    public DataPageResponseMsg getMenuList(@RequestParam("page") int page, @RequestParam("limit") int limit, @RequestParam int level, @RequestParam String type, @RequestParam String sys){
        return this.iMenuManageService.getMenuByPage(page, limit, level, type, sys);
    }

    @RequestMapping(value = "/deleteMenu/")
    @ResponseBody
    public ResponseMsg deleteMenuById(@RequestParam("id") int id, @RequestParam("level") int level){
        if (iResourceService.deleteResById(id, level) == 1){
            return ResponseMsgUtil.returnCodeMessage(ResponseCode.REQUEST_SUCCESS);
        }
        else {
            return ResponseMsgUtil.returnCodeMessage(ResponseCode.REQUEST_FAIL);
        }
    }
}
