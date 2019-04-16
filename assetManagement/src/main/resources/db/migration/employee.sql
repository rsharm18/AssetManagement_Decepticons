DROP SEQUENCE EMP_ID_SEQ;

CREATE SEQUENCE EMP_ID_SEQ INCREMENT BY 1 START WITH 1005 MAXVALUE 9999999999999999999999999999 MINVALUE 1005 CACHE 20;

DROP TABLE employee;

CREATE TABLE employee (
  employee_id Number,
  first_name varchar(45) DEFAULT NULL,
  last_name varchar(45) DEFAULT NULL,
  email varchar(45) DEFAULT NULL,
  PRIMARY KEY (employee_id)
) ;

--
-- Data for table 'employee'
--

INSERT INTO employee( EMPLOYEE_ID, FIRST_NAME , LAST_NAME, EMAIL) VALUES	(1000,'Leslie','Andrews','leslie@c.com');
INSERT INTO employee( EMPLOYEE_ID, FIRST_NAME , LAST_NAME, EMAIL)  VALUES	(1001,'Emma','Baumgarten','emma@c.com');
INSERT INTO employee( EMPLOYEE_ID,FIRST_NAME , LAST_NAME, EMAIL)  VALUES	(1002,'Avani','Gupta','avani@c.com');
INSERT INTO employee( EMPLOYEE_ID,FIRST_NAME , LAST_NAME, EMAIL)  VALUES	(1003,'Yuri','Petrov','yuri@c.com');
INSERT INTO employee( EMPLOYEE_ID,FIRST_NAME , LAST_NAME, EMAIL)  VALUES	(1004,'Juan','Vega','juan@c.com');

commit;

