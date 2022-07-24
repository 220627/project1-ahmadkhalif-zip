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

INSERT INTO ers_users (username, PASSWORD, first_name, last_name, user_email, user_role_id)
VALUES ('sputnik', 'supercool', 'Randy', 'Clocker', 'rcgrimes@gmail.com', 1),
	   ('moonman', 'control', 'Gavin', 'Puts', 'gambastra@gmail.com', 1),
	   ('readyFreddy', 'plzdonthack', 'Freddy', 'Kruegar', 'havenofear@gmail.com', 2),
	   ('Bredleees', 'yo', 'Bradly', 'Case', 'enoughofthat@gmail.com', 2),
	   ('yoJams', 'musicheals', 'Lamont', 'Porter', 'soundslikehome@gmail.com', 2);

INSERT INTO ers_reimbursement(reimb_amount, reimb_submitted, reimb_resolved, reimb_description, reimb_author, reimb_resolver, reimb_status_id, reimb_type_id)
VALUES (1000, now(), NULL, 'i need some milk', 4, NULL, 1, 3),
	   (100, now(), NULL, 'pocono''s infiltration', 5, NULL, 1, 1),
	   (2000, now(), NULL, 'no cap I just want money lol', 5, NULL, 1, 4),
	   (600, now(), NULL, 'serious business', 3, NULL, 1, 2);

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
SELECT * FROM ers_reimbursement AS er 
INNER JOIN UserNoPass AS us ON er.reimb_author = us.user_id
LEFT JOIN usernopass AS us2 ON er.reimb_resolver = us2.user_id
LEFT JOIN ers_reimbursement_status AS stat ON er.reimb_status_id = stat.reimbursement_status_id 
FULL JOIN ers_reimbursement_type AS ty ON er.reimb_type_id = ty.reimbursement_type_id;

-- get rid of passwords from table... wrong table
CREATE TEMPORARY TABLE noPassReimb AS SELECT * FROM ers_reimbursement;

ALTER TABLE noPassReimb DROP COLUMN PASSWORD;
SELECT * FROM noPassReimb;

-- user no pass 
CREATE TEMPORARY TABLE UserNoPass AS SELECT * FROM ers_users;

ALTER TABLE UserNoPass DROP COLUMN PASSWORD;
SELECT * FROM UserNoPass;


SELECT reimb_author FROM ers_reimbursement UNION 
SELECT user_id FROM UserNoPass; 
-- union isn't the solution, back to join

-- create some resolved reimbursement
INSERT INTO ers_reimbursement(reimb_amount, reimb_submitted, reimb_resolved, reimb_description, reimb_author, reimb_resolver, reimb_status_id, reimb_type_id)
VALUES (14000, now(), now(), 'i need some broccoli', 4, 1, 3, 3),
	   (725, now(), now(), 'going to Indiana', 5, 2, 2, 1),
	   (9000, now(), now(), 'can I just have some money? lmao', 5, 2, 3, 4);

-- filter by type
SELECT * FROM ers_reimbursement AS er 
INNER JOIN ers_users AS us ON er.reimb_author = us.user_id
LEFT JOIN ers_users AS us2 ON er.reimb_resolver = us2.user_id
LEFT JOIN ers_reimbursement_status AS stat ON er.reimb_status_id = stat.reimbursement_status_id 
FULL JOIN ers_reimbursement_type AS ty ON er.reimb_type_id = ty.reimbursement_type_id
WHERE er.reimb_type_id = 3;

-- filter by author_id
SELECT * FROM ers_reimbursement AS er 
INNER JOIN ers_users AS us ON er.reimb_author = us.user_id
LEFT JOIN ers_users AS us2 ON er.reimb_resolver = us2.user_id
LEFT JOIN ers_reimbursement_status AS stat ON er.reimb_status_id = stat.reimbursement_status_id 
FULL JOIN ers_reimbursement_type AS ty ON er.reimb_type_id = ty.reimbursement_type_id
WHERE er.reimb_author = 3;

-- see all reimbursements
SELECT * FROM ers_reimbursement AS er 
INNER JOIN ers_users AS us ON er.reimb_author = us.user_id
LEFT JOIN ers_users AS us2 ON er.reimb_resolver = us2.user_id
LEFT JOIN ers_reimbursement_status AS stat ON er.reimb_status_id = stat.reimbursement_status_id 
FULL JOIN ers_reimbursement_type AS ty ON er.reimb_type_id = ty.reimbursement_type_id;

-- just take the password out... when you have more time.












---