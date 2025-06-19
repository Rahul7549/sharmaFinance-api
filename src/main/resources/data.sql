-- 1. Insert into responsible_persons Table
INSERT INTO admins (name, contact_info, created_on, updated_on) 
VALUES 
('Raj Kumar Sharma', 'raj.sharma@gmail.com', CURRENT_TIMESTAMP, CURRENT_TIMESTAMP);

-- 2. Insert into members Table
INSERT INTO members (name, contact_info, responsible_id, status, created_on, updated_on) 
VALUES 
('Raj Kumar Sharma', 'raj.sharma@gmail.com', 1, 'Active', CURRENT_TIMESTAMP, CURRENT_TIMESTAMP),
('Basudev sharma', 'basudev.sharma@gmail.com', 1, 'Active', CURRENT_TIMESTAMP, CURRENT_TIMESTAMP);

-- 3. Insert into payments Table
INSERT INTO payments (member_id, payment_date, amount_paid, fine, created_on, updated_on)
VALUES 
(1, '2025-06-11', 500.00, 5.00, CURRENT_TIMESTAMP, CURRENT_TIMESTAMP),
(2, '2025-06-16', 500.00, 50.00, CURRENT_TIMESTAMP, CURRENT_TIMESTAMP);

-- 4. Insert into loans Table
INSERT INTO loans (member_id, loan_amount, interest_rate, loan_balance, loan_status, created_on, updated_on)
VALUES 
(1, 50000.00, 1.0, 50000.00, 'Approved', CURRENT_TIMESTAMP, CURRENT_TIMESTAMP),
(2, 20000.00, 1.0, 20000.00, 'Approved', CURRENT_TIMESTAMP, CURRENT_TIMESTAMP);


-- 5. Insert into loan_payments Table
INSERT INTO loan_payments (loan_id, payment_date, amount_paid, remaining_balance, created_on, updated_on)
VALUES 
(1, '2025-01-18', 5000.00, 4000.00, CURRENT_TIMESTAMP, CURRENT_TIMESTAMP),
(2, '2025-01-19', 2000.00, 1700.00, CURRENT_TIMESTAMP, CURRENT_TIMESTAMP);
