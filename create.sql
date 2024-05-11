CREATE DATABASE IF NOT EXISTS store;
USE store;

-- Table: products
CREATE TABLE products(
   product_id INT NOT NULL,
   status ENUM('ACTIVE', 'INACTIVE', 'DELETED') NOT NULL,
   name VARCHAR(100) NOT NULL UNIQUE,
   description VARCHAR(250),
   price DECIMAL(19, 4) NOT NULL,
   created_at TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP
);

-- Table: customers
CREATE TABLE customers(
   customer_id INT NOT NULL,
   first_name VARCHAR(50) NOT NULL,
   last_name VARCHAR(50) NOT NULL,
   address VARCHAR(100) NOT NULL,
   created_at TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP
);

-- Table: transactions
CREATE TABLE transactions(
   transaction_id INT NOT NULL,
   total_price DECIMAL(19, 4) NOT NULL,
   status ENUM('CREATED', 'SUCCESS', 'FAILED', 'REFUNDED', 'ROLLEDBACK') NOT NULL,
   created_at TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP
);

-- Table: orders
CREATE TABLE orders(
   order_id INT NOT NULL,
   customer_id INT NOT NULL,
   transaction_id INT,
   status ENUM('CREATED', 'SHIPPED', 'COMPLETED', 'CANCELLED'),
   created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP NOT NULL
);

-- Table: order_items
CREATE TABLE order_items(
    order_item_id INT NOT NULL,
    order_id INT NOT NULL,
    product_id INT NOT NULL,
    quantity INT NOT NULL,
    created_at TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP
);

-- Add primary keys and foreign key constraints
ALTER TABLE products MODIFY product_id INT AUTO_INCREMENT PRIMARY KEY;

ALTER TABLE customers MODIFY customer_id INT AUTO_INCREMENT PRIMARY KEY;

ALTER TABLE transactions MODIFY transaction_id INT AUTO_INCREMENT PRIMARY KEY;

ALTER TABLE orders MODIFY order_id INT AUTO_INCREMENT PRIMARY KEY;
ALTER TABLE orders ADD CONSTRAINT fk_customer FOREIGN KEY (customer_id) REFERENCES customers(customer_id) ON DELETE RESTRICT;
ALTER TABLE orders ADD CONSTRAINT fk_transaction FOREIGN KEY (transaction_id) REFERENCES transactions(transaction_id) ON DELETE RESTRICT;

ALTER TABLE order_items MODIFY order_item_id INT AUTO_INCREMENT PRIMARY KEY;
ALTER TABLE order_items ADD CONSTRAINT fk_order FOREIGN KEY (order_id) REFERENCES orders(order_id) ON DELETE RESTRICT;
ALTER TABLE order_items ADD CONSTRAINT fk_product FOREIGN KEY (product_id) REFERENCES products(product_id) ON DELETE RESTRICT;