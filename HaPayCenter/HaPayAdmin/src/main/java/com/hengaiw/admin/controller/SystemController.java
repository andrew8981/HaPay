package com.hengaiw.admin.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/admin/system")
public class SystemController {
	@RequestMapping("")
    public String indexTpl(ModelMap model) {
        return "admin/system";
    }
	
	@RequestMapping("/setting")
    public String settingTpl(ModelMap model,HttpServletRequest request) {
        return "/admin/system/setting";
    }
	
	@RequestMapping("/mod")
    public String modTpl(ModelMap model,HttpServletRequest request) {
        return "/admin/system/mod";
    }
}
