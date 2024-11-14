USE psira_applications_database;

-- Inserting records into users table
INSERT INTO users (username, password, name, surname, id_number) VALUES
 ('john_doe', 'password123', 'John', 'Doe', '8001011234'),
 ('jane_smith', 'password456', 'Jane', 'Smith', '9102021234'),
 ('mike_jones', 'password789', 'Mike', 'Jones', '8203031234'),
 ('sarah_brown', 'password101', 'Sarah', 'Brown', '8304041234'),
 ('lisa_white', 'password202', 'Lisa', 'White', '8405051234');

-- Inserting records into contact_info table
INSERT INTO contact_info (user_id, email, cellphone, fax, work_phone) VALUES
  (1, 'john.doe@example.com', '0712345678', '0112345678', '0212345678'),
  (2, 'jane.smith@example.com', '0723456789', '0123456789', '0223456789'),
  (3, 'mike.jones@example.com', '0734567890', '0134567890', '0234567890'),
  (4, 'sarah.brown@example.com', '0745678901', '0145678901', '0245678901'),
  (5, 'lisa.white@example.com', '0756789012', '0156789012', '0256789012');

-- Inserting records into addresses table
INSERT INTO addresses (user_id, street_name, street_number, province, city, postal_code) VALUES
 (1, 'Main St', '101', 'Springfield', 'Metropolis', '12345'),
 (2, 'Second St', '202', 'Gotham', 'New Jersey', '54321'),
 (3, 'Third St', '303', 'Smallville', 'Kansas', '67890'),
 (4, 'Fourth St', '404', 'Star City', 'Starling', '98765'),
 (5, 'Fifth St', '505', 'Central City', 'Midland', '24680');

-- Inserting records into applications table
INSERT INTO applications (post_id, user_id, qualification, drivers_license, current_position, current_company, years_in_position, current_salary, total_experience, cv_file) VALUES
 (1, 1, 'DEGREE', TRUE, 'Software Engineer', 'Tech Solutions', 3, 60000.00, 5, 'cv_john_doe.pdf'),
 (2, 2, 'MASTERS', TRUE, 'Project Manager', 'Business Corp', 5, 80000.00, 7, 'cv_jane_smith.pdf'),
 (3, 3, 'DIPLOMA', FALSE, 'Sales Associate', 'Retail Group', 2, 40000.00, 4, 'cv_mike_jones.pdf'),
 (4, 4, 'HONORS', TRUE, 'HR Specialist', 'People Co', 1, 50000.00, 3, 'cv_sarah_brown.pdf'),
 (5, 5, 'PHD', TRUE, 'Data Scientist', 'Analytics Inc', 4, 70000.00, 6, 'cv_lisa_white.pdf');
