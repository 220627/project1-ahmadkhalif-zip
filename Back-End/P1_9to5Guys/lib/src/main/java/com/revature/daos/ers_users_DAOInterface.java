package com.revature.daos;

import com.revature.models.ers_users;

// import com.revature.models.ers_users; 
// add above if base P1 completed

public interface ers_users_DAOInterface {
	
	public ers_users login(String username, String password);
	
	// we only want to make a new employee user as
	// ... as this method isn't really necessary for base project
	// public boolean newEmployeeUser(ers_users user);

}
