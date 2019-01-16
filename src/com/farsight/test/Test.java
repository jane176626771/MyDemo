package com.farsight.test;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import com.farsight.bean.Customer;

public class Test {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Customer c = new Customer();
		
		c.setCust_name("华清远见");//客户名称(公司名称)
		c.setCust_user_id((long) 20170101);//负责人id
		c.setCust_create_id((long) 20170717);//创建人id
		c.setCust_source("网络");//客户信息来源
		
		
//		  1.先加载配置文件（Configuration）
//		  2.创建SessionFactory对象
//		  3.创建Session对象（使用Session对象完成增删改查的所有操作）
//		  4.开启事务（ Transanction ）
//		  5.通过Session对象操作数据库
//		  6.提交事务
//		  7.释放资源
		
		Configuration config = new Configuration();
		config.configure();//默认加载src下的hibernate.cfg.xml文件
		
		SessionFactory factory = config.buildSessionFactory();
		
		Session session = factory.openSession();
		
		Transaction tran = session.beginTransaction();
		Customer c1 = session.get(Customer.class, (long)3);
		c1.setCust_name("hello");
		tran.commit();
		session.close();
	}

}
