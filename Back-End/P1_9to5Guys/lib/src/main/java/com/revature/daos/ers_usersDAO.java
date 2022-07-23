package com.revature.daos;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.revature.models.ers_users;
import com.revature.utils.ConnectionUtil;

public class ers_usersDAO implements ers_users_DAOInterface {

	@Override
	public ers_users login(String user_name, String password) {
		
		try(Connection conn = ConnectionUtil.getConnection()) {
			
			String sql = "select * from users where username = ? and password = ?;";
			
			PreparedStatement ps = conn.prepareStatement(sql);
			
			ps.setString(1, user_name);
			ps.setString(2, password);
			
			ResultSet rs = ps.executeQuery();
			
			// if anything gets returned at all we know a user exists with that user_ame/password pair. so we can return true
			if(rs.next()) {
				ers_users u = new ers_users(
						rs.getInt("user_id"),
						rs.getString("username"),
// not necessary		rs.getString("password"),
						rs.getString("first_name"),
						rs.getString("last_name"),
						rs.getString("user_email"),
						rs.getInt("user_role_id")
						);
				
				return u;
				
				//notice we're returning the password here... probably not best practice lol
				// in a REAL application, we'd probably want a User constructor with no password
				// and send that around instead
						
			}
			
		} catch (SQLException e) {
			System.out.println("LOGIN FAILED");
			e.printStackTrace();
			
		}
		
		return null;
	}

	
} // end of DAO method
