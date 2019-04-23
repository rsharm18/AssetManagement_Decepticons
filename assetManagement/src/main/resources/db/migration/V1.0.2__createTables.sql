---- Change History
----change 1 on 4/20/19 - update in employee table(added department_no column in
---- employee table as requestDetail have department_no associated to emp.) done by Disha 
--
--
--
--CREATE TABLE employee (
--  employee_id Number,
--  first_name varchar(45) DEFAULT NULL,
--  last_name varchar(45) DEFAULT NULL,
--  email varchar(45) DEFAULT NULL,
----  change 1 started
--  department_no Number DEFAULT NULL,
----  change  1 ended 
--  PRIMARY KEY (employee_id)
--) ;
--
--
--CREATE TABLE request (
--  request_id Number,
--  request_type varchar(45) DEFAULT NULL,
--  request_subtype varchar(45) DEFAULT NULL,
--  request_description varchar(100) DEFAULT NULL,
--  request_date Date DEFAULT sysdate,
--  employee_id Number,
--  first_name varchar(45),
--  last_name varchar(45),
--  department_name varchar(30),
--  asset_name varchar(45) DEFAULT NULL,
--  units Number DEFAULT 1,
--  priority Number DEFAULT 5,
--  request_status varchar(15) DEFAULT 'Not Accepted',
--  new_owner_empid Number DEFAULT NULL,
-- -- new_owner_emp_first_name varchar(45) DEFAULT NULL,
--  assigned_to_emp_id Number DEFAULT NULL,
--  assigned_to varchar(45) DEFAULT NULL,
--  assigned_date Date DEFAULT NULL,
--  closed_before Date DEFAULT (SYSDATE + 10),
--  PRIMARY KEY (request_id)
--) ;




-- Change History
--change 1 on 4/20/19 - update in employee table(added department_no column in
-- employee table as requestDetail have department_no associated to emp.) done by Disha 
--change 2 on 4/20/19  - to remove cyclic dependency on employee and department table
--department_manager table created and constrains in department commented out
--change 3 on 4/21/19  - requesttypeemp and requesttypesystemAnalyst table created
-- so can store request types in this and show in drop down list on JSP in future.

--CHNAGE #3 started----
CREATE TABLE requesttypeemp (
	request_type_id Number,
    request_type varchar(45) DEFAULT NULL
  );
  
  CREATE TABLE requesttypesystemanalyst (
	request_type_id Number,
    request_type varchar(45) DEFAULT NULL
  );
  
 ----CHANGE #3 END------------
 
  
  
CREATE TABLE employee (
  employee_id Number,
  first_name varchar(45) DEFAULT NULL,
  last_name varchar(45) DEFAULT NULL,
  email varchar(45) DEFAULT NULL,
--  change 1 started
  department_id Number DEFAULT NULL,
--  change  1 ended 
  PRIMARY KEY (employee_id)
) ;


CREATE TABLE department(
    department_id Number,
    department_name varchar(45) DEFAULT NULL,
    department_manager Number ,
    PRIMARY KEY (department_id)
--change 2 started--
--    CONSTRAINT manager_key
--    FOREIGN KEY (department_manager)
--    REFERENCES employee(employee_id)
--END OF CHANGE 2
); 


--CHANGE 2 STARTED--------
CREATE TABLE department_manager(
department_id Number,
employee_id Number,
PRIMARY KEY(department_id,employee_id),
CONSTRAINT FK_EmpID FOREIGN KEY (employee_id) REFERENCES employee(employee_id),
CONSTRAINT FK_deptID FOREIGN KEY (department_id) REFERENCES department(department_id)
);
--END OF CHANGE 2-------------

CREATE TABLE request (
  request_id Number,
  request_type varchar(45) DEFAULT NULL,
  request_subtype varchar(45) DEFAULT NULL,
  request_description varchar(100) DEFAULT NULL,
  request_date Date DEFAULT sysdate,
  employee_id Number,
  first_name varchar(45),
  last_name varchar(45),
  department_id Number DEFAULT NULL,
  department_name varchar(30),
  asset_name varchar(45) DEFAULT NULL,
  units Number DEFAULT 1,
  priority Number DEFAULT 5,
  request_status varchar(15) DEFAULT 'Not Accepted',
  new_owner_empid Number DEFAULT NULL,
 -- new_owner_emp_first_name varchar(45) DEFAULT NULL,
  assigned_to_emp_id Number DEFAULT NULL,
  assigned_to varchar(45) DEFAULT NULL,
  assigned_date Date DEFAULT NULL,
  closed_before Date DEFAULT (SYSDATE + 10),
  PRIMARY KEY (request_id),
  CONSTRAINT FK_RequestEMP FOREIGN KEY (employee_id) REFERENCES employee(employee_id),
  CONSTRAINT FK_RequestTransTo FOREIGN KEY (new_owner_empid) REFERENCES employee(employee_id),
  CONSTRAINT FK_RequestDeptID FOREIGN KEY (department_id) REFERENCES department(department_id)
  
) ;