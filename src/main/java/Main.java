import db_util.DBUtil;
import crud.CustomerCrud;
import pojo.Customer;

import java.sql.Connection;

public class Main {
    public static void main(String[] args) {
        Connection connection = DBUtil.getConnection();
        CustomerCrud c_crud = new CustomerCrud(connection);
        // Create customer
        c_crud.create("George", "Washington", "Test street");

        // Get customer
        Customer customer = c_crud.getById(1);
        System.out.printf("Full name: %s %s. Address: %s", customer.getFirstName(), customer.getLastName(), customer.getAddress());

        // Delete customer
        c_crud.deleteById(1);
        DBUtil.closeConnection();

        // Update customer address
        c_crud.updateAddressById(2, "Updated test street");
    }
}
