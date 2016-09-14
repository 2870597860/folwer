package com.flower.dao;

import org.hibernate.Session;

import com.flower.entitles.User;
import com.flower.util.HibernateUtil;

public class RegisterResult {
	HibernateUtil hu=new HibernateUtil();
	public boolean register(User user){
		boolean flag;
		Session sess=hu.openSession();
		sess.beginTransaction();
		user.setAddress(user.getAddress());
		sess.save(user);
		flag=true;
		sess.getTransaction().commit();//提交事务
		sess.close();
		return flag;
		
		
	}
}
