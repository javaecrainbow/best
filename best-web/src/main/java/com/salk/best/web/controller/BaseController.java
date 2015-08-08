package com.salk.best.web.controller;

import java.io.UnsupportedEncodingException;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.httpclient.util.DateUtil;
import org.apache.commons.lang.StringUtils;
import org.apache.commons.lang.math.NumberUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;

import com.salk.best.booking.service.ItemService;
import com.salk.best.domain.Item;
import com.salk.best.domain.Page;
import com.salk.best.domain.User;
import com.salk.best.web.dto.AjaxResult;

public abstract class BaseController {
	@Autowired
	private ItemService itemService;

	public String getRemoteAddress(HttpServletRequest request) {
		String ip = request.getHeader("x-forwarded-for");
		if (StringUtils.isEmpty(ip) || ip.equalsIgnoreCase("unknown")) {
			ip = request.getHeader("Proxy-Client-IP");
		}
		if (StringUtils.isEmpty(ip) || ip.equalsIgnoreCase("unknown")) {
			ip = request.getHeader("WL-Proxy-Client-IP");
		}
		if (StringUtils.isEmpty(ip) || ip.equalsIgnoreCase("unknown")) {
			ip = request.getRemoteAddr();
		}
		return ip;
	}

	public boolean validCheck(String page) {
		if (NumberUtils.isNumber(page)) {
			return false;
		}
		return true;
	}

	protected void set2Cookie(String field, String val, HttpServletResponse response) {
		Cookie namecookie = null;
		try {
			namecookie = new Cookie(field, java.net.URLEncoder.encode(val, "UTF-8"));
			namecookie.setPath("/best-web/");

		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		// 生命周期
		namecookie.setMaxAge(60 * 60 * 24 * 365);
		response.addCookie(namecookie);
	}

	protected String getFromCookie(HttpServletRequest request, String field) {
		Cookie[] cookies = request.getCookies();
		String result = "";
		if (cookies != null) {
			for (int i = 0; i < cookies.length; i++) {
				Cookie c = cookies[i];
				if (c.getName().equalsIgnoreCase(field)) {
					try {
						result = java.net.URLDecoder.decode(c.getValue(), "UTF-8");
					} catch (UnsupportedEncodingException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					break;
				}
			}
		}
		return result;
	}

	public Page buildPageCommand(HttpServletRequest request, String page, String pageSize, long total,
			String orderField, String orderDirection) {
		if (StringUtils.isBlank(page)) {
			page = "1";
		}
		if (StringUtils.isBlank(pageSize)) {
			pageSize = "30";
		}
		Long int_page = Long.parseLong(page);
		Long int_pageSize = Long.parseLong(pageSize);
		Page page2 = new Page(int_page, "", int_pageSize);
		page2.setTotal(total);
		page2.setOrderField(orderField);
		page2.setOrderDirection(orderDirection);
		return page2;
	}

	public String getRequestUrl(HttpServletRequest request) {

		String requestUrl = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort()
				+ request.getServletPath();
		if (StringUtils.isNotEmpty(request.getQueryString())) {
			requestUrl.concat("?").concat(request.getQueryString());
		}
		return requestUrl;
	}

	protected void appendItemOptions(Model model) {
		List<Item> queryItems = itemService.queryItems(new Item());
		model.addAttribute("items", queryItems);
	}

	protected void appendColorOptions(Model model) {
		// List<String> colors = Lists.newArrayList("彩藍", "白", "紅", "黃", "黑",
		// "綠", "青", " 螢光綠", "紫", "保藍", "灰", "桃紅", "橙");
		String property = System.getProperty("color");
		if (StringUtils.isBlank(property)) {
			return;
		}
		String[] split = property.split(",");
		List<String> asList = Arrays.asList(split);
		model.addAttribute("colors", asList);

	}

	protected String getAjaxResult(String code, String msg) {
		AjaxResult result = new AjaxResult();
		result.setStatusCode(code);
		result.setMessage(msg);
		result.setCloseCurrent(true);
		return net.sf.json.JSONObject.fromObject(result).toString();
	}

	protected void appendSizeOptions(Model model) {
		String property = System.getProperty("size");
		if (StringUtils.isBlank(property)) {
			return;
		}
		String[] split = property.split(",");
		List<String> asList = Arrays.asList(split);
		model.addAttribute("sizes", asList);

	}

	public User getLoginUser(HttpServletRequest request) {
		User attribute = (User) request.getSession().getAttribute("loginInfo");
		return attribute;
	}

	public String getFormatDate(Date d) {
		return DateUtil.formatDate(d, "yyyy-MM-dd");
	}
}
