package com.hengaiw.admin.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/admin")
public class LoginController {
	@RequestMapping("/login")
    public String indexTpl(ModelMap model) {
        return "admin/login";
    }
	
	@RequestMapping("/login/error")
    public String loginErrorTpl() {
        return "public/error";
    }
}
