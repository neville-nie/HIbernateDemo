/*
 *abstract: 
 *
 *@author NW
 *
 *Created on 2017-4-25
 *
 */
package hibernateTest;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.junit.Test;

import config.HibernateSessionFactory;
import entity.User;
import entityXml.Student;

/**
 * HibernateTest.java 
 * abstract:
 * 
 * hostory:
 * 	 NW 2017-4-25 初始化
 */
public class HibernateTest {
	@Test
	public void insert() {  
	    //加载配置文件:classpath:hibernate.cfg.xml  
	    Configuration config = new Configuration().configure();
	    //创建连接工厂  
	    SessionFactory sf = config.buildSessionFactory();  
	      
	    //会话对象，表示与数据库的连接会话过程,相当于jdbc的connection连接对象  
	    Session session = sf.openSession();
		Transaction transaction = session.beginTransaction();
		
	    User user1 = new User("name1","email1");
		session.save(user1);
		transaction.commit();
		session.close();         
	}
	
	@Test
	public void add() {
		Session session = HibernateSessionFactory.getSession();
		Transaction transaction = session.getTransaction();
		transaction.begin();
		User user = new User("name","email");
		session.save(user);
		transaction.commit();
		session.close();	
		//HibernateSessionFactory.closeSession();
	}
	
	@Test
	public void update() {
		Session session = HibernateSessionFactory.getSession();
		User user = (User) session.get(User.class, 25);
		System.out.println("before: "+user.toString());
		
		Transaction transaction = session.getTransaction();
		transaction.begin();
		user.setUserEmail("gai13@gmail.com");
		session.save(user);
		transaction.commit();
		User afterUser = (User) session.get(User.class, 25);
		System.out.println("after: "+afterUser.toString());
		session.close();	
		//HibernateSessionFactory.closeSession();
	}
	
	
	@Test
	public void addSt() {
		Session session = HibernateSessionFactory.getSession();
		Transaction transaction = session.getTransaction();
		transaction.begin();
		Student student = new Student("nw", "gmail");
		session.save(student);
		transaction.commit();
		session.close();
	}
}
