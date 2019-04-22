
-- inert into Roles table
insert into Roles(role_id, role_name) values(ROLES_ID_SEQ.NEXTVAL,'Employee');
insert into Roles(role_id, role_name) values(ROLES_ID_SEQ.NEXTVAL,'Manager');
insert into Roles(role_id, role_name) values(ROLES_ID_SEQ.NEXTVAL,'HR');

-- inert into Dept table
insert into Departments(dept_id, dept_name) values(DEPTS_ID_SEQ.NEXTVAL,'HR');
insert into Departments(dept_id, dept_name) values(DEPTS_ID_SEQ.NEXTVAL,'IT');
insert into Departments(dept_id, dept_name) values(DEPTS_ID_SEQ.NEXTVAL,'Network');
insert into Departments(dept_id, dept_name) values(DEPTS_ID_SEQ.NEXTVAL,'Law');
insert into Departments(dept_id, dept_name) values(DEPTS_ID_SEQ.NEXTVAL,'Immigration');

-- inert into employee table
--insert into Employees (employee_id,dept_id,role_id,first_name,last_name,email,hire_date,end_date,phone_number) values(EMP_ID_SEQ.NEXTVAL,300,200,'Ravi','Sharma','sharma.ravi70@gmail.com','1982-04-12','2100-04-12',3125329099);
--insert into Employees (employee_id,dept_id,role_id,first_name,last_name,email,hire_date,end_date,phone_number) values(EMP_ID_SEQ.NEXTVAL,301,200,'Disha','Patel','disha.patel@gmail.com','1982-04-12','2100-04-12',4125328099);
--insert into Employees (employee_id,dept_id,role_id,first_name,last_name,email,hire_date,end_date,phone_number) values(EMP_ID_SEQ.NEXTVAL,300,200,'ryan','D','ryan.d@gmail.com','1982-04-12','2100-04-12',455329099);
--insert into Employees (employee_id,dept_id,role_id,first_name,last_name,email,hire_date,end_date,phone_number) values(EMP_ID_SEQ.NEXTVAL,303,200,'Juan','P','Juan.p@gmail.com','1982-04-12','2100-04-12',6725329099);
--insert into Employees (employee_id,dept_id,role_id,first_name,last_name,email,hire_date,end_date,phone_number) values(EMP_ID_SEQ.NEXTVAL,304,200,'Abhi','T','abhi.t@gmail.com','1982-04-12','2100-04-12',0985329099);

insert into Employees (employee_id,dept_id,role_id,first_name,last_name,email,hire_date,end_date,phone_number,user_name) values(EMP_ID_SEQ.NEXTVAL,300,200,'Ravi','Sharma','sharma.ravi70@gmail.com',to_date('04/12/1986', 'dd/mm/YYYY'),to_date('04/12/2100', 'dd/mm/YYYY'),3125329099,'rsha123');
insert into Employees (employee_id,dept_id,role_id,first_name,last_name,email,hire_date,end_date,phone_number,user_name) values(EMP_ID_SEQ.NEXTVAL,301,200,'Disha','Patel','disha.patel@gmail.com',to_date('04/12/1986', 'dd/mm/YYYY'),to_date('04/12/2100', 'dd/mm/YYYY'),4125328099,'pa123');
insert into Employees (employee_id,dept_id,role_id,first_name,last_name,email,hire_date,end_date,phone_number,user_name) values(EMP_ID_SEQ.NEXTVAL,300,200,'ryan','D','ryan.d@gmail.com',to_date('04/12/1986', 'dd/mm/YYYY'),to_date('04/12/2100', 'dd/mm/YYYY'),455329099,'ryn123');
insert into Employees (employee_id,dept_id,role_id,first_name,last_name,email,hire_date,end_date,phone_number,user_name) values(EMP_ID_SEQ.NEXTVAL,303,200,'Juan','P','Juan.p@gmail.com',to_date('04/12/1986', 'dd/mm/YYYY'),to_date('04/12/2100', 'dd/mm/YYYY'),6725329099,'jua123');
insert into Employees (employee_id,dept_id,role_id,first_name,last_name,email,hire_date,end_date,phone_number,user_name) values(EMP_ID_SEQ.NEXTVAL,304,200,'Abhi','T','abhi.t@gmail.com',to_date('04/12/1986', 'dd/mm/YYYY'),to_date('04/12/2100', 'dd/mm/YYYY'),0985329099,'t123');


--INSERT INTO employee( EMPLOYEE_ID, FIRST_NAME , LAST_NAME, EMAIL) VALUES	(EMP_ID_SEQ.NEXTVAL,'Leslie','Andrews','leslie@c.com');
--INSERT INTO employee( EMPLOYEE_ID, FIRST_NAME , LAST_NAME, EMAIL)  VALUES	(EMP_ID_SEQ.NEXTVAL,'Emma','Baumgarten','emma@c.com');
--INSERT INTO employee( EMPLOYEE_ID,FIRST_NAME , LAST_NAME, EMAIL)  VALUES	(EMP_ID_SEQ.NEXTVAL,'Avani','Gupta','avani@c.com');
--INSERT INTO employee( EMPLOYEE_ID,FIRST_NAME , LAST_NAME, EMAIL)  VALUES	(EMP_ID_SEQ.NEXTVAL,'Yuri','Petrov','yuri@c.com');
--INSERT INTO employee( EMPLOYEE_ID,FIRST_NAME , LAST_NAME, EMAIL)  VALUES	(EMP_ID_SEQ.NEXTVAL,'Juan','Vega','juan@c.com');

--commit;

