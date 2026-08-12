package com.tourmaster.dao;

import com.tourmaster.config.DatabaseConnection;
import com.tourmaster.model.BusSeat;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class BusSeatDAO {


    // =========================================================
    // CREATE
    // =========================================================

    public boolean addSeat(BusSeat seat) {

        String sql = """
                INSERT INTO bus_seats
                (
                    bus_id,
                    seat_number,
                    seat_type,
                    status
                )
                VALUES (?, ?, ?, ?)
                """;

        try (
                Connection connection =
                        DatabaseConnection.getConnection();

                PreparedStatement statement =
                        connection.prepareStatement(sql)
        ) {

            statement.setInt(
                    1,
                    seat.getBusId()
            );

            statement.setString(
                    2,
                    seat.getSeatNumber()
            );

            statement.setString(
                    3,
                    seat.getSeatType()
            );

            statement.setString(
                    4,
                    seat.getStatus()
            );

            return statement.executeUpdate() > 0;

        } catch (SQLException e) {

            System.out.println(
                    "Error adding seat:"
            );

            e.printStackTrace();

            return false;
        }
    }


    // =========================================================
    // GET ALL SEATS OF BUS
    // =========================================================

    public List<BusSeat> getSeatsByBus(
            int busId) {

        List<BusSeat> seats =
                new ArrayList<>();

        String sql = """
                SELECT *
                FROM bus_seats
                WHERE bus_id = ?
                ORDER BY seat_number
                """;

        try (
                Connection connection =
                        DatabaseConnection.getConnection();

                PreparedStatement statement =
                        connection.prepareStatement(sql)
        ) {

            statement.setInt(1, busId);

            ResultSet result =
                    statement.executeQuery();

            while (result.next()) {

                seats.add(
                        mapSeat(result)
                );
            }

        } catch (SQLException e) {

            e.printStackTrace();
        }

        return seats;
    }


    // =========================================================
    // GET AVAILABLE SEATS
    // =========================================================

    public List<BusSeat> getAvailableSeats(
            int busId) {

        List<BusSeat> seats =
                new ArrayList<>();

        String sql = """
                SELECT *
                FROM bus_seats
                WHERE bus_id = ?
                AND status = 'Available'
                ORDER BY seat_number
                """;

        try (
                Connection connection =
                        DatabaseConnection.getConnection();

                PreparedStatement statement =
                        connection.prepareStatement(sql)
        ) {

            statement.setInt(1, busId);

            ResultSet result =
                    statement.executeQuery();

            while (result.next()) {

                seats.add(
                        mapSeat(result)
                );
            }

        } catch (SQLException e) {

            e.printStackTrace();
        }

        return seats;
    }


    // =========================================================
    // GET ONE SEAT
    // =========================================================

    public BusSeat getSeatById(int id) {

        String sql = """
                SELECT *
                FROM bus_seats
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

                return mapSeat(result);
            }

        } catch (SQLException e) {

            e.printStackTrace();
        }

        return null;
    }


    // =========================================================
    // CHANGE SEAT STATUS
    // =========================================================

    public boolean updateSeatStatus(
            int seatId,
            String status) {

        String sql = """
                UPDATE bus_seats
                SET status = ?
                WHERE id = ?
                """;

        try (
                Connection connection =
                        DatabaseConnection.getConnection();

                PreparedStatement statement =
                        connection.prepareStatement(sql)
        ) {

            statement.setString(1, status);
            statement.setInt(2, seatId);

            return statement.executeUpdate() > 0;

        } catch (SQLException e) {

            e.printStackTrace();

            return false;
        }
    }


    // =========================================================
    // UPDATE SEAT
    // =========================================================

    public boolean updateSeat(
            BusSeat seat) {

        String sql = """
                UPDATE bus_seats
                SET
                    seat_number = ?,
                    seat_type = ?,
                    status = ?
                WHERE id = ?
                """;

        try (
                Connection connection =
                        DatabaseConnection.getConnection();

                PreparedStatement statement =
                        connection.prepareStatement(sql)
        ) {

            statement.setString(
                    1,
                    seat.getSeatNumber()
            );

            statement.setString(
                    2,
                    seat.getSeatType()
            );

            statement.setString(
                    3,
                    seat.getStatus()
            );

            statement.setInt(
                    4,
                    seat.getId()
            );

            return statement.executeUpdate() > 0;

        } catch (SQLException e) {

            e.printStackTrace();

            return false;
        }
    }


    // =========================================================
    // DELETE
    // =========================================================

    public boolean deleteSeat(int id) {

        String sql = """
                DELETE FROM bus_seats
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

    private BusSeat mapSeat(
            ResultSet result)
            throws SQLException {

        BusSeat seat = new BusSeat();

        seat.setId(
                result.getInt("id")
        );

        seat.setBusId(
                result.getInt("bus_id")
        );

        seat.setSeatNumber(
                result.getString("seat_number")
        );

        seat.setSeatType(
                result.getString("seat_type")
        );

        seat.setStatus(
                result.getString("status")
        );

        return seat;
    }
}