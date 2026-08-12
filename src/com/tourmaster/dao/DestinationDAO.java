package com.tourmaster.dao;

import com.tourmaster.config.DatabaseConnection;
import com.tourmaster.model.Destination;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class DestinationDAO {

    // =========================================================
    // CREATE
    // =========================================================

    public boolean addDestination(Destination destination) {

        String sql = """
                INSERT INTO destinations
                (
                    name,
                    description,
                    location,
                    image,
                    status
                )
                VALUES (?, ?, ?, ?, ?)
                """;

        try (
                Connection connection =
                        DatabaseConnection.getConnection();

                PreparedStatement statement =
                        connection.prepareStatement(sql)
        ) {

            statement.setString(1, destination.getName());
            statement.setString(2, destination.getDescription());
            statement.setString(3, destination.getLocation());
            statement.setString(4, destination.getImage());
            statement.setString(5, destination.getStatus());

            return statement.executeUpdate() > 0;

        } catch (SQLException e) {

            System.out.println(
                    "Error adding destination:"
            );

            e.printStackTrace();

            return false;
        }
    }


    // =========================================================
    // READ - Get destination by ID
    // =========================================================

    public Destination getDestinationById(int id) {

        String sql = """
                SELECT
                    id,
                    name,
                    description,
                    location,
                    image,
                    status
                FROM destinations
                WHERE id = ?
                """;

        try (
                Connection connection =
                        DatabaseConnection.getConnection();

                PreparedStatement statement =
                        connection.prepareStatement(sql)
        ) {

            statement.setInt(1, id);

            ResultSet result = statement.executeQuery();

            if (result.next()) {

                return mapDestination(result);
            }

        } catch (SQLException e) {

            System.out.println(
                    "Error finding destination:"
            );

            e.printStackTrace();
        }

        return null;
    }


    // =========================================================
    // READ - Get all destinations
    // =========================================================

    public List<Destination> getAllDestinations() {

        List<Destination> destinations =
                new ArrayList<>();

        String sql = """
                SELECT
                    id,
                    name,
                    description,
                    location,
                    image,
                    status
                FROM destinations
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

                destinations.add(
                        mapDestination(result)
                );
            }

        } catch (SQLException e) {

            System.out.println(
                    "Error getting destinations:"
            );

            e.printStackTrace();
        }

        return destinations;
    }


    // =========================================================
    // READ - Get only active destinations
    // =========================================================

    public List<Destination> getActiveDestinations() {

        List<Destination> destinations =
                new ArrayList<>();

        String sql = """
                SELECT
                    id,
                    name,
                    description,
                    location,
                    image,
                    status
                FROM destinations
                WHERE status = 'Active'
                ORDER BY name ASC
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

                destinations.add(
                        mapDestination(result)
                );
            }

        } catch (SQLException e) {

            System.out.println(
                    "Error getting active destinations:"
            );

            e.printStackTrace();
        }

        return destinations;
    }


    // =========================================================
    // UPDATE
    // =========================================================

    public boolean updateDestination(
            Destination destination) {

        String sql = """
                UPDATE destinations
                SET
                    name = ?,
                    description = ?,
                    location = ?,
                    image = ?,
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
                    destination.getName()
            );

            statement.setString(
                    2,
                    destination.getDescription()
            );

            statement.setString(
                    3,
                    destination.getLocation()
            );

            statement.setString(
                    4,
                    destination.getImage()
            );

            statement.setString(
                    5,
                    destination.getStatus()
            );

            statement.setInt(
                    6,
                    destination.getId()
            );

            return statement.executeUpdate() > 0;

        } catch (SQLException e) {

            System.out.println(
                    "Error updating destination:"
            );

            e.printStackTrace();

            return false;
        }
    }


    // =========================================================
    // DELETE
    // =========================================================

    public boolean deleteDestination(int id) {

        String sql = """
                DELETE FROM destinations
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

            System.out.println(
                    "Error deleting destination:"
            );

            e.printStackTrace();

            return false;
        }
    }


    // =========================================================
    // SEARCH
    // =========================================================

    public List<Destination> searchDestinations(
            String keyword) {

        List<Destination> destinations =
                new ArrayList<>();

        String sql = """
                SELECT
                    id,
                    name,
                    description,
                    location,
                    image,
                    status
                FROM destinations
                WHERE name LIKE ?
                   OR location LIKE ?
                ORDER BY name ASC
                """;

        try (
                Connection connection =
                        DatabaseConnection.getConnection();

                PreparedStatement statement =
                        connection.prepareStatement(sql)
        ) {

            String searchValue =
                    "%" + keyword + "%";

            statement.setString(
                    1,
                    searchValue
            );

            statement.setString(
                    2,
                    searchValue
            );

            ResultSet result =
                    statement.executeQuery();

            while (result.next()) {

                destinations.add(
                        mapDestination(result)
                );
            }

        } catch (SQLException e) {

            System.out.println(
                    "Error searching destinations:"
            );

            e.printStackTrace();
        }

        return destinations;
    }


    // =========================================================
    // ACTIVATE / DEACTIVATE
    // =========================================================

    public boolean updateStatus(
            int id,
            String status) {

        String sql = """
                UPDATE destinations
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
            statement.setInt(2, id);

            return statement.executeUpdate() > 0;

        } catch (SQLException e) {

            System.out.println(
                    "Error updating destination status:"
            );

            e.printStackTrace();

            return false;
        }
    }


    // =========================================================
    // HELPER
    // =========================================================

    private Destination mapDestination(
            ResultSet result)
            throws SQLException {

        Destination destination =
                new Destination();

        destination.setId(
                result.getInt("id")
        );

        destination.setName(
                result.getString("name")
        );

        destination.setDescription(
                result.getString("description")
        );

        destination.setLocation(
                result.getString("location")
        );

        destination.setImage(
                result.getString("image")
        );

        destination.setStatus(
                result.getString("status")
        );

        return destination;
    }
}