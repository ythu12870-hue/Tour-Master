package com.tourmaster.dao;

import com.tourmaster.config.DatabaseConnection;
import com.tourmaster.model.Booking;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class BookingDAO {


    // =========================================================
    // CREATE BOOKING
    // =========================================================

    public boolean addBooking(Booking booking) {

        String sql = """
                INSERT INTO bookings
                (
                    booking_code,
                    customer_id,
                    package_id,
                    travel_date,
                    number_of_people,
                    total_amount,
                    booking_status
                )
                VALUES (?, ?, ?, ?, ?, ?, ?)
                """;

        try (
                Connection connection =
                        DatabaseConnection.getConnection();

                PreparedStatement statement =
                        connection.prepareStatement(sql)
        ) {

            statement.setString(
                    1,
                    booking.getBookingCode()
            );

            statement.setInt(
                    2,
                    booking.getCustomerId()
            );

            statement.setInt(
                    3,
                    booking.getPackageId()
            );

            statement.setDate(
                    4,
                    java.sql.Date.valueOf(
                            booking.getTravelDate()
                    )
            );

            statement.setInt(
                    5,
                    booking.getNumberOfPeople()
            );

            statement.setBigDecimal(
                    6,
                    booking.getTotalAmount()
            );

            statement.setString(
                    7,
                    booking.getBookingStatus()
            );

            return statement.executeUpdate() > 0;

        } catch (SQLException e) {

            System.out.println(
                    "Error adding booking:"
            );

            e.printStackTrace();

            return false;
        }
    }


    // =========================================================
    // GET BY ID
    // =========================================================

    public Booking getBookingById(int id) {

        String sql = """
                SELECT *
                FROM bookings
                WHERE id = ?
                """;

        try (
                Connection connection =
                        DatabaseConnection.getConnection();

                PreparedStatement statement =
                        connection.prepareStatement(sql)
        ) {

            statement.setInt(1, id);

            ResultSet result =
                    statement.executeQuery();

            if (result.next()) {

                return mapBooking(result);
            }

        } catch (SQLException e) {

            e.printStackTrace();
        }

        return null;
    }


    // =========================================================
    // GET BY BOOKING CODE
    // =========================================================

    public Booking getBookingByCode(
            String bookingCode) {

        String sql = """
                SELECT *
                FROM bookings
                WHERE booking_code = ?
                """;

        try (
                Connection connection =
                        DatabaseConnection.getConnection();

                PreparedStatement statement =
                        connection.prepareStatement(sql)
        ) {

            statement.setString(
                    1,
                    bookingCode
            );

            ResultSet result =
                    statement.executeQuery();

            if (result.next()) {

                return mapBooking(result);
            }

        } catch (SQLException e) {

            e.printStackTrace();
        }

        return null;
    }


    // =========================================================
    // GET CUSTOMER BOOKINGS
    // =========================================================

    public List<Booking> getBookingsByCustomer(
            int customerId) {

        List<Booking> bookings =
                new ArrayList<>();

        String sql = """
                SELECT *
                FROM bookings
                WHERE customer_id = ?
                ORDER BY created_at DESC
                """;

        try (
                Connection connection =
                        DatabaseConnection.getConnection();

                PreparedStatement statement =
                        connection.prepareStatement(sql)
        ) {

            statement.setInt(
                    1,
                    customerId
            );

            ResultSet result =
                    statement.executeQuery();

            while (result.next()) {

                bookings.add(
                        mapBooking(result)
                );
            }

        } catch (SQLException e) {

            e.printStackTrace();
        }

        return bookings;
    }


    // =========================================================
    // GET ALL BOOKINGS
    // =========================================================

    public List<Booking> getAllBookings() {

        List<Booking> bookings =
                new ArrayList<>();

        String sql = """
                SELECT *
                FROM bookings
                ORDER BY created_at DESC
                """;

        try (
                Connection connection =
                        DatabaseConnection.getConnection();

                PreparedStatement statement =
                        connection.prepareStatement(sql);

                ResultSet result =
                        statement.executeQuery()
        ) {

            while (result.next()) {

                bookings.add(
                        mapBooking(result)
                );
            }

        } catch (SQLException e) {

            e.printStackTrace();
        }

        return bookings;
    }


    // =========================================================
    // UPDATE STATUS
    // =========================================================

    public boolean updateBookingStatus(
            int bookingId,
            String status) {

        String sql = """
                UPDATE bookings
                SET booking_status = ?
                WHERE id = ?
                """;

        try (
                Connection connection =
                        DatabaseConnection.getConnection();

                PreparedStatement statement =
                        connection.prepareStatement(sql)
        ) {

            statement.setString(1, status);
            statement.setInt(2, bookingId);

            return statement.executeUpdate() > 0;

        } catch (SQLException e) {

            e.printStackTrace();

            return false;
        }
    }


    // =========================================================
    // DELETE
    // =========================================================

    public boolean deleteBooking(int id) {

        String sql = """
                DELETE FROM bookings
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


    // =========================================================
    // HELPER
    // =========================================================

    private Booking mapBooking(
            ResultSet result)
            throws SQLException {

        Booking booking =
                new Booking();

        booking.setId(
                result.getInt("id")
        );

        booking.setBookingCode(
                result.getString("booking_code")
        );

        booking.setCustomerId(
                result.getInt("customer_id")
        );

        booking.setPackageId(
                result.getInt("package_id")
        );

        booking.setTravelDate(
                result.getDate("travel_date")
                        .toLocalDate()
        );

        booking.setNumberOfPeople(
                result.getInt("number_of_people")
        );

        booking.setTotalAmount(
                result.getBigDecimal("total_amount")
        );

        booking.setBookingStatus(
                result.getString("booking_status")
        );

        return booking;
    }
}