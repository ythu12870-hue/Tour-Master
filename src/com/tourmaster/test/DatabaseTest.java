package com.tourmaster.test;

import java.sql.Connection;

import com.tourmaster.config.DatabaseConnection;

public class DatabaseTest {

    public static void main(String[] args) {

        Connection connection =
                DatabaseConnection.getConnection();

        if (connection != null) {

            System.out.println(
                    "Tour Master database is working!"
            );

            try {

                connection.close();

                System.out.println(
                        "Database connection closed."
                );

            } catch (Exception e) {

                e.printStackTrace();
            }

        } else {

            System.out.println(
                    "Could not connect to database."
            );
        }
    }
}