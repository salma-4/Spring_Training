CREATE DATABASE IF NOT EXISTS employee_management;
USE employee_management;
CREATE TABLE IF NOT EXISTS employees (
    id INT AUTO_INCREMENT PRIMARY KEY,
    name VARCHAR(100) NOT NULL,
    email VARCHAR(100) NOT NULL,
    department VARCHAR(50),
    position VARCHAR(50),
    salary DECIMAL(10, 2)
);
INSERT INTO employees (name, email, department, position, salary) VALUES
('John Doe', 'john@example.com', 'Engineering', 'Software Engineer', 75000.00),
('Jane Smith', 'jane@example.com', 'Marketing', 'Marketing Manager', 85000.00),
('Alice Johnson', 'alice@example.com', 'Human Resources', 'HR Specialist', 60000.00),
('Bob Brown', 'bob@example.com', 'Finance', 'Financial Analyst', 70000.00);

select * from employees
