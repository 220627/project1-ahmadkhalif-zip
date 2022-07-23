package com.revature.daos;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Types;
import java.util.ArrayList;

import com.revature.models.ers_reimbursement;
import com.revature.utils.ConnectionUtil;

public class ers_reimbDAO implements ers_reimb_DAOInterface {
	
	// to add timestamp
	private static java.sql.Timestamp getCurrentTimeStamp() {

		java.util.Date today = new java.util.Date();
		return new java.sql.Timestamp(today.getTime());
	}

	
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
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ArrayList<ers_reimbursement> viewAllReimbursements() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ArrayList<ers_reimbursement> viewAllReimbursementsbyType(int reimb_type_id) {
		// TODO Auto-generated method stub
		return null;
	}

	
	//update reimbursement
	@Override
	public boolean resolveRequest(int reimb_id, int reimb_status_id) {
		// TODO Auto-generated method stub
		return false;
	}
	
	
}
