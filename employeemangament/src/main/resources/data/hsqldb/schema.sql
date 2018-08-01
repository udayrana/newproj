DROP TABLE employee if EXISTS;
CREATE TABLE employee (
  emp_id INT NOT NULL AUTO_INCREMENT,
  user_name VARCHAR(45) NULL,
  password VARCHAR(45) NULL,
  full_name VARCHAR(45) NULL,
  email_id VARCHAR(100) NULL,
  date_of_birth DATE NULL,
  gender VARCHAR(45) NULL,
  security_question VARCHAR(100) NULL,
  security_answer VARCHAR(100) NULL,
  PRIMARY KEY (emp_id));