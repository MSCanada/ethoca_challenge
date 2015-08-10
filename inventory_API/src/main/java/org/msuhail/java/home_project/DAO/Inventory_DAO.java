package org.msuhail.java.home_project.DAO;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.msuhail.java.home_project.mapper.Inventory_mapper;
import org.msuhail.java.home_project.mapper.Users_Auth_mapper;
import org.msuhail.java.home_project.model.Inventory;
import org.msuhail.java.home_project.model.Users_Auth;
import org.msuhail.java.home_project.service.SessionFactory_Generation;

public class Inventory_DAO {
private static SessionFactory generate() {
		
		SessionFactory sessionFactory=SessionFactory_Generation.returnSessionFactory();
		return sessionFactory;
	}


public static ArrayList<Inventory> GetAllInventory(){
	SessionFactory sessionFactory = Inventory_DAO.generate();
	Session session = sessionFactory.openSession();
	session.beginTransaction();
	String sql = "SELECT * FROM inventory";
	SQLQuery query = session.createSQLQuery(sql);
	query.addEntity(Inventory.class);
	List qu = query.list();
	ArrayList<Inventory> inventory = Inventory_mapper.Map_Inventory(qu);
	session.close();
	return inventory;
}

public static void InsertRecords(){
	SessionFactory sessionFactory = Inventory_DAO.generate();
	Session session = sessionFactory.openSession();
	String query = "INSERT INTO inventory VALUES (:name,:category,:description,:imageurl,:price)";
	SQLQuery query1 = session.createSQLQuery(query);
	query1.setParameter("name", "muhammad");
	query1.setParameter("category", "fruit");
	query1.setParameter("description", "apple a day kees a doctor away");
	query1.setParameter("imageurl", "http");
	query1.setParameter("price", 25);
	int records = query1.executeUpdate();
	session.close();
}

}
