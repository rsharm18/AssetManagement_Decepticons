DROP TABLE Role;

CREATE TABLE Role(
	role_id INTEGER,
	employee_id INTEGER,
	description VARCHAR(25),
	access_level INTEGER(1),
	PRIMARY key (role_id),
	FOREIGN KEY (employee_id)
		REFERENCES employee(employee_id)
);