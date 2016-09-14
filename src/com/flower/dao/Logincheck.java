package com.flower.dao;

import java.util.Iterator;
import java.util.List;

import org.hibernate.Session;

import com.flower.entitles.User;
import com.flower.util.HibernateUtil;


public class Logincheck {

	HibernateUtil hu=new HibernateUtil();
	public  User login(User user){
		Session sess=hu.openSession();
		sess.beginTransaction();
		User resultUser=null;
		//String hql = "select u.userName,u.passWord FROM User as u";
		String hql = "FROM User WHERE userName = ? AND passWord = ?";
		List<User> list = sess.createQuery(hql)
				.setString(0, user.getUserName())
				.setString(1, user.getPassWord())
				.list();
		Iterator it=list.iterator();
		if (it.hasNext()) {
			resultUser=new User();
			resultUser.setUserName(list.get(0).getUserName());
			resultUser.setUserName(list.get(1).getPassWord());		
		}

		sess.getTransaction().commit();//提交事务
		sess.close();
		return resultUser;


	}
}
