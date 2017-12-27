package com.hengaiw.admin.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/shop")
public class ShopController {
	@RequestMapping("/list")
    public String indexTpl(ModelMap model) {
        return "shop/list";
    }
}
