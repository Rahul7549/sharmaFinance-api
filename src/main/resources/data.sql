-- 1. Insert into responsible_persons Table
INSERT INTO responsible_persons (name, contact_info, created_on, updated_on) 
VALUES 
('John Doe', 'john.doe@example.com', CURRENT_TIMESTAMP, CURRENT_TIMESTAMP),
('Jane Smith', 'jane.smith@example.com', CURRENT_TIMESTAMP, CURRENT_TIMESTAMP),
('Mike Johnson', 'mike.johnson@example.com', CURRENT_TIMESTAMP, CURRENT_TIMESTAMP);

-- 2. Insert into members Table
INSERT INTO members (name, contact_info, responsible_id, status, created_on, updated_on) 
VALUES 
('Alice Brown', 'alice.brown@example.com', 1, 'Active', CURRENT_TIMESTAMP, CURRENT_TIMESTAMP),
('Bob White', 'bob.white@example.com', 2, 'Active', CURRENT_TIMESTAMP, CURRENT_TIMESTAMP),
('Charlie Green', 'charlie.green@example.com', 3, 'Active', CURRENT_TIMESTAMP, CURRENT_TIMESTAMP);

-- 3. Insert into payments Table
INSERT INTO payments (member_id, payment_date, amount_paid, fine, created_on, updated_on)
VALUES 
(1, '2025-01-15', 200.00, 5.00, CURRENT_TIMESTAMP, CURRENT_TIMESTAMP),
(2, '2025-01-16', 150.00, 0.00, CURRENT_TIMESTAMP, CURRENT_TIMESTAMP),
(3, '2025-01-17', 300.00, 10.00, CURRENT_TIMESTAMP, CURRENT_TIMESTAMP);

-- 4. Insert into loans Table
INSERT INTO loans (member_id, loan_amount, interest_rate, loan_balance, loan_status, created_on, updated_on)
VALUES 
(1, 5000.00, 5.0, 4500.00, 'Approved', CURRENT_TIMESTAMP, CURRENT_TIMESTAMP),
(2, 2000.00, 3.0, 1900.00, 'Pending', CURRENT_TIMESTAMP, CURRENT_TIMESTAMP),
(3, 3000.00, 4.5, 2900.00, 'Approved', CURRENT_TIMESTAMP, CURRENT_TIMESTAMP);

-- 5. Insert into loan_payments Table
INSERT INTO loan_payments (loan_id, payment_date, amount_paid, remaining_balance, created_on, updated_on)
VALUES 
(1, '2025-01-18', 500.00, 4000.00, CURRENT_TIMESTAMP, CURRENT_TIMESTAMP),
(2, '2025-01-19', 200.00, 1700.00, CURRENT_TIMESTAMP, CURRENT_TIMESTAMP),
(3, '2025-01-20', 700.00, 2200.00, CURRENT_TIMESTAMP, CURRENT_TIMESTAMP);
