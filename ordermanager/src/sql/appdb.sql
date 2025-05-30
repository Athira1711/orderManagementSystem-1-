CREATE DATABASE appdb;
USE appdb;

CREATE TABLE orders (
    orderId INT AUTO_INCREMENT PRIMARY KEY,
    customerName VARCHAR(100) NOT NULL,
    orderDate DATE NOT NULL,
    totalAmount DECIMAL(10,2),
    orderStatus VARCHAR(50) NOT NULL
);

