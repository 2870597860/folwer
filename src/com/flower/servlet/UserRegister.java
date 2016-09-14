package com.flower.servlet;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.hibernate.Session;

import com.flower.dao.RegisterResult;
import com.flower.entitles.User;
import com.flower.util.HibernateUtil;

/**
 * Servlet implementation class UserRegister
 */
//@WebServlet("/UserRegister")
public class UserRegister extends HttpServlet {
	private static final long serialVersionUID = 1L;
	RegisterResult rr=null;
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UserRegister() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String path="content.jsp";
		String userName=request.getParameter("username");
		String passWord=request.getParameter("userpwd");
		String realName=request.getParameter("realName");
		String address=request.getParameter("address");
		String photoNum= request.getParameter("photoNum");
		int photonum=0;
		if (photoNum!=null&&photoNum.equals("")) {
			 photonum=Integer.parseInt(photoNum);
		}
		User user=new User(userName, passWord,realName, address, photonum);
		rr=new RegisterResult(); 
		boolean result = rr.register(user);
		if (result) {
			RequestDispatcher rd=request.getRequestDispatcher(path);   
			rd.forward(request, response);//转发
		}else {
			request.setAttribute("error", "用户名或密码错误");
			RequestDispatcher rd=request.getRequestDispatcher("userRegister.jsp");   
			rd.forward(request, response);//转发
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
