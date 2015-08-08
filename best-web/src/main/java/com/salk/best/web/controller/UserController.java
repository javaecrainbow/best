package com.salk.best.web.controller;

import java.net.URLEncoder;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.lang.ArrayUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;
import org.tuckey.web.filters.urlrewrite.utils.StringUtils;

import com.salk.best.booking.service.UserService;
import com.salk.best.domain.Export;
import com.salk.best.domain.User;
import com.salk.best.web.dto.AjaxResult;

@Controller
@RequestMapping("/user")
public class UserController extends BaseController {
	@Autowired
	private UserService userService;

	@RequestMapping("/add_user.html")
	@ResponseBody
	public String addUser(ModelAndView view, User user, HttpServletRequest request) {
		boolean status = false;
		String ajaxResult = "";
		User loginUser = getLoginUser(request);
		user.setAdderName(loginUser == null ? "" : loginUser.getUsername());
		user.setUpdaterName(loginUser == null ? "" : loginUser.getUsername());
		if (user.getId() != null && user.getId() != 0) {
			status = userService.editUser(user);
		} else {
			status = userService.addUser(user);
		}
		if (status) {
			ajaxResult = getAjaxResult("200", "success");
		} else {
			ajaxResult = getAjaxResult("300", "failed");

		}
		return ajaxResult;
	}

	@RequestMapping("edit/{id}.html")
	public String editUser(Model model, @PathVariable String id) {
		User user = userService.findUser(id);
		if (user != null) {
			model.addAttribute("user", user);
		}
		return "user/user_input";
	}

	@RequestMapping("changword")
	@ResponseBody
	public String changePwd(Model model, String oldPassword, String password) {
		User user = new User();
		user.setPassword(oldPassword);
		User logonUser = userService.login(user);
		if (logonUser == null) {
			AjaxResult result = new AjaxResult();
			result.setStatusCode("300");
			result.setCloseCurrent(true);
			result.setMessage("密码修改不成功");
			return net.sf.json.JSONObject.fromObject(result).toString();
		} else {
			logonUser.setPassword(password);
			boolean editUser = userService.editUser(logonUser);
			if (editUser) {
				AjaxResult result = new AjaxResult();
				result.setStatusCode("200");
				result.setCloseCurrent(true);
				result.setMessage("密码修改成功");
				return net.sf.json.JSONObject.fromObject(result).toString();

			} else {
				return getAjaxResult("300", "密码修改失败");
			}
		}
	}

	@RequestMapping("/test.html")
	public void testForHandle(String name) throws Exception {
		String encode = URLEncoder.encode(name, "UTF-8");
		System.out.println(encode);
		System.out.println(name);
	}

	@RequestMapping("/list.html")
	public String list(Model model, User user) {
		List<User> users = userService.queryUsers(user);
		buildTotalPage(model, user);

		model.addAttribute("users", users);
		return "user/user_list";
	}

	private void buildTotalPage(Model model, User user) {
		long total = userService.countUser(user);
		model.addAttribute("totalPage", total);

	}

	@RequestMapping("delete.html")
	@ResponseBody
	public String deleteForHandle(Model model, Export export, String delids) {
		if (StringUtils.isBlank(delids)) {
			return null;
		}
		boolean deleteUser = userService.deleteUser(delids);
		if (deleteUser) {
			AjaxResult result = new AjaxResult();
			result.setStatusCode("200");
			result.setMessage("success");
			return net.sf.json.JSONObject.fromObject(result).toString();
		}
		return null;
	}

	public static void main(String[] args) throws Exception {
		System.out.println(ArrayUtils.toString("你好".getBytes()));
		String str = new String("你好".getBytes("iso-8859-1"));
		System.out.println(str);

		String str2 = new String(str.getBytes("iso-8859-1"), "UTF-8");
		System.out.println(str2);

		String str3 = new String(str2.getBytes("ISO-8859-1"), "GBK");
		System.out.println(str3);

	}
}
