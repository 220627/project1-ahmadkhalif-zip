package com.revature.services;

import com.revature.daos.ers_usersDAO;
import com.revature.models.ers_users;

public class ers_user_loginService {
	
ers_usersDAO uDAO = new ers_usersDAO();
	
	public ers_users login(String username, String password) {
		
		if(uDAO.login(username, password) != null) {
			return uDAO.login(username, password); // if username and password sned a User from the DAO, send the username back
		
		}
		
		return null; // if login fails, return null
		
	}
}
