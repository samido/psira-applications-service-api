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
   id_number VARCHAR(20) NOT NULL UNIQUE,
   cv_file LONGTEXT
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
   province VARCHAR(255),
   city VARCHAR(255),
   postal_code VARCHAR(10),
   FOREIGN KEY (user_id) REFERENCES users(user_id) ON DELETE CASCADE
);
CREATE TABLE applications (
  application_id INT AUTO_INCREMENT PRIMARY KEY,
  post_id INT NOT NULL,
  user_id INT NOT NULL,
  qualification ENUM('DIPLOMA', 'DEGREE', 'HONORS', 'MASTERS', 'PHD') NOT NULL,
  drivers_license BOOLEAN NOT NULL,
  current_position VARCHAR(255) NOT NULL,
  current_company VARCHAR(255) NOT NULL,
  years_in_position INT NOT NULL CHECK (years_in_position >= 0 AND years_in_position <= 10),
  current_salary DECIMAL(10, 2) NOT NULL,
  total_experience INT NOT NULL CHECK (total_experience >= 0 AND total_experience <= 10),
  previous_position VARCHAR(255) NOT NULL,
  previous_company VARCHAR(255) NOT NULL,
  period_from DATE NOT NULL,
  period_to DATE NOT NULL,
  FOREIGN KEY (user_id) REFERENCES users(user_id)
);
