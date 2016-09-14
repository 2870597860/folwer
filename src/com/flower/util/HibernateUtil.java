package com.flower.util;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;

public class HibernateUtil {
	//目的是getSessionFactory
	private static final SessionFactory sessionFac=buildSessionFactory();
	/**
	 *  1,读取并解析配置文件
	 *  2,创建标准服务登记
	 *  3,获取session工厂
	 * @return
	 */
	private static SessionFactory buildSessionFactory(){

		Configuration config=new Configuration().configure();//实例化配置文件
		ServiceRegistry sr=new StandardServiceRegistryBuilder().
				applySettings(config.getProperties()).build();//创建标准服务登记
		return config.buildSessionFactory(sr);//获取session工厂
	}
	/**
	 *  1.打开session
	 *  2创建事务Transation
	 */
	public  Session openSession(){
		Session session=sessionFac.openSession();//生成一个session
		return session;
	}

	public static void main(String[] args) {
		Session session=new HibernateUtil().openSession();
		session.beginTransaction();
		
		session.getTransaction().commit();
		session.close();
	}
	

}
