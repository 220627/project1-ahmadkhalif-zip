package com.revature.daos;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Types;
import java.util.ArrayList;

import com.revature.models.ers_reimbursement;
import com.revature.models.ers_users;
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
			
			String sql = "insert into ers_reimbursements (reimb_amount, reimb_submitted, reimb_resolved, reimb_description, reimb_resolver, reimb_status_id, reimb_type_id) values (?, ?, ?, ?, ?, ?, ?, ?);";
			
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
			
			String sql = "SELECT * FROM ers_reimbursements where reimb_author = ?;";
			
			// because there are no variables/wild-cards involved we don't need a preparedStatement
			PreparedStatement s = conn.prepareStatement(sql);
			
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
						rs.getInt("reimb_type_id")
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
			
			String sql = "SELECT * FROM ers_reimbursements;";
			
			// because there are no variables/wild-cards involved we don't need a preparedStatement
			Statement s = conn.createStatement();
			
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
						rs.getInt("reimb_type_id")
						);

				reimb_list.add(r);
			} // end of while loop
			
			return reimb_list;
			
		} catch (SQLException e) {
			System.out.println("Something went wrong gathering reimbursements;"); // tell the console it failed
			e.printStackTrace(); // print the error log		
		}
		
		return null;
	} // end of selectAllReimbs
		

	@Override
	public ArrayList<ers_reimbursement> viewAllReimbursementsbyType(int reimb_type_id) {

		try(Connection conn = ConnectionUtil.getConnection()){
			
			String sql = "SELECT * FROM ers_reimbursements where reimb_type_id = ?;";
			
			// because there are no variables/wild-cards involved we don't need a preparedStatement
			PreparedStatement s = conn.prepareStatement(sql);
			
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
						rs.getInt("reimb_type_id")
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
	public boolean resolveRequest(ers_users user, int reimb_status_id, int reimb_id ) {
		
		try(Connection conn = ConnectionUtil.getConnection()){
			
			String sql = "update ers_reimbursements set reimb_resolved = ?, reimb_resolver = ?, reimb_status_id = ? where reimb_id = ?;";
			
			PreparedStatement ps = conn.prepareStatement(sql);
			
			ps.setTimestamp(1, getCurrentTimeStamp());
			ps.setInt(2, user.getUser_id()); // will this collect the user who is resolving the reimbursement?
			ps.setInt(3, reimb_status_id);
			ps.setInt(4, reimb_id);
			
			ps.executeUpdate();
			
			return true;
			
		} catch (SQLException e) {
			System.out.println("Failed to resolve reimbursement.");
			e.printStackTrace();
		}
		
		return false;
		
	} // end of 


		
		
	
	
}
