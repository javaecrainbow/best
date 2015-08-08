package com.salk.best.web.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.salk.best.domain.User;

@Controller
public class IndexController extends BaseController {
	@RequestMapping(value = "/index", method = RequestMethod.GET)
	public String index(ModelAndView view, HttpServletRequest request, HttpServletResponse response) {
		User attribute = (User) request.getSession().getAttribute("loginInfo");
		if (attribute != null) {
			view.getModel().put("loginInfo", attribute);
			// String flag = attribute.isAdmin() ? "1" : "0";
			// set2Cookie("isAdmin", flag, response);
		} else {
			return "redirect:/login.html";

		}
		return "index";
	}
}
