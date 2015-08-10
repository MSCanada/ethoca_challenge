package org.msuhail.java.home_project.mapper;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.msuhail.java.home_project.model.Inventory;


public class Inventory_mapper {
	public static ArrayList<Inventory> Map_Inventory(List inventory){
		ArrayList<Inventory> inventory_list = new ArrayList<Inventory>();
		Iterator it = inventory.iterator();
		while (it.hasNext()) {
			Inventory u = (Inventory) it.next();
			inventory_list.add(u);
			}
		return inventory_list;
	}

}
