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
		
		c.setCust_name("����Զ��");//�ͻ�����(��˾����)
		c.setCust_user_id((long) 20170101);//������id
		c.setCust_create_id((long) 20170717);//������id
		c.setCust_source("����");//�ͻ���Ϣ��Դ
		
		
//		  1.�ȼ��������ļ���Configuration��
//		  2.����SessionFactory����
//		  3.����Session����ʹ��Session���������ɾ�Ĳ�����в�����
//		  4.�������� Transanction ��
//		  5.ͨ��Session����������ݿ�
//		  6.�ύ����
//		  7.�ͷ���Դ
		
		Configuration config = new Configuration();
		config.configure();//Ĭ�ϼ���src�µ�hibernate.cfg.xml�ļ�
		
		SessionFactory factory = config.buildSessionFactory();
		
		Session session = factory.openSession();
		
		Transaction tran = session.beginTransaction();
		Customer c1 = session.get(Customer.class, (long)3);
		c1.setCust_name("hello");
		tran.commit();
		session.close();
	}

}
