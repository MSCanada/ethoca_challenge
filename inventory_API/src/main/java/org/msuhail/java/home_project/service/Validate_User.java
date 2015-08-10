package org.msuhail.java.home_project.service;

import java.security.NoSuchAlgorithmException;

import org.msuhail.java.home_project.DAO.Authenticate_Users;
import org.msuhail.java.home_project.model.Users_Auth;

public class Validate_User {

	
	public static boolean Authenticate(Users_Auth user) throws NoSuchAlgorithmException{
	Users_Auth user_ById=Authenticate_Users.GetUserById(user);
	
	if(user_ById==null)
		return false;
	else if(user_ById.Password.equals(HashGenerator.GetHash(user.Password))){
			return true;
		}
		else
		return false;
	}
}
