package com.tourmaster.dao;

import com.tourmaster.config.DatabaseConnection;
import com.tourmaster.model.BookingPassenger;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class BookingPassengerDAO {


    // ADD PASSENGER
    public boolean addPassenger(
            BookingPassenger passenger) {

        String sql = """
                INSERT INTO booking_passengers
                (
                    booking_id,
                    full_name,
                    gender,
                    nrc,
                    phone
                )
                VALUES (?, ?, ?, ?, ?)
                """;

        try (
                Connection connection =
                        DatabaseConnection.getConnection();

                PreparedStatement statement =
                        connection.prepareStatement(sql)
        ) {

            statement.setInt(
                    1,
                    passenger.getBookingId()
            );

            statement.setString(
                    2,
                    passenger.getFullName()
            );

            statement.setString(
                    3,
                    passenger.getGender()
            );

            statement.setString(
                    4,
                    passenger.getNrc()
            );

            statement.setString(
                    5,
                    passenger.getPhone()
            );

            return statement.executeUpdate() > 0;

        } catch (SQLException e) {

            System.out.println(
                    "Error adding passenger:"
            );

            e.printStackTrace();

            return false;
        }
    }


    // GET PASSENGERS OF BOOKING
    public List<BookingPassenger>
    getPassengersByBooking(
            int bookingId) {

        List<BookingPassenger> passengers =
                new ArrayList<>();

        String sql = """
                SELECT *
                FROM booking_passengers
                WHERE booking_id = ?
                ORDER BY id
                """;

        try (
                Connection connection =
                        DatabaseConnection.getConnection();

                PreparedStatement statement =
                        connection.prepareStatement(sql)
        ) {

            statement.setInt(1, bookingId);

            ResultSet result =
                    statement.executeQuery();

            while (result.next()) {

                passengers.add(
                        mapPassenger(result)
                );
            }

        } catch (SQLException e) {

            e.printStackTrace();
        }

        return passengers;
    }


    // DELETE PASSENGER
    public boolean deletePassenger(int id) {

        String sql = """
                DELETE FROM booking_passengers
                WHERE id = ?
                """;

        try (
                Connection connection =
                        DatabaseConnection.getConnection();

                PreparedStatement statement =
                        connection.prepareStatement(sql)
        ) {

            statement.setInt(1, id);

            return statement.executeUpdate() > 0;

        } catch (SQLException e) {

            e.printStackTrace();

            return false;
        }
    }


    // HELPER
    private BookingPassenger mapPassenger(
            ResultSet result)
            throws SQLException {

        BookingPassenger passenger =
                new BookingPassenger();

        passenger.setId(
                result.getInt("id")
        );

        passenger.setBookingId(
                result.getInt("booking_id")
        );

        passenger.setFullName(
                result.getString("full_name")
        );

        passenger.setGender(
                result.getString("gender")
        );

        passenger.setNrc(
                result.getString("nrc")
        );

        passenger.setPhone(
                result.getString("phone")
        );

        return passenger;
    }
}