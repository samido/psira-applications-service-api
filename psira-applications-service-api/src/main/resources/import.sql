-- This file allow to write SQL commands that will be emitted in test and dev.
-- The commands are commented as their support depends of the database
-- insert into myentity (id, field) values(1, 'field-1');
-- insert into myentity (id, field) values(2, 'field-2');
-- insert into myentity (id, field) values(3, 'field-3');
-- alter sequence myentity_seq restart with 4;

-- CREATE SCHEMA IF NOT EXISTS psira_applications_database;

USE psira_applications_database;

CREATE TABLE users (
   user_id INT AUTO_INCREMENT PRIMARY KEY,
   username VARCHAR(255) NOT NULL UNIQUE,
   password VARCHAR(255) NOT NULL,
   name VARCHAR(255),
   surname VARCHAR(255),
   id_number VARCHAR(20) NOT NULL UNIQUE
);

CREATE TABLE contact_info (
  contact_id INT AUTO_INCREMENT PRIMARY KEY,
  user_id INT NOT NULL,
  email VARCHAR(255) NOT NULL UNIQUE,
  cellphone VARCHAR(15),
  fax VARCHAR(15),
  work_phone VARCHAR(15),
  FOREIGN KEY (user_id) REFERENCES users(user_id) ON DELETE CASCADE
);

CREATE TABLE addresses (
   address_id INT AUTO_INCREMENT PRIMARY KEY,
   user_id INT NOT NULL,
   street_name VARCHAR(255),
   street_number VARCHAR(10),
   town VARCHAR(255),
   city VARCHAR(255),
   postal_code VARCHAR(10),
   FOREIGN KEY (user_id) REFERENCES users(user_id) ON DELETE CASCADE
);

CREATE TABLE applications (
  application_id INT AUTO_INCREMENT PRIMARY KEY,
  post_id INT NOT NULL,
  user_id INT NOT NULL,
  qualification ENUM('Diploma', 'Degree', 'Honors', 'Masters', 'PhD') NOT NULL,
  drivers_license BOOLEAN NOT NULL,
  current_position VARCHAR(255) NOT NULL,
  current_company VARCHAR(255) NOT NULL,
  years_in_position INT NOT NULL CHECK (years_in_position >= 0 AND years_in_position <= 10),
  current_salary DECIMAL(10, 2) NOT NULL,
  total_experience INT NOT NULL CHECK (total_experience >= 0 AND total_experience <= 10),
  cv_file VARCHAR(255) NOT NULL,
  FOREIGN KEY (user_id) REFERENCES users(user_id)
);

INSERT INTO users (username, password, name, surname, id_number) VALUES
     ('jdoe', 'SecurePassword1', 'John', 'Doe', '1234567890'),
     ('asmith', 'SecurePassword2', 'Alice', 'Smith', '0987654321'),
     ('bjackson', 'SecurePassword3', 'Bob', 'Jackson', '5678901234');

INSERT INTO contact_info (user_id, email, cellphone, fax, work_phone) VALUES
  (1, 'john.doe@example.com', '0123456789', '0212345678', '0312345678'),
  (2, 'alice.smith@example.com', '9876543210', '0987654321', '0765432109'),
  (3, 'bob.jackson@example.com', '1234567890', '0123987654', '0456123789');


INSERT INTO addresses (user_id, street_name, street_number, town, city, postal_code) VALUES
 (1, 'Main St', '101', 'Springfield', 'Springfield', '12345'),
 (2, 'Second St', '202', 'Greenville', 'Greenville', '54321'),
 (3, 'Third St', '303', 'Hilltown', 'Hilltown', '67890');


INSERT INTO addresses (user_id, street_name, street_number, town, city, postal_code) VALUES
     (1, 'Main St', '101', 'Springfield', 'Springfield', '12345'),
     (2, 'Second St', '202', 'Greenville', 'Greenville', '54321'),
     (3, 'Third St', '303', 'Hilltown', 'Hilltown', '67890');
