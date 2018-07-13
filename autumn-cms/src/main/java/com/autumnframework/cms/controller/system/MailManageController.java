package com.autumnframework.cms.controller.system;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
@Controller
public class MailManageController {
    @RequestMapping(value = "/test1", method = RequestMethod.GET)
    public String index(Model model) {
        model.addAttribute("name", "shuaijunlan");
        model.addAttribute("age", "22");
        return "test";
    }
}
