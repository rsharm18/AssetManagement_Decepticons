CREATE TABLE department(
    department_id Number,
    department_name varchar(45) DEFAULT NULL,
    department_manager Number,
    PRIMARY KEY (department_id),
    CONSTRAINT manager_key
        FOREIGN KEY (department_manager)
        REFERENCES employee(employee_id)
);