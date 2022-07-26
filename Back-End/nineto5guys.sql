-- re-creating tables for project 1
-- reimbursement_requests, users, etc.,

CREATE TABLE ersuserroles (
	ers_user_role_id serial PRIMARY KEY,
	ers_user_role varchar(10) NOT NULL
); 
INSERT INTO ersuserroles (ers_user_role)
VALUES ('Manager'), ('Employee');

CREATE TABLE ersreimbursementtype (
	reimbursement_type_id serial PRIMARY KEY,
	reimbursement_type varchar(10) NOT NULL
); 
INSERT INTO ersreimbursementtype (reimbursement_type)
VALUES ('LODGING'), ('TRAVEL'), ('FOOD'), ('OTHER');
CREATE TABLE ersreimbursementstatus (
	reimbursement_status_id serial PRIMARY KEY,
	reimbursement_status varchar(10) NOT NULL
);
INSERT INTO ersreimbursementstatus (reimbursement_status)
VALUES ('PENDING'), ('APPROVED'), ('DECLINED');
CREATE TABLE ersusers (
	user_id serial PRIMARY KEY,
	username varchar(50) NOT NULL UNIQUE,
	PASSWORD varchar(50) NOT NULL,
	first_name varchar(50) NOT NULL,
	last_name varchar(50) NOT NULL,
	user_email varchar(50) NOT NULL UNIQUE,
	user_role_id SMALLINT REFERENCES ersuserroles (ers_user_role_id)
);
INSERT INTO ersusers (username, PASSWORD, first_name, last_name, user_email, user_role_id)
VALUES ('sputnik', 'supercool', 'Randy', 'Clocker', 'rcgrimes@gmail.com', 1),
	   ('moonman', 'control', 'Gavin', 'Puts', 'gambastra@gmail.com', 1),
	   ('readyFreddy', 'plzdonthack', 'Freddy', 'Kruegar', 'havenofear@gmail.com', 2),
	   ('Bredleees', 'yo', 'Bradly', 'Case', 'enoughofthat@gmail.com', 2),
	   ('yoJams', 'musicheals', 'Lamont', 'Porter', 'soundslikehome@gmail.com', 2);
	  
	  
CREATE TABLE ersreimbursement (
	reimb_id serial PRIMARY KEY,
	reimb_amount int NOT NULL,
	reimb_submitted timestamp,
	reimb_resolved timestamp, -- will it WORK? YES, simply UPDATE the value TO now() WHEN updated
	reimb_description varchar(50) NOT NULL,
	reimb_author int REFERENCES ersusers (user_id),
	reimb_resolver int REFERENCES ersusers (user_id),
	reimb_status_id int REFERENCES ersreimbursementstatus (reimbursement_status_id),
	reimb_type_id int REFERENCES ersreimbursementtype (reimbursement_type_id)
);
INSERT INTO ersreimbursement(reimb_amount, reimb_submitted, reimb_resolved, reimb_description, reimb_author, reimb_resolver, reimb_status_id, reimb_type_id)
VALUES (1000, now(), NULL, 'i need some milk', 4, NULL, 1, 3),
	   (100, now(), NULL, 'pocono''s infiltration', 5, NULL, 1, 1),
	   (2000, now(), NULL, 'no cap I just want money lol', 5, NULL, 1, 4),
	   (600, now(), NULL, 'serious business', 3, NULL, 1, 2);
	   
INSERT INTO ersreimbursement(reimb_amount, reimb_submitted, reimb_resolved, reimb_description, reimb_author, reimb_resolver, reimb_status_id, reimb_type_id)
VALUES (14000, now(), now(), 'i need some broccoli', 4, 1, 3, 3),
	   (725, now(), now(), 'going to Indiana', 5, 2, 2, 1),
	   (9000, now(), now(), 'can I just have some money? lmao', 5, 2, 3, 4);

	  -- view all reimbursements
SELECT * FROM ersreimbursement AS er
INNER JOIN ersusers us ON er.reimb_author = us.user_id 
LEFT JOIN ersusers us2 ON er.reimb_resolver = us2.user_id
LEFT JOIN ersreimbursementstatus AS stat ON er.reimb_status_id = stat.reimbursement_status_id 
FULL JOIN ersreimbursementtype AS ty ON er.reimb_type_id = ty.reimbursement_type_id;

SELECT * FROM ersreimbursement AS er
INNER JOIN ersusers us ON er.reimb_author = us.user_id
LEFT JOIN ersusers AS us2 ON er.reimb_resolver = us2.user_id
LEFT JOIN ersreimbursementstatus AS stat ON er.reimb_status_id = stat.reimbursement_status_id 
FULL JOIN ersreimbursementtype AS ty ON er.reimb_type_id = ty.reimbursement_type_id;

SELECT * FROM UserNoPass;

-- potentially need a transaction to execute column issue

CREATE TEMPORARY TABLE UserNoPass AS SELECT user_id AS user_id2, username AS username2, first_name AS first_name2, last_name AS last_name2, user_email AS user_email2 FROM ersusers;

SELECT * FROM ersreimbursement AS er 
INNER JOIN ersusers us ON er.reimb_author = us.user_id
LEFT JOIN (SELECT user_id AS user_id2, username AS username2, first_name AS first_name2, last_name AS last_name2, user_email AS user_email2 FROM ersusers) AS us2 ON er.reimb_resolver = us2.user_id2
LEFT JOIN ersreimbursementstatus AS stat ON er.reimb_status_id = stat.reimbursement_status_id
FULL JOIN ersreimbursementtype AS ty ON er.reimb_type_id = ty.reimbursement_type_id
WHERE er.reimb_type_id = 2;








