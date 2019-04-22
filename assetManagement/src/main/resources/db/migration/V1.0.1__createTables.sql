
CREATE SEQUENCE EMP_ID_SEQ INCREMENT BY 1 START WITH 100 MAXVALUE 99999 MINVALUE 100 CACHE 20;
CREATE SEQUENCE ROLES_ID_SEQ INCREMENT BY 1 START WITH 200 MAXVALUE 99999 MINVALUE 200 CACHE 20;
CREATE SEQUENCE DEPTS_ID_SEQ INCREMENT BY 1 START WITH 300 MAXVALUE 99999 MINVALUE 300 CACHE 20;

create Table Roles(
role_id Number not null,
role_name varchar(50),
primary key (role_id)
);

create Table Departments(
dept_id Number not null,
dept_name varchar(50),
primary key (dept_id)
);


CREATE TABLE Employees (
  employee_id Number not null,
  dept_id Number default 300,
  role_id Number default 200,
  
  first_name varchar(45) DEFAULT NULL,
  last_name varchar(45) DEFAULT NULL,
  email varchar(45) DEFAULT NULL,
  
--  hire_date date DEFAULT '1986-04-12',
--  end_date date DEFAULT '2140-04-12',
  
  hire_date date DEFAULT to_date('04-12-1986', 'dd/mm/YYYY'),
  end_date date DEFAULT to_date('04-12-2140', 'dd/mm/YYYY') ,
  
  phone_number VARCHAR2(20) DEFAULT '00000000',
  salary Number DEFAULT 190000,
 
  user_name VARCHAR2(20) not null,
  --password VARCHAR2(20) not null,
  
  PRIMARY KEY (employee_id , user_name)
);


