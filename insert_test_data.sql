INSERT INTO products(name, description, price) VALUES ('Toothbrush', 'To brush teeth', 5.55);
INSERT INTO customers(first_name, last_name, address) VALUES ('John', 'Doe', 'This Ave 85');
INSERT INTO transactions(total_price, status) VALUES (11.1, 'SUCCESS');
INSERT INTO orders(customer_id, transaction_id, status) VALUES (1, 1, 'COMPLETED');
INSERT INTO order_items(order_id, product_id, quantity) VALUES (1, 1, 3);

SELECT * FROM products;
SELECT * FROM customers;
SELECT * FROM transactions;
SELECT * FROM orders;
SELECT * FROM order_items;