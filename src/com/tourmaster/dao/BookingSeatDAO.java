package com.tourmaster.dao;

import com.tourmaster.config.DatabaseConnection;
import com.tourmaster.model.BookingSeat;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class BookingSeatDAO {


    // =========================================================
    // ADD BOOKING SEAT
    // =========================================================

    public boolean addBookingSeat(
            BookingSeat bookingSeat) {

        String sql = """
                INSERT INTO booking_seats
                (
                    booking_id,
                    seat_id
                )
                VALUES (?, ?)
                """;

        try (
                Connection connection =
                        DatabaseConnection.getConnection();

                PreparedStatement statement =
                        connection.prepareStatement(sql)
        ) {

            statement.setInt(
                    1,
                    bookingSeat.getBookingId()
            );

            statement.setInt(
                    2,
                    bookingSeat.getSeatId()
            );

            return statement.executeUpdate() > 0;

        } catch (SQLException e) {

            System.out.println(
                    "Error adding booking seat:"
            );

            e.printStackTrace();

            return false;
        }
    }


    // =========================================================
    // GET SEATS FOR BOOKING
    // =========================================================

    public List<BookingSeat>
    getSeatsByBooking(
            int bookingId) {

        List<BookingSeat> seats =
                new ArrayList<>();

        String sql = """
                SELECT *
                FROM booking_seats
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

                seats.add(
                        mapBookingSeat(result)
                );
            }

        } catch (SQLException e) {

            e.printStackTrace();
        }

        return seats;
    }


    // =========================================================
    // CHECK WHETHER SEAT IS BOOKED
    // =========================================================

    public boolean isSeatBooked(int seatId) {

        String sql = """
                SELECT id
                FROM booking_seats
                WHERE seat_id = ?
                LIMIT 1
                """;

        try (
                Connection connection =
                        DatabaseConnection.getConnection();

                PreparedStatement statement =
                        connection.prepareStatement(sql)
        ) {

            statement.setInt(1, seatId);

            ResultSet result =
                    statement.executeQuery();

            return result.next();

        } catch (SQLException e) {

            e.printStackTrace();

            return false;
        }
    }


    // =========================================================
    // DELETE BOOKING SEAT
    // =========================================================

    public boolean deleteBookingSeat(int id) {

        String sql = """
                DELETE FROM booking_seats
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

    private BookingSeat mapBookingSeat(
            ResultSet result)
            throws SQLException {

        BookingSeat bookingSeat =
                new BookingSeat();

        bookingSeat.setId(
                result.getInt("id")
        );

        bookingSeat.setBookingId(
                result.getInt("booking_id")
        );

        bookingSeat.setSeatId(
                result.getInt("seat_id")
        );

        return bookingSeat;
    }
}