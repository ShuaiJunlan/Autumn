package com.autumnframework.cms.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author Junlan Shuai[shuaijunlan@gmail.com].
 * @date Created on 16:25 2017/9/2.
 */
@Controller
public class RootController {
    @RequestMapping(value = "/")
    public String getDefaultPage(){
        return "login";
    }
}
