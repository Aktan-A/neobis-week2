package crud;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.ResultSet;
import java.time.LocalDateTime;

import db_util.DBUtil;
import pojo.Customer;

public class CustomerCrud {
    private Connection conn;

    public CustomerCrud() {
        conn = DBUtil.getConnection();
    }

    public CustomerCrud(Connection connection) {
        conn = connection;
    }

    public void create(String firstName, String lastName, String address) {
        try {
            PreparedStatement stmt = conn.prepareStatement("INSERT INTO customers(first_name, last_name, address) VALUES (?, ?, ?)");
            stmt.setString(1, firstName);
            stmt.setString(2, lastName);
            stmt.setString(3, address);
            stmt.execute();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public Customer getById(int id) {
        Customer customer = null;
        try {
            PreparedStatement stmt = conn.prepareStatement("SELECT * FROM customers WHERE customer_id = ?");
            stmt.setInt(1, id);
            ResultSet result = stmt.executeQuery();
            result.next();
            customer = new Customer(result.getLong(1), result.getString(2), result.getString(3), result.getString(4), result.getTimestamp(5).toLocalDateTime());
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return customer;
    }

    public void deleteById(int id) {
        try {
            PreparedStatement stmt = conn.prepareStatement("DELETE FROM customers WHERE customer_id = ?");
            stmt.setInt(1, id);
            stmt.execute();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void updateAddressById(int id, String address) {
        try {
            PreparedStatement stmt = conn.prepareStatement("UPDATE customers SET address = ? WHERE customer_id = ?");
            stmt.setString(1, address);
            stmt.setInt(2, id);
            stmt.execute();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
