-- creating tables for project 1
-- reimbursement_requests, users, etc.,

CREATE TABLE ers_user_roles (
	ers_user_role_id serial PRIMARY KEY,
	ers_user_role varchar(10) NOT NULL
); 

INSERT INTO ers_user_roles (ers_user_role)
VALUES ('Manager'), ('Employee');

--
CREATE TABLE ers_reimbursement_type (
	reimbursement_type_id serial PRIMARY KEY,
	reimbursement_type varchar(10) NOT NULL
); 

INSERT INTO ers_reimbursement_type (reimbursement_type)
VALUES ('LODGING'), ('TRAVEL'), ('FOOD'), ('OTHER');

--
CREATE TABLE ers_reimbursement_status (
	reimbursement_status_id serial PRIMARY KEY,
	reimbursement_status varchar(10) NOT NULL
); 

INSERT INTO ers_reimbursement_status (reimbursement_status)
VALUES ('PENDING'), ('APPROVED'), ('DECLINED');

--
CREATE TABLE ers_users (
	user_id serial PRIMARY KEY,
	username varchar(50) NOT NULL,
	PASSWORD varchar(50) NOT NULL,
	first_name varchar(50) NOT NULL,
	last_name varchar(50) NOT NULL,
	user_email varchar(50) NOT NULL,
	user_role_id SMALLINT REFERENCES ers_user_roles (ers_user_role_id)
);

-- the actual reimbursement requests
CREATE TABLE ers_reimbursement (
	reimb_id serial PRIMARY KEY,
	reimb_amount int NOT NULL,
	reimb_submitted timestamp,
	reimb_resolved timestamp, -- will it WORK? YES, simply UPDATE the value TO now() WHEN updated
	reimb_description varchar(50) NOT NULL,
	reimb_author int REFERENCES ers_users (user_id),
	reimb_resolver int REFERENCES ers_users (user_id),
	reimb_status_id int REFERENCES ers_reimbursement_status (reimbursement_status_id),
	reimb_type_id int REFERENCES ers_reimbursement_type (reimbursement_type_id)
);




























---