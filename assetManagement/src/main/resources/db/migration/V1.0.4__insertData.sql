insert into Roles(role_id, role_name, role_access) values(ROLES_ID_SEQ.NEXTVAL,'Employee', 1);
insert into Roles(role_id, role_name, role_access) values(ROLES_ID_SEQ.NEXTVAL,'Manager', 2);
insert into Roles(role_id, role_name, role_access) values(ROLES_ID_SEQ.NEXTVAL,'Admin', 3);
-- inert into Dept table
insert into Departments(department_id, department_name) values(DEPTS_ID_SEQ.NEXTVAL,'Human Resource');
insert into Departments(department_id, department_name) values(DEPTS_ID_SEQ.NEXTVAL,'Information Techologies');
insert into Departments(department_id, department_name) values(DEPTS_ID_SEQ.NEXTVAL,'Network');
insert into Departments(department_id, department_name) values(DEPTS_ID_SEQ.NEXTVAL,'Legal');
INSERT INTO departments (department_id, department_name) VALUES (DEPTS_ID_SEQ.NEXTVAL, 'Boss'); 
INSERT INTO departments (department_id, department_name) VALUES (999, 'Resource Pool');



insert into Employees (employee_id,dept_id,role_id,first_name,last_name,gender,email,hire_date,end_date,phone_number,user_name,dob,salary,ssn_no) values(EMP_ID_SEQ.NEXTVAL,300,202,'Ravi','Sharma','M','sharma.ravi70@gmail.com',to_date('04/12/1986', 'dd/mm/YYYY'),to_date('04/12/2100', 'dd/mm/YYYY'),3125329099,'sha123',to_date('04/12/1986', 'dd/mm/YYYY'),500000,'123-frd-34567');
insert into Employees (employee_id,dept_id,role_id,first_name,last_name,gender,email,hire_date,end_date,phone_number,user_name,dob,salary,ssn_no,reporting_manager) values(EMP_ID_SEQ.NEXTVAL,301,201,'Disha','Patel','F','disha.patel@gmail.com',to_date('04/12/1986', 'dd/mm/YYYY'),to_date('04/12/2100', 'dd/mm/YYYY'),4125328099,'pa123',to_date('04/12/1986', 'dd/mm/YYYY'),90000,'123-frd-3487',100);
insert into Employees (employee_id,dept_id,role_id,first_name,last_name,gender,email,hire_date,end_date,phone_number,user_name,dob,salary,ssn_no,reporting_manager) values(EMP_ID_SEQ.NEXTVAL,300,200,'ryan','D','M','ryan.d@gmail.com',to_date('04/12/1986', 'dd/mm/YYYY'),to_date('04/12/2100', 'dd/mm/YYYY'),455329099,'ryn123',to_date('04/12/1986', 'dd/mm/YYYY'),80000,'123-frd-3467',100);
insert into Employees (employee_id,dept_id,role_id,first_name,last_name,gender,email,hire_date,end_date,phone_number,user_name,dob,salary,ssn_no,reporting_manager) values(EMP_ID_SEQ.NEXTVAL,303,200,'Juan','P','M','Juan.p@gmail.com',to_date('04/12/1986', 'dd/mm/YYYY'),to_date('04/12/2100', 'dd/mm/YYYY'),6725329099,'jua123',to_date('04/12/1986', 'dd/mm/YYYY'),100000,'123-frd-34097',101);
insert into Employees (employee_id,dept_id,role_id,first_name,last_name,gender,email,hire_date,end_date,phone_number,user_name,dob,salary,ssn_no,reporting_manager) values(EMP_ID_SEQ.NEXTVAL,304,200,'Abhi','T','M','abhi.t@gmail.com',to_date('04/12/1986', 'dd/mm/YYYY'),to_date('04/12/2100', 'dd/mm/YYYY'),0985329099,'t123',to_date('04/12/1986', 'dd/mm/YYYY'),120000,'123-frd-34167',102);

insert into Employees (employee_id,dept_id,role_id,first_name,last_name,gender,email,hire_date,end_date,phone_number,user_name,dob,salary,ssn_no,reporting_manager) values(EMP_ID_SEQ.NEXTVAL,999,200,'Kuan','a','M','kuan.a@gmail.com',to_date('04/12/1986', 'dd/mm/YYYY'),to_date('04/12/2100', 'dd/mm/YYYY'),6725329099,'Kuan123',to_date('04/12/1986', 'dd/mm/YYYY'),100000,'123-frd-34010',101);
insert into Employees (employee_id,dept_id,role_id,first_name,last_name,gender,email,hire_date,end_date,phone_number,user_name,dob,salary,ssn_no,reporting_manager) values(EMP_ID_SEQ.NEXTVAL,999,200,'Jen','g','F','Jen.g@gmail.com',to_date('04/12/1986', 'dd/mm/YYYY'),to_date('04/12/2100', 'dd/mm/YYYY'),3123229099,'Jen123',to_date('04/12/1986', 'dd/mm/YYYY'),100000,'123-frd-34011',101);
insert into Employees (employee_id,dept_id,role_id,first_name,last_name,gender,email,hire_date,end_date,phone_number,user_name,dob,salary,ssn_no,reporting_manager) values(EMP_ID_SEQ.NEXTVAL,999,200,'Ben','a','M','Ben.a@gmail.com',to_date('04/12/1986', 'dd/mm/YYYY'),to_date('04/12/2100', 'dd/mm/YYYY'),1423229099,'Ben123',to_date('04/12/1986', 'dd/mm/YYYY'),100000,'123-frd-34012',101);
insert into Employees (employee_id,dept_id,role_id,first_name,last_name,gender,email,hire_date,end_date,phone_number,user_name,dob,salary,ssn_no,reporting_manager) values(EMP_ID_SEQ.NEXTVAL,999,200,'Jeff','V','M','Jeff.V@gmail.com',to_date('04/12/1986', 'dd/mm/YYYY'),to_date('04/12/2100', 'dd/mm/YYYY'),1235329099,'Jeff123',to_date('04/12/1986', 'dd/mm/YYYY'),100000,'123-frd-34013',101);
insert into Employees (employee_id,dept_id,role_id,first_name,last_name,gender,email,hire_date,end_date,phone_number,user_name,dob,salary,ssn_no,reporting_manager) values(EMP_ID_SEQ.NEXTVAL,999,200,'Jack','E','M','Jack.E@gmail.com',to_date('04/12/1986', 'dd/mm/YYYY'),to_date('04/12/2100', 'dd/mm/YYYY'),6712329099,'Jack123',to_date('04/12/1986', 'dd/mm/YYYY'),100000,'123-frd-34014',101);
insert into Employees (employee_id,dept_id,role_id,first_name,last_name,gender,email,hire_date,end_date,phone_number,user_name,dob,salary,ssn_no,reporting_manager) values(EMP_ID_SEQ.NEXTVAL,999,200,'Alex','E','F','Alex.e@gmail.com',to_date('04/12/1986', 'dd/mm/YYYY'),to_date('04/12/2100', 'dd/mm/YYYY'),6725312399,'Alex123',to_date('04/12/1986', 'dd/mm/YYYY'),100000,'123-frd-34015',101);
insert into Employees (employee_id,dept_id,role_id,first_name,last_name,gender,email,hire_date,end_date,phone_number,user_name,dob,salary,ssn_no,reporting_manager) values(EMP_ID_SEQ.NEXTVAL,999,200,'Mike','K','M','Mike.k@gmail.com',to_date('04/12/1986', 'dd/mm/YYYY'),to_date('04/12/2100', 'dd/mm/YYYY'),6123329099,'Mike123',to_date('04/12/1986', 'dd/mm/YYYY'),100000,'123-frd-34016',101);
insert into Employees (employee_id,dept_id,role_id,first_name,last_name,gender,email,hire_date,end_date,phone_number,user_name,dob,salary,ssn_no,reporting_manager) values(EMP_ID_SEQ.NEXTVAL,999,200,'Donald','D','M','Donald.d@gmail.com',to_date('04/12/1986', 'dd/mm/YYYY'),to_date('04/12/2100', 'dd/mm/YYYY'),6725123099,'Donald123',to_date('04/12/1986', 'dd/mm/YYYY'),100000,'123-frd-34017',101);
insert into Employees (employee_id,dept_id,role_id,first_name,last_name,gender,email,hire_date,end_date,phone_number,user_name,dob,salary,ssn_no,reporting_manager) values(EMP_ID_SEQ.NEXTVAL,999,200,'Rose','a','F','Rose.a@gmail.com',to_date('04/12/1986', 'dd/mm/YYYY'),to_date('04/12/2100', 'dd/mm/YYYY'),5675329099,'Rose123',to_date('04/12/1986', 'dd/mm/YYYY'),100000,'123-frd-34018',101);
insert into Employees (employee_id,dept_id,role_id,first_name,last_name,gender,email,hire_date,end_date,phone_number,user_name,dob,salary,ssn_no,reporting_manager) values(EMP_ID_SEQ.NEXTVAL,999,200,'Wendy','J','F','Wendy.j@gmail.com',to_date('04/12/1986', 'dd/mm/YYYY'),to_date('04/12/2100', 'dd/mm/YYYY'),6725567099,'Wendy123',to_date('04/12/1986', 'dd/mm/YYYY'),100000,'123-frd-34019',101);


--commit;


INSERT INTO department_manager(deptmanager_id, department_id, employee_id) VALUES(DEPTMAN_ID_SEQ.NEXTVAL, 302, 100);
INSERT INTO department_manager(deptmanager_id, department_id, employee_id) VALUES(DEPTMAN_ID_SEQ.NEXTVAL, 301, 101);
INSERT INTO department_manager(deptmanager_id, department_id, employee_id) VALUES(DEPTMAN_ID_SEQ.NEXTVAL, 303, 102);
INSERT INTO department_manager(deptmanager_id, department_id, employee_id) VALUES(DEPTMAN_ID_SEQ.NEXTVAL, 302, 103);
INSERT INTO department_manager(deptmanager_id, department_id, employee_id) VALUES(DEPTMAN_ID_SEQ.NEXTVAL, 300, 103);
--CHANGE # 3 STARTED
INSERT INTO PRIORITY VALUES (1,'High');
INSERT INTO PRIORITY VALUES (2,'Medium');
INSERT INTO PRIORITY VALUES (3,'Low');


INSERT INTO REQUEST(REQUEST_ID,REQUEST_TYPE,REQUEST_SUBTYPE,REQUEST_DESCRIPTION,REQUEST_DATE,EMPLOYEE_ID,FIRST_NAME,LAST_NAME,DEPARTMENT_ID,DEPARTMENT_NAME,ASSET_NAME,UNITS,PRIORITY,REQUEST_STATUS,ASSIGNED_TO_EMP_ID,ASSIGNED_TO,ASSIGNED_DATE,CLOSED_BEFORE)
VALUES (REQ_ID_SEQ.NEXTVAL,'Hardware','Motherboard','Motherboard Damaged By Water',TO_DATE('17/12/2015', 'DD/MM/YYYY'),101,'DISHA','PATEL',301,'Information Techologies','Motherboard',1,2,'New',104,'Abhi T',TO_DATE('19/12/2015', 'DD/MM/YYYY'),TO_DATE('29/12/2015', 'DD/MM/YYYY'));

INSERT INTO REQUEST(REQUEST_ID,REQUEST_TYPE,REQUEST_SUBTYPE,REQUEST_DESCRIPTION,REQUEST_DATE,EMPLOYEE_ID,FIRST_NAME,LAST_NAME,DEPARTMENT_ID,DEPARTMENT_NAME,ASSET_NAME,UNITS,PRIORITY,REQUEST_STATUS)
VALUES (REQ_ID_SEQ.NEXTVAL,'Help','Cabinet Key Missing','Cabinet Key Missing',TO_DATE('11/05/2018', 'DD/MM/YYYY'),101,'DISHA','PATEL',301,'Information Techologies','Key Stolen',1,2,'New');

INSERT INTO REQUEST(REQUEST_ID,REQUEST_TYPE,REQUEST_SUBTYPE,REQUEST_DESCRIPTION,REQUEST_DATE,EMPLOYEE_ID,FIRST_NAME,LAST_NAME,DEPARTMENT_ID,DEPARTMENT_NAME,ASSET_NAME,UNITS,PRIORITY,REQUEST_STATUS,CLOSED_BEFORE)
VALUES (REQ_ID_SEQ.NEXTVAL,'Quality','Quality Check For AC','Quality Check For AC',TO_DATE('10/11/2019', 'DD/MM/YYYY'),102,'ryan','D',300,'Human Resource','Checking Only',0,3,'New',TO_DATE('13/11/2019', 'DD/MM/YYYY'));

INSERT INTO REQUEST(REQUEST_ID,REQUEST_TYPE,REQUEST_SUBTYPE,REQUEST_DESCRIPTION,REQUEST_DATE,EMPLOYEE_ID,FIRST_NAME,LAST_NAME,DEPARTMENT_ID,DEPARTMENT_NAME,ASSET_NAME,UNITS,PRIORITY,REQUEST_STATUS,CLOSED_BEFORE)
VALUES (REQ_ID_SEQ.NEXTVAL,'Software','System Update','Update windows System from 7 to 10',TO_DATE('13/06/2019', 'DD/MM/YYYY'),101,'DISHA','PATEL',301,'Information Techologies','System Update',1,3,'New',TO_DATE('20/06/2013', 'DD/MM/YYYY'));

INSERT INTO REQUEST(REQUEST_ID,REQUEST_TYPE,REQUEST_SUBTYPE,REQUEST_DESCRIPTION,REQUEST_DATE,EMPLOYEE_ID,FIRST_NAME,LAST_NAME,DEPARTMENT_ID,DEPARTMENT_NAME,ASSET_NAME,UNITS,PRIORITY,REQUEST_STATUS,ASSIGNED_TO_EMP_ID,ASSIGNED_TO,ASSIGNED_DATE,CLOSED_BEFORE)
VALUES (REQ_ID_SEQ.NEXTVAL,'Stolen','Laptop Bag','Laptop Bag got stolen from airport checking',TO_DATE('15/06/2019', 'DD/MM/YYYY'),104,'Abhi','T',304,'Boss','Laptop Bag',1,2,'In-Progress',103,'Juan P',TO_DATE('16/06/2019', 'DD/MM/YYYY'),TO_DATE('26/06/2019', 'DD/MM/YYYY'));

INSERT INTO REQUEST(REQUEST_ID,REQUEST_TYPE,REQUEST_SUBTYPE,REQUEST_DESCRIPTION,REQUEST_DATE,EMPLOYEE_ID,FIRST_NAME,LAST_NAME,DEPARTMENT_ID,DEPARTMENT_NAME,ASSET_NAME,UNITS,PRIORITY,REQUEST_STATUS,ASSIGNED_TO_EMP_ID,ASSIGNED_TO,ASSIGNED_DATE,CLOSED_BEFORE)
VALUES (REQ_ID_SEQ.NEXTVAL,'Help','Keyboard Replacement','Replacement Of Keyboard',TO_DATE('27/05/2019', 'DD/MM/YYYY'),100,'Ravi','Sharma',302,'Network','Keyboard Replacement',1,2,'Completed',104,'Abhi T',TO_DATE('28/05/2019', 'DD/MM/YYYY'),TO_DATE('31/05/2019', 'DD/MM/YYYY'));

INSERT INTO REQUEST(REQUEST_ID,REQUEST_TYPE,REQUEST_SUBTYPE,REQUEST_DESCRIPTION,REQUEST_DATE,EMPLOYEE_ID,FIRST_NAME,LAST_NAME,DEPARTMENT_ID,DEPARTMENT_NAME,ASSET_NAME,UNITS,PRIORITY,REQUEST_STATUS,ASSIGNED_TO_EMP_ID,ASSIGNED_TO,ASSIGNED_DATE,CLOSED_BEFORE)
VALUES (REQ_ID_SEQ.NEXTVAL,'New','Laptops','New Laptop For Upcoming xyz Project',TO_DATE('11/06/2019', 'DD/MM/YYYY'),100,'Ravi','Sharma',302,'Network','New Laptops',25,1,'Pending',303,'Juan P',TO_DATE('12/06/2019', 'DD/MM/YYYY'),TO_DATE('16/06/2019', 'DD/MM/YYYY'));

--commit;

INSERT INTO Inventory_Info(inventory_id, name_Of_Asset, vendor_id, asset_status, serial_no, purchase_date, vendor_name) values (INV_ID_SEQ.NEXTVAL,'HP Laptop', 801,'Active',156432, to_date('04/12/2006', 'dd/mm/YYYY'),'Abhi');	
INSERT INTO Inventory_Info(inventory_id, name_Of_Asset, vendor_id, asset_status, serial_no, purchase_date, vendor_name) values (INV_ID_SEQ.NEXTVAL,'Amazon Ec2 4GB', 801,'Active',156433,to_date('09/09/2016', 'dd/mm/YYYY'),'Disha');




INSERT INTO Inventory(inventory_id, name_Of_Asset, employee_id, department_id, allocation_status, auth_manager) values (INV_ID_SEQ.NEXTVAL,'HP Laptop', 101,2,'Pending','Abhi');	
INSERT INTO Inventory(inventory_id, name_Of_Asset, employee_id, department_id, allocation_status, auth_manager) values (INV_ID_SEQ.NEXTVAL,'Amazon Ec2 4GB', 100,3,'Allocated','Disha');


