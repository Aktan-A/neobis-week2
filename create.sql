CREATE DATABASE IF NOT EXISTS store;
USE store;

CREATE TABLE products(
   product_id INT NOT NULL,
   is_active ENUM('ACTIVE', 'INACTIVE', 'DELETED') NOT NULL,
   name VARCHAR(100) NOT NULL UNIQUE,
   description VARCHAR(250),
   price DECIMAL(19, 4) NOT NULL,
   created_at TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP
);

CREATE TABLE customers(
   customer_id INT NOT NULL,
   first_name VARCHAR(50) NOT NULL,
   last_name VARCHAR(50) NOT NULL,
   address VARCHAR(100) NOT NULL,
   created_at TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP
);

CREATE TABLE transactions(
   transaction_id INT NOT NULL,
   total_price DECIMAL(19, 4) NOT NULL,
   status ENUM('CREATED', 'SUCCESS', 'FAILED', 'REFUNDED', 'ROLLEDBACK') NOT NULL,
   created_at TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP
);

CREATE TABLE orders(
   order_id INT NOT NULL,
   customer_id INT NOT NULL,
   transaction_id INT NOT NULL,
   status ENUM('CREATED', 'SHIPPED', 'COMPLETED', 'CANCELLED'),
   created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP NOT NULL
);

CREATE TABLE order_items(
    order_item_id INT NOT NULL,
    order_id INT NOT NULL,
    product_id INT NOT NULL,
    quantity INT NOT NULL,
    created_at TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP
);
