package com.revature.daos;

import java.util.ArrayList;

import com.revature.models.ers_reimbursement;

public interface ers_reimb_DAOInterface {

	// employee functions--------------------------------------------------------------
	// create a new reimbursement
	public boolean submitReimb(ers_reimbursement reimbursemet);
	
	public ArrayList<ers_reimbursement> viewAllReimbursementsbyUser(int reimb_author);
	
	
	// managerial functions -----------------------------------------------------------
	// view all reimbursements as a manager...
	public ArrayList<ers_reimbursement> viewAllReimbursements();
	
	// view all reimbursements filtered by a type
	public ArrayList<ers_reimbursement> viewAllReimbursementsbyType(int reimb_type_id);

	public boolean resolveRequest(int reimb_id, int reimb_status_id);
	
}
