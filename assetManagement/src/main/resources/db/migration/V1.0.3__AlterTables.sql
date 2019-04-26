
Alter Table Employees 
 ADD FOREIGN KEY (role_id) REFERENCES Roles(role_id);

Alter Table Employees 
 ADD FOREIGN KEY (dept_id) REFERENCES Departments(department_id);


