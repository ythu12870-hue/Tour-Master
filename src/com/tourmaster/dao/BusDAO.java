package com.tourmaster.dao;

import com.tourmaster.config.DatabaseConnection;
import com.tourmaster.model.Bus;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class BusDAO {


    // CREATE
    public boolean addBus(Bus bus) {

        String sql = """
                INSERT INTO buses
                (
                    transportation_id,
                    bus_name,
                    bus_number,
                    total_seats,
                    seat_layout,
                    status
                )
                VALUES (?, ?, ?, ?, ?, ?)
                """;

        try (
                Connection connection =
                        DatabaseConnection.getConnection();

                PreparedStatement statement =
                        connection.prepareStatement(sql)
        ) {

            statement.setInt(
                    1,
                    bus.getTransportationId()
            );

            statement.setString(
                    2,
                    bus.getBusName()
            );

            statement.setString(
                    3,
                    bus.getBusNumber()
            );

            statement.setInt(
                    4,
                    bus.getTotalSeats()
            );

            statement.setString(
                    5,
                    bus.getSeatLayout()
            );

            statement.setString(
                    6,
                    bus.getStatus()
            );

            return statement.executeUpdate() > 0;

        } catch (SQLException e) {

            System.out.println(
                    "Error adding bus:"
            );

            e.printStackTrace();

            return false;
        }
    }


    // GET BY ID
    public Bus getBusById(int id) {

        String sql = """
                SELECT *
                FROM buses
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

                return mapBus(result);
            }

        } catch (SQLException e) {

            e.printStackTrace();
        }

        return null;
    }


    // GET ALL
    public List<Bus> getAllBuses() {

        List<Bus> buses =
                new ArrayList<>();

        String sql = """
                SELECT *
                FROM buses
                ORDER BY id DESC
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

                buses.add(
                        mapBus(result)
                );
            }

        } catch (SQLException e) {

            e.printStackTrace();
        }

        return buses;
    }


    // GET BY TRANSPORTATION
    public Bus getBusByTransportation(
            int transportationId) {

        String sql = """
                SELECT *
                FROM buses
                WHERE transportation_id = ?
                LIMIT 1
                """;

        try (
                Connection connection =
                        DatabaseConnection.getConnection();

                PreparedStatement statement =
                        connection.prepareStatement(sql)
        ) {

            statement.setInt(
                    1,
                    transportationId
            );

            ResultSet result =
                    statement.executeQuery();

            if (result.next()) {

                return mapBus(result);
            }

        } catch (SQLException e) {

            e.printStackTrace();
        }

        return null;
    }


    // UPDATE
    public boolean updateBus(Bus bus) {

        String sql = """
                UPDATE buses
                SET
                    transportation_id = ?,
                    bus_name = ?,
                    bus_number = ?,
                    total_seats = ?,
                    seat_layout = ?,
                    status = ?
                WHERE id = ?
                """;

        try (
                Connection connection =
                        DatabaseConnection.getConnection();

                PreparedStatement statement =
                        connection.prepareStatement(sql)
        ) {

            statement.setInt(
                    1,
                    bus.getTransportationId()
            );

            statement.setString(
                    2,
                    bus.getBusName()
            );

            statement.setString(
                    3,
                    bus.getBusNumber()
            );

            statement.setInt(
                    4,
                    bus.getTotalSeats()
            );

            statement.setString(
                    5,
                    bus.getSeatLayout()
            );

            statement.setString(
                    6,
                    bus.getStatus()
            );

            statement.setInt(
                    7,
                    bus.getId()
            );

            return statement.executeUpdate() > 0;

        } catch (SQLException e) {

            e.printStackTrace();

            return false;
        }
    }


    // DELETE
    public boolean deleteBus(int id) {

        String sql = """
                DELETE FROM buses
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
    private Bus mapBus(ResultSet result)
            throws SQLException {

        Bus bus = new Bus();

        bus.setId(
                result.getInt("id")
        );

        bus.setTransportationId(
                result.getInt("transportation_id")
        );

        bus.setBusName(
                result.getString("bus_name")
        );

        bus.setBusNumber(
                result.getString("bus_number")
        );

        bus.setTotalSeats(
                result.getInt("total_seats")
        );

        bus.setSeatLayout(
                result.getString("seat_layout")
        );

        bus.setStatus(
                result.getString("status")
        );

        return bus;
    }
}