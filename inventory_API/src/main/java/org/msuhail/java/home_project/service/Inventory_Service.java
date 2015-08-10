package org.msuhail.java.home_project.service;

import java.util.ArrayList;

import org.msuhail.java.home_project.DAO.Inventory_DAO;
import org.msuhail.java.home_project.model.Inventory;

public class Inventory_Service {

	public static ArrayList<Inventory> GetAllInventory(){
		ArrayList<Inventory> inventory=Inventory_DAO.GetAllInventory();
		return inventory;
	}
	
	
	
}
