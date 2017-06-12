package com.pm.controller;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.google.gson.Gson;
import com.pm.entity.TProject;
import com.pm.service.UserService;

@RestController
@RequestMapping(value = "/user/*")
@SessionAttributes("userName")
public class UserController {
	
	@Autowired
	UserService userService;
	
//	@ResponseBody
	@RequestMapping(value = "/login", method = RequestMethod.POST)
	public String login(HttpSession httpSession, @RequestParam("userName") String userName, @RequestParam("passWord") String passWord, RedirectAttributes redirectAttributes){
		
		String ret = null;
		int code = -1;
		
		code = userService.login(userName, passWord);
		switch (code) {
		case -1:
			ret = null;
			break;
		case 0:
			ret = null;
			break;
		case 1:
			ret = "homepage.html";
			httpSession.setAttribute("userName", userName);
			break;
		default:
			ret = null;
			break;
		}
		
		System.out.println(httpSession.getAttribute("userName"));
		
		return ret;
	}
	
	@RequestMapping(value = "/test")
	public String test() {
		
		return "/homePage";
		
	}
}
