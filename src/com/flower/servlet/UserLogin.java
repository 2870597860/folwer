package com.flower.servlet;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.flower.dao.Logincheck;
import com.flower.entitles.User;



/**
 * Servlet implementation class UserLoginServlet
 */
  
public class UserLogin extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
	Logincheck logincheck=new Logincheck();
	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public UserLogin() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String path="content.jsp";
		String username=request.getParameter("username");
		String userpwd=request.getParameter("userpwd");
		List<String> info=new ArrayList<String>();
		if (username==null||"".equals(username)) {
			info.add("用户名不能为空");
		}
		if (userpwd==null||"".equals(userpwd)) {
			info.add("密码不能为空");
		}
		User user=new User(username, userpwd);
		User currentUser=logincheck.login(user);
		if (currentUser==null) {
			request.setAttribute("error", "用户名或密码错误");
			request.setAttribute("username", username);
			request.setAttribute("password", userpwd);
			request.getRequestDispatcher("UserLogin.jsp").forward(request, response);
		}else {
			HttpSession httpSession=request.getSession();
			httpSession.setAttribute("currentUser", currentUser);
			response.sendRedirect(path);
		}

	}


	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.setCharacterEncoding("utf-8");
		this.doGet(request, response);
		
	}

}