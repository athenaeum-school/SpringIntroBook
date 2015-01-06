/*
* All Rights Reserved by Athenaeum Society 2015-
* Written by Inotakuya
*/
package com.as.springbook;
import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletResponse;

public class SimpleCORSFilter implements Filter {
	private String encoding = null;
	
	public void init(FilterConfig config) throws ServletException {
		encoding = config.getInitParameter("encoding");
	}
	
	public void doFilter(ServletRequest req, ServletResponse res,
						FilterChain chain) throws ServletException, IOException {
		//文字コード設定
		req.setCharacterEncoding(encoding);
		HttpServletResponse response = (HttpServletResponse) res;
		response.setHeader("Access-Control-Allow-Origin", "*");
		response.setHeader("Access-Control-Allow-Methods", "POST, GET, PUT, DELETE");
		response.setHeader("Access-Control-Max-Age", "3600");
		response.setHeader("Access-Control-Allow-Headers", "x-requested-with,Content-Type");
		chain.doFilter(req, res);
	}
	
	public void destroy() {
		encoding = null;
	}
}