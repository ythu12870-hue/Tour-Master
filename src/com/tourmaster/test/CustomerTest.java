package com.tourmaster.test;

import com.tourmaster.dao.CustomerDAO;
import com.tourmaster.model.Customer;

public class CustomerTest {

    public static void main(String[] args) {

        // Create Customer object
        Customer customer = new Customer(
                "Ye Win Thu",
                "Male",
                "12/",
                "Latha",
                "N",
                "123456",
                "09123456789",
                "yewinthu@example.com",
                "Mandalay, Myanmar"
        );

        // Create DAO
        CustomerDAO customerDAO = new CustomerDAO();

        // Insert customer
        boolean success = customerDAO.addCustomer(customer);

        if (success) {
            System.out.println("================================");
            System.out.println("Customer added successfully!");
            System.out.println("================================");
        } else {
            System.out.println("================================");
            System.out.println("Failed to add customer!");
            System.out.println("================================");
        }
    }
}