package com.salk.best.web.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang.StringUtils;

public class RoleFilter implements Filter {

	@Override
	public void init(FilterConfig filterConfig) throws ServletException {
		// TODO Auto-generated method stub

	}

	@Override
	public void doFilter(ServletRequest request, ServletResponse response,
			FilterChain chain) throws IOException, ServletException {
		HttpServletRequest req = (HttpServletRequest) request;
		HttpServletResponse res = (HttpServletResponse) response;
		String uri = req.getServletPath();
		if (permit(uri)) {
			chain.doFilter(request, response);
		}

		Object attribute = req.getSession().getAttribute("loginInfo");
		if (attribute == null) {
			res.sendRedirect("login.html");
			return;
		} else {
			chain.doFilter(request, response);
		}

	}

	public boolean permit(String url) {
		return url.startsWith("/login") || url.startsWith("/logon");
	}

	public String getRequestUrl(HttpServletRequest request) {

		String requestUrl = request.getScheme() + "://"
				+ request.getServerName() + ":" + request.getServerPort()
				+ request.getServletPath();
		if (StringUtils.isNotEmpty(request.getQueryString())) {
			requestUrl.concat("?").concat(request.getQueryString());
		}
		return requestUrl;
	}

	@Override
	public void destroy() {
		// TODO Auto-generated method stub

	}

}
