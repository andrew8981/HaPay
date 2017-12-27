package com.hengaiw.web.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

import com.hengaiw.pub.utils.HaLog;

@Controller
@RequestMapping("/web")
public class IndexController {
	private final static HaLog _log = HaLog.getLog(IndexController.class);
	
	@RequestMapping("/")
	public String indexCon(ModelMap model, HttpServletRequest request) {
		
		return "web/index";
	}
}
