package com.flower.fliter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

public class LoginFilter implements Filter{

	@Override
	public void destroy() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void doFilter(ServletRequest servletrequest, ServletResponse servletresponse,
			FilterChain filterChain) throws IOException, ServletException {
		// TODO Auto-generated method stub
		HttpServletRequest request=(HttpServletRequest) servletrequest;
		HttpSession session=request.getSession();//获取session
		Object o=session.getAttribute("currentUser");
		String path=request.getServletPath();
		if (o==null&&path.indexOf("userlogin.view")<0) {
			request.getRequestDispatcher("UserLogin.jsp").forward(servletrequest, servletresponse);
		}else{
			filterChain.doFilter(servletrequest, servletresponse);
		}
	}

	@Override
	public void init(FilterConfig arg0) throws ServletException {
		// TODO Auto-generated method stub
		
	}

}


