CREATE DATABASE atm_system;

USE atm_system;

CREATE TABLE accounts (
    customer_number INT PRIMARY KEY,
    pin INT NOT NULL,
    current_balance DOUBLE DEFAULT 0,
    saving_balance DOUBLE DEFAULT 0
);

INSERT INTO accounts VALUES
(123456,1111,5000,3000),
(222222,2222,8000,4000),
(333333,3333,10000,2000),
(444444,4444,6000,3000);

CREATE TABLE transactions (
    id INT AUTO_INCREMENT PRIMARY KEY,
    customer_number INT,
    account_type VARCHAR(20),
    transaction_type VARCHAR(20),
    amount DOUBLE,
    transaction_time TIMESTAMP DEFAULT CURRENT_TIMESTAMP
);
