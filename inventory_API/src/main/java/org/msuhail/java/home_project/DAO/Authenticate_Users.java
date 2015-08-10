package org.msuhail.java.home_project.DAO;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.apache.commons.lang.builder.ToStringBuilder;
import org.hibernate.Query;
import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.msuhail.java.home_project.mapper.Users_Auth_mapper;
import org.msuhail.java.home_project.model.Users_Auth;
import org.msuhail.java.home_project.service.SessionFactory_Generation;
import org.omg.PortableInterceptor.USER_EXCEPTION;

public class Authenticate_Users {

	private static SessionFactory generate() {
		
		SessionFactory sessionFactory=SessionFactory_Generation.returnSessionFactory();
		return sessionFactory;
	}
	
public static ArrayList<Users_Auth> GetAllUsers(){
		SessionFactory sessionFactory = Authenticate_Users.generate();
		Session session = sessionFactory.openSession();
		session.beginTransaction();
		String sql = "SELECT * FROM users";
		SQLQuery query = session.createSQLQuery(sql);
		query.addEntity(Users_Auth.class);
		List qu = query.list();
		ArrayList<Users_Auth> users_list = Users_Auth_mapper.Map_Users_Auth(qu);
		session.close();
		return users_list;
	}

public static void InsertUsers(Users_Auth user_auth){
		SessionFactory sessionFactory = Authenticate_Users.generate();
		Session session = sessionFactory.openSession();
		String query = "INSERT INTO users VALUES (:user_id,:password)";
		SQLQuery query1 = session.createSQLQuery(query);
		query1.setParameter("user_id", user_auth.user_id);
		query1.setParameter("password", user_auth.Password);
		int records = query1.executeUpdate();
		session.close();
}

public static  Users_Auth GetUserById(Users_Auth userAuthorization){
	SessionFactory sessionFactory = Authenticate_Users.generate();
	Session session = sessionFactory.openSession();
	session.beginTransaction();
	String sql = "SELECT * FROM users where user_id=:userid";
	SQLQuery query = session.createSQLQuery(sql);
	query.setParameter("userid", userAuthorization.user_id);
	query.addEntity(Users_Auth.class);
	 Users_Auth user= (Users_Auth)query.uniqueResult();
	session.close();

	return user;
}


	
	
	

}
