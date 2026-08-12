package com.tourmaster.dao;

import com.tourmaster.config.DatabaseConnection;
import com.tourmaster.model.Transportation;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class TransportationDAO {


    // CREATE
    public boolean addTransportation(
            Transportation transportation) {

        String sql = """
                INSERT INTO transportation
                (
                    package_id,
                    transportation_type,
                    vehicle_name,
                    vehicle_number,
                    capacity,
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
                    transportation.getPackageId()
            );

            statement.setString(
                    2,
                    transportation.getTransportationType()
            );

            statement.setString(
                    3,
                    transportation.getVehicleName()
            );

            statement.setString(
                    4,
                    transportation.getVehicleNumber()
            );

            statement.setInt(
                    5,
                    transportation.getCapacity()
            );

            statement.setString(
                    6,
                    transportation.getStatus()
            );

            return statement.executeUpdate() > 0;

        } catch (SQLException e) {

            System.out.println(
                    "Error adding transportation:"
            );

            e.printStackTrace();

            return false;
        }
    }


    // READ BY ID
    public Transportation getTransportationById(int id) {

        String sql = """
                SELECT *
                FROM transportation
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

                return mapTransportation(result);
            }

        } catch (SQLException e) {

            e.printStackTrace();
        }

        return null;
    }


    // GET BY PACKAGE
    public Transportation getTransportationByPackage(
            int packageId) {

        String sql = """
                SELECT *
                FROM transportation
                WHERE package_id = ?
                AND status = 'Active'
                LIMIT 1
                """;

        try (
                Connection connection =
                        DatabaseConnection.getConnection();

                PreparedStatement statement =
                        connection.prepareStatement(sql)
        ) {

            statement.setInt(1, packageId);

            ResultSet result =
                    statement.executeQuery();

            if (result.next()) {

                return mapTransportation(result);
            }

        } catch (SQLException e) {

            e.printStackTrace();
        }

        return null;
    }


    // READ ALL
    public List<Transportation>
    getAllTransportations() {

        List<Transportation> list =
                new ArrayList<>();

        String sql = """
                SELECT *
                FROM transportation
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

                list.add(
                        mapTransportation(result)
                );
            }

        } catch (SQLException e) {

            e.printStackTrace();
        }

        return list;
    }


    // UPDATE
    public boolean updateTransportation(
            Transportation transportation) {

        String sql = """
                UPDATE transportation
                SET
                    package_id = ?,
                    transportation_type = ?,
                    vehicle_name = ?,
                    vehicle_number = ?,
                    capacity = ?,
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
                    transportation.getPackageId()
            );

            statement.setString(
                    2,
                    transportation.getTransportationType()
            );

            statement.setString(
                    3,
                    transportation.getVehicleName()
            );

            statement.setString(
                    4,
                    transportation.getVehicleNumber()
            );

            statement.setInt(
                    5,
                    transportation.getCapacity()
            );

            statement.setString(
                    6,
                    transportation.getStatus()
            );

            statement.setInt(
                    7,
                    transportation.getId()
            );

            return statement.executeUpdate() > 0;

        } catch (SQLException e) {

            e.printStackTrace();

            return false;
        }
    }


    // DELETE
    public boolean deleteTransportation(int id) {

        String sql = """
                DELETE FROM transportation
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
    private Transportation mapTransportation(
            ResultSet result)
            throws SQLException {

        Transportation transportation =
                new Transportation();

        transportation.setId(
                result.getInt("id")
        );

        transportation.setPackageId(
                result.getInt("package_id")
        );

        transportation.setTransportationType(
                result.getString(
                        "transportation_type"
                )
        );

        transportation.setVehicleName(
                result.getString("vehicle_name")
        );

        transportation.setVehicleNumber(
                result.getString("vehicle_number")
        );

        transportation.setCapacity(
                result.getInt("capacity")
        );

        transportation.setStatus(
                result.getString("status")
        );

        return transportation;
    }
}