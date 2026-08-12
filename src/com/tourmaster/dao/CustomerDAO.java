package com.tourmaster.dao;

import com.tourmaster.config.DatabaseConnection;
import com.tourmaster.model.Customer;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class CustomerDAO {

    // =========================================================
    // CREATE - Add a new customer
    // =========================================================

    public boolean addCustomer(Customer customer) {

        String sql = """
                INSERT INTO customers (
                    full_name,
                    gender,
                    nrc_state_code,
                    nrc_township_code,
                    nrc_type,
                    nrc_number,
                    phone,
                    email,
                    address
                )
                VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?)
                """;

        try (
            Connection connection = DatabaseConnection.getConnection();
            PreparedStatement statement = connection.prepareStatement(sql)
        ) {

            statement.setString(1, customer.getFullName());
            statement.setString(2, customer.getGender());
            statement.setString(3, customer.getNrcStateCode());
            statement.setString(4, customer.getNrcTownshipCode());
            statement.setString(5, customer.getNrcType());
            statement.setString(6, customer.getNrcNumber());
            statement.setString(7, customer.getPhone());
            statement.setString(8, customer.getEmail());
            statement.setString(9, customer.getAddress());

            int rowsInserted = statement.executeUpdate();

            return rowsInserted > 0;

        } catch (SQLException e) {

            System.out.println("Error adding customer:");
            e.printStackTrace();

            return false;
        }
    }


    // =========================================================
    // READ - Find customer by ID
    // =========================================================

    public Customer getCustomerById(int id) {

        String sql = """
                SELECT
                    id,
                    full_name,
                    gender,
                    nrc_state_code,
                    nrc_township_code,
                    nrc_type,
                    nrc_number,
                    phone,
                    email,
                    address
                FROM customers
                WHERE id = ?
                """;

        try (
            Connection connection = DatabaseConnection.getConnection();
            PreparedStatement statement = connection.prepareStatement(sql)
        ) {

            statement.setInt(1, id);

            ResultSet result = statement.executeQuery();

            if (result.next()) {

                return mapCustomer(result);
            }

        } catch (SQLException e) {

            System.out.println("Error finding customer:");
            e.printStackTrace();
        }

        return null;
    }


    // =========================================================
    // READ - Get all customers
    // =========================================================

    public List<Customer> getAllCustomers() {

        List<Customer> customers = new ArrayList<>();

        String sql = """
                SELECT
                    id,
                    full_name,
                    gender,
                    nrc_state_code,
                    nrc_township_code,
                    nrc_type,
                    nrc_number,
                    phone,
                    email,
                    address
                FROM customers
                ORDER BY id DESC
                """;

        try (
            Connection connection = DatabaseConnection.getConnection();
            PreparedStatement statement = connection.prepareStatement(sql);
            ResultSet result = statement.executeQuery()
        ) {

            while (result.next()) {

                customers.add(mapCustomer(result));
            }

        } catch (SQLException e) {

            System.out.println("Error getting customers:");
            e.printStackTrace();
        }

        return customers;
    }


    // =========================================================
    // UPDATE - Update customer
    // =========================================================

    public boolean updateCustomer(Customer customer) {

        String sql = """
                UPDATE customers
                SET
                    full_name = ?,
                    gender = ?,
                    nrc_state_code = ?,
                    nrc_township_code = ?,
                    nrc_type = ?,
                    nrc_number = ?,
                    phone = ?,
                    email = ?,
                    address = ?
                WHERE id = ?
                """;

        try (
            Connection connection = DatabaseConnection.getConnection();
            PreparedStatement statement = connection.prepareStatement(sql)
        ) {

            statement.setString(1, customer.getFullName());
            statement.setString(2, customer.getGender());
            statement.setString(3, customer.getNrcStateCode());
            statement.setString(4, customer.getNrcTownshipCode());
            statement.setString(5, customer.getNrcType());
            statement.setString(6, customer.getNrcNumber());
            statement.setString(7, customer.getPhone());
            statement.setString(8, customer.getEmail());
            statement.setString(9, customer.getAddress());

            statement.setInt(10, customer.getId());

            int rowsUpdated = statement.executeUpdate();

            return rowsUpdated > 0;

        } catch (SQLException e) {

            System.out.println("Error updating customer:");
            e.printStackTrace();

            return false;
        }
    }


    // =========================================================
    // DELETE - Delete customer
    // =========================================================

    public boolean deleteCustomer(int id) {

        String sql = """
                DELETE FROM customers
                WHERE id = ?
                """;

        try (
            Connection connection = DatabaseConnection.getConnection();
            PreparedStatement statement = connection.prepareStatement(sql)
        ) {

            statement.setInt(1, id);

            int rowsDeleted = statement.executeUpdate();

            return rowsDeleted > 0;

        } catch (SQLException e) {

            System.out.println("Error deleting customer:");
            e.printStackTrace();

            return false;
        }
    }


    // =========================================================
    // SEARCH - Search by name or phone
    // =========================================================

    public List<Customer> searchCustomers(String keyword) {

        List<Customer> customers = new ArrayList<>();

        String sql = """
                SELECT
                    id,
                    full_name,
                    gender,
                    nrc_state_code,
                    nrc_township_code,
                    nrc_type,
                    nrc_number,
                    phone,
                    email,
                    address
                FROM customers
                WHERE full_name LIKE ?
                   OR phone LIKE ?
                ORDER BY id DESC
                """;

        try (
            Connection connection = DatabaseConnection.getConnection();
            PreparedStatement statement = connection.prepareStatement(sql)
        ) {

            String searchValue = "%" + keyword + "%";

            statement.setString(1, searchValue);
            statement.setString(2, searchValue);

            ResultSet result = statement.executeQuery();

            while (result.next()) {

                customers.add(mapCustomer(result));
            }

        } catch (SQLException e) {

            System.out.println("Error searching customers:");
            e.printStackTrace();
        }

        return customers;
    }


    // =========================================================
    // HELPER - Convert ResultSet into Customer object
    // =========================================================

    private Customer mapCustomer(ResultSet result)
            throws SQLException {

        Customer customer = new Customer();

        customer.setId(result.getInt("id"));

        customer.setFullName(
                result.getString("full_name")
        );

        customer.setGender(
                result.getString("gender")
        );

        customer.setNrcStateCode(
                result.getString("nrc_state_code")
        );

        customer.setNrcTownshipCode(
                result.getString("nrc_township_code")
        );

        customer.setNrcType(
                result.getString("nrc_type")
        );

        customer.setNrcNumber(
                result.getString("nrc_number")
        );

        customer.setPhone(
                result.getString("phone")
        );

        customer.setEmail(
                result.getString("email")
        );

        customer.setAddress(
                result.getString("address")
        );

        return customer;
    }
}