package com.autumnframework.login.controller.system;

import com.autumnframework.login.model.vo.SysMenu;
import com.autumnframework.login.service.interfaces.ISysService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

/**
 * @author Junlan Shuai[shuaijunlan@gmail.com].
 * @date Created on 20:40 2017/9/4.
 */
@Controller
@RequestMapping(value = "/sys")
public class SysController {
    @Autowired
    private ISysService iSysService;
    @RequestMapping(value = "/getMenu/{sys}")
    @ResponseBody
    public List<SysMenu> getMenuBySys(@PathVariable("sys") String sys){
        return iSysService.getMenuBySys(sys);
    }
}
