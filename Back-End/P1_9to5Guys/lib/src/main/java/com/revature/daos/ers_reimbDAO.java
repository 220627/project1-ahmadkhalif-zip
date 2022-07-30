package com.revature.daos;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Types;
import java.util.ArrayList;

import javax.servlet.http.Cookie;

import com.revature.controllers.ers_users_Controller;
import com.revature.models.ers_reimbursement;
import com.revature.utils.ConnectionUtil;

public class ers_reimbDAO implements ers_reimb_DAOInterface {
	
	// to add timestamp
	private static java.sql.Timestamp getCurrentTimeStamp() {

		java.util.Date today = new java.util.Date();
		return new java.sql.Timestamp(today.getTime());
	}

	
	// methods accessible by employees
	
	// create a new request. Insert into re
	@Override
	public boolean submitReimb(ers_reimbursement reimbursement) {
		
		try(Connection conn = ConnectionUtil.getConnection()){
			
			String sql = "insert into ersreimbursement (reimb_amount, reimb_submitted, reimb_resolved, reimb_description, reimb_resolver, reimb_status_id, reimb_type_id) values (?, ?, ?, ?, ?, ?, ?, ?);";
			
			PreparedStatement ps = conn.prepareStatement(sql);
			
			// fill the wild-cards by index
			ps.setInt(1, reimbursement.getReimb_amount());
			ps.setTimestamp(2, getCurrentTimeStamp());
			ps.setNull(3, Types.NULL);
			ps.setString(4, reimbursement.getReimb_description());
			ps.setInt(5, reimbursement.getReimb_author());
			ps.setNull(6, Types.NULL);
			ps.setInt(7, 0);
			ps.setInt(8, reimbursement.getReimb_type_id());
			
			// send to the database
			ps.executeUpdate();
			
			// Tell the user some kind of information about their reimbursement.
			System.out.println();
			return true;
			
		} catch (SQLException e) {
			System.out.println("Failed to submit a new reimbursement request.");
			e.printStackTrace();
		}
		
		return false;
		
	} // end of insertPrisoner()
	

	@Override
	public ArrayList<ers_reimbursement> viewAllReimbursementsbyUser(int reimb_author) {
		
		try(Connection conn = ConnectionUtil.getConnection()){
			
			String sql = "SELECT * FROM ersreimbursement AS er \r\n"
					+ "INNER JOIN ersusers us ON er.reimb_author = us.user_id\r\n"
					+ "LEFT JOIN (SELECT user_id AS user_id2, username AS username2, first_name AS first_name2, last_name AS last_name2, user_email AS user_email2 FROM ersusers) AS us2 ON er.reimb_resolver = us2.user_id2\r\n"
					+ "LEFT JOIN ersreimbursementstatus AS stat ON er.reimb_status_id = stat.reimbursement_status_id\r\n"
					+ "FULL JOIN ersreimbursementtype AS ty ON er.reimb_type_id = ty.reimbursement_type_id\r\n"
					+ "WHERE er.reimb_author = ?;"; 
			
			// because there are no variables/wild-cards involved we don't need a preparedStatement
			PreparedStatement s = conn.prepareStatement(sql);
			
			//s.setInt(1, );
			
			// a result set will allow us to hold our data
			ResultSet rs = s.executeQuery(sql);
			
			ArrayList<ers_reimbursement> reimb_list = new ArrayList<>();
			
			// we need a while loop to cycle through the array of employees
			while(rs.next()) {
				//use the all args constructor for observing
				ers_reimbursement r = new ers_reimbursement(
						rs.getInt("reimb_id"),
						rs.getInt("reimb_amount"),
						rs.getString("reimb_submitted"),
						rs.getString("reimb_resolved"),
						rs.getString("reimb_description"),
						rs.getInt("reimb_author"),
				        rs.getInt("reimb_resolver"),
				        rs.getInt("reimb_status_id"),
				        rs.getInt("reimb_type_id"),
						rs.getString("username"),
						rs.getString("first_name"),
						rs.getString("last_name"),
						rs.getString("user_email"),
						rs.getString("username2"),
						rs.getString("first_name2"),
						rs.getString("last_name2"),
						rs.getString("user_email2"),
						rs.getString("reimbursement_status"),
						rs.getString("reimbursement_type")
						);

				reimb_list.add(r);
			} // end of while loop
			
			
			
			return reimb_list;
			
		} catch (SQLException e) {
			System.out.println("Something went wrong gathering reimbursements;"); // tell the console it failed
			e.printStackTrace(); // print the error log		
		}

		return null;
	}

	
	// methods accessible by managers
	
	@Override
	public ArrayList<ers_reimbursement> viewAllReimbursements() {
		
		try(Connection conn = ConnectionUtil.getConnection()){
			
			Statement s = conn.createStatement();
			
			String sql1 = "CREATE TEMPORARY TABLE UserNoPass AS SELECT user_id AS user_id2, username AS username2, first_name AS first_name2, last_name AS last_name2, user_email AS user_email2 FROM ersusers;";
			
			s.addBatch(sql1);
			
			s.executeBatch();
			
			String sql2 = "SELECT * FROM ersreimbursement AS er\r\n"
					+ "INNER JOIN ersusers us ON er.reimb_author = us.user_id\r\n"
					+ "LEFT JOIN (SELECT user_id AS user_id2, username AS username2, first_name AS first_name2, last_name AS last_name2, user_email AS user_email2 FROM ersusers) AS us2 ON er.reimb_resolver = us2.user_id2\r\n"
					+ "LEFT JOIN ersreimbursementstatus AS stat ON er.reimb_status_id = stat.reimbursement_status_id\r\n"
					+ "FULL JOIN ersreimbursementtype AS ty ON er.reimb_type_id = ty.reimbursement_type_id;";
			
			// because there are no variables/wild-cards involved we don't need a preparedStatement
			
			
			// a result set will allow us to hold our data
			ResultSet rs = s.executeQuery(sql2); 
			
			ArrayList<ers_reimbursement> reimb_list = new ArrayList<>();
			
			// we need a while loop to cycle through the array of employees
			while(rs.next()) {
				//use the all args constructor for observing
				ers_reimbursement r = new ers_reimbursement(
						rs.getInt("reimb_id"),
						rs.getInt("reimb_amount"),
						rs.getString("reimb_submitted"),
						rs.getString("reimb_resolved"),
						rs.getString("reimb_description"),
						rs.getInt("reimb_author"),
				        rs.getInt("reimb_resolver"),
				        rs.getInt("reimb_status_id"),
				        rs.getInt("reimb_type_id"),
						rs.getString("username"),
						rs.getString("first_name"),
						rs.getString("last_name"),
						rs.getString("user_email"),
						rs.getString("username2"),
						rs.getString("first_name2"),
						rs.getString("last_name2"),
						rs.getString("user_email2"),
						rs.getString("reimbursement_status"),
						rs.getString("reimbursement_type")
						);

				reimb_list.add(r);
			} // end of while loop
			
			return reimb_list;
			
		} catch (SQLException e) {
			System.out.println("Something went wrong gathering reimbursements"); // tell the console it failed
			e.printStackTrace(); // print the error log		
		}
		
		return null;
	} // end of selectAllReimbs
		

	@Override
	public ArrayList<ers_reimbursement> viewAllReimbursementsbyType(int reimb_type_id) {

		try(Connection conn = ConnectionUtil.getConnection()){
			
			String sql = "SELECT * FROM ersreimbursement AS er \r\n"
					+ "INNER JOIN ersusers us ON er.reimb_author = us.user_id\r\n"
					+ "LEFT JOIN (SELECT user_id AS user_id2, username AS username2, first_name AS first_name2, last_name AS last_name2, user_email AS user_email2 FROM ersusers) AS us2 ON er.reimb_resolver = us2.user_id2\r\n"
					+ "LEFT JOIN ersreimbursementstatus AS stat ON er.reimb_status_id = stat.reimbursement_status_id\r\n"
					+ "FULL JOIN ersreimbursementtype AS ty ON er.reimb_type_id = ty.reimbursement_type_id\r\n"
					+ "WHERE er.reimb_type_id = 2;";
			
			// because there are no variables/wild-cards involved we don't need a preparedStatement
			PreparedStatement s = conn.prepareStatement(sql);
			
			s.setInt(1, reimb_type_id);
			
			// a result set will allow us to hold our data
			ResultSet rs = s.executeQuery(sql);
			
			ArrayList<ers_reimbursement> reimb_list = new ArrayList<>();
			
			// we need a while loop to cycle through the array of employees
			while(rs.next()) {
				//use the all args constructor for observing
				ers_reimbursement r = new ers_reimbursement(
						rs.getInt("reimb_id"),
						rs.getInt("reimb_amount"),
						rs.getString("reimb_submitted"),
						rs.getString("reimb_resolved"),
						rs.getString("reimb_description"),
					//	rs.getInt("reimb_author"),
				      //  rs.getInt("reimb_resolver"),
				        //rs.getInt("reimb_status_id"),
				        //rs.getInt("reimb_type_id"),
						rs.getString("username"),
						rs.getString("first_name"),
						rs.getString("last_name"),
						rs.getString("user_email"),
						rs.getString("username2"),
						rs.getString("first_name2"),
						rs.getString("last_name2"),
						rs.getString("user_email2"),
						rs.getString("reimbursement_status"),
						rs.getString("reimbursement_type")
						);

				reimb_list.add(r);
			} // end of while loop
			
			return reimb_list;
			
		} catch (SQLException e) {
			System.out.println("Something went wrong gathering reimbursements;"); // tell the console it failed
			e.printStackTrace(); // print the error log		
		}
		return null;
	}

	
	//update reimbursement
	@Override
	public boolean resolveRequest(int reimb_id, int reimb_resolver, int reimb_status_id) {
		
		try(Connection conn = ConnectionUtil.getConnection()){
			
			String sql = "update ersreimbursement set reimb_resolved = ?, reimb_resolver = ?, reimb_status_id = ? where reimb_id = ?;";
			
			PreparedStatement ps = conn.prepareStatement(sql);
			
			ps.setTimestamp(1, getCurrentTimeStamp());
			ps.setInt(2, reimb_resolver); 
			// will the above collect the user who is resolving the reimbursement?
			// whacky session solution. Will it work
			ps.setInt(3, reimb_status_id);
			ps.setInt(4, reimb_id);
			
			ps.executeUpdate();
			
			return true;
			
		} catch (SQLException e) {
			System.out.println("Failed to resolve reimbursement.");
			e.printStackTrace();
		}
		
		return false;
		
	} // end of resolveReimb
	
}
