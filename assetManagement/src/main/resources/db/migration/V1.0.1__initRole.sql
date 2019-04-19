DROP TABLE Role;

CREATE TABLE Role(
	role_id Number,
	employee_id Number,
	description VARCHAR(25),
	access_level Number,
	PRIMARY key (role_id),
	FOREIGN KEY (employee_id)
		REFERENCES employee(employee_id)
);