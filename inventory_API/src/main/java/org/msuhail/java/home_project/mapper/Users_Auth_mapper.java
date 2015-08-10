package org.msuhail.java.home_project.mapper;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.msuhail.java.home_project.model.Users_Auth;

public class Users_Auth_mapper {

	public static ArrayList<Users_Auth> Map_Users_Auth(List users){
		ArrayList<Users_Auth> users_list = new ArrayList<Users_Auth>();
		Iterator it = users.iterator();
		while (it.hasNext()) {
			Users_Auth u = (Users_Auth) it.next();
			users_list.add(u);
			System.out.println(u.user_id);
			// user.add((Users) it.next());
		}
		return users_list;
	}

}
