package com.tourmaster.dao;

import com.tourmaster.config.DatabaseConnection;
import com.tourmaster.model.Hostel;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class HostelDAO {

    // =====================================================
    // ADD HOSTEL
    // =====================================================

    public boolean addHostel(Hostel hostel) {

        String sql = """
                INSERT INTO hostels
                (
                    name,
                    destination_id,
                    address,
                    phone,
                    description,
                    rating,
                    status
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
                    hostel.getName()
            );

            statement.setInt(
                    2,
                    hostel.getDestinationId()
            );

            statement.setString(
                    3,
                    hostel.getAddress()
            );

            statement.setString(
                    4,
                    hostel.getPhone()
            );

            statement.setString(
                    5,
                    hostel.getDescription()
            );

            if (hostel.getRating() == null) {
                statement.setNull(
                        6,
                        java.sql.Types.DECIMAL
                );
            } else {
                statement.setDouble(
                        6,
                        hostel.getRating()
                );
            }

            statement.setString(
                    7,
                    hostel.getStatus()
            );

            return statement.executeUpdate() > 0;

        } catch (SQLException e) {

            System.out.println(
                    "Error adding hostel:"
            );

            e.printStackTrace();

            return false;
        }
    }


    // =====================================================
    // GET HOSTEL BY ID
    // =====================================================

    public Hostel getHostelById(int id) {

        String sql = """
                SELECT *
                FROM hostels
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
                return mapHostel(result);
            }

        } catch (SQLException e) {

            e.printStackTrace();
        }

        return null;
    }


    // =====================================================
    // GET ALL HOSTELS
    // =====================================================

    public List<Hostel> getAllHostels() {

        List<Hostel> hostels =
                new ArrayList<>();

        String sql = """
                SELECT *
                FROM hostels
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

                hostels.add(
                        mapHostel(result)
                );
            }

        } catch (SQLException e) {

            e.printStackTrace();
        }

        return hostels;
    }


    // =====================================================
    // GET ACTIVE HOSTELS
    // =====================================================

    public List<Hostel> getActiveHostels() {

        List<Hostel> hostels =
                new ArrayList<>();

        String sql = """
                SELECT *
                FROM hostels
                WHERE status = 'Active'
                ORDER BY name
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

                hostels.add(
                        mapHostel(result)
                );
            }

        } catch (SQLException e) {

            e.printStackTrace();
        }

        return hostels;
    }


    // =====================================================
    // GET HOSTELS BY DESTINATION
    // =====================================================

    public List<Hostel> getHostelsByDestination(
            int destinationId) {

        List<Hostel> hostels =
                new ArrayList<>();

        String sql = """
                SELECT *
                FROM hostels
                WHERE destination_id = ?
                AND status = 'Active'
                ORDER BY name
                """;

        try (
                Connection connection =
                        DatabaseConnection.getConnection();

                PreparedStatement statement =
                        connection.prepareStatement(sql)
        ) {

            statement.setInt(
                    1,
                    destinationId
            );

            ResultSet result =
                    statement.executeQuery();

            while (result.next()) {

                hostels.add(
                        mapHostel(result)
                );
            }

        } catch (SQLException e) {

            e.printStackTrace();
        }

        return hostels;
    }


    // =====================================================
    // UPDATE HOSTEL
    // =====================================================

    public boolean updateHostel(Hostel hostel) {

        String sql = """
                UPDATE hostels
                SET
                    name = ?,
                    destination_id = ?,
                    address = ?,
                    phone = ?,
                    description = ?,
                    rating = ?,
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
                    hostel.getName()
            );

            statement.setInt(
                    2,
                    hostel.getDestinationId()
            );

            statement.setString(
                    3,
                    hostel.getAddress()
            );

            statement.setString(
                    4,
                    hostel.getPhone()
            );

            statement.setString(
                    5,
                    hostel.getDescription()
            );

            if (hostel.getRating() == null) {
                statement.setNull(
                        6,
                        java.sql.Types.DECIMAL
                );
            } else {
                statement.setDouble(
                        6,
                        hostel.getRating()
                );
            }

            statement.setString(
                    7,
                    hostel.getStatus()
            );

            statement.setInt(
                    8,
                    hostel.getId()
            );

            return statement.executeUpdate() > 0;

        } catch (SQLException e) {

            e.printStackTrace();

            return false;
        }
    }


    // =====================================================
    // UPDATE STATUS
    // =====================================================

    public boolean updateStatus(
            int hostelId,
            String status) {

        String sql = """
                UPDATE hostels
                SET status = ?
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
                    status
            );

            statement.setInt(
                    2,
                    hostelId
            );

            return statement.executeUpdate() > 0;

        } catch (SQLException e) {

            e.printStackTrace();

            return false;
        }
    }


    // =====================================================
    // DELETE HOSTEL
    // =====================================================

    public boolean deleteHostel(int id) {

        String sql = """
                DELETE FROM hostels
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
                    "Cannot delete hostel."
            );

            e.printStackTrace();

            return false;
        }
    }


    // =====================================================
    // MAP RESULT
    // =====================================================

    private Hostel mapHostel(
            ResultSet result)
            throws SQLException {

        Hostel hostel =
                new Hostel();

        hostel.setId(
                result.getInt("id")
        );

        hostel.setName(
                result.getString("name")
        );

        hostel.setDestinationId(
                result.getInt("destination_id")
        );

        hostel.setAddress(
                result.getString("address")
        );

        hostel.setPhone(
                result.getString("phone")
        );

        hostel.setDescription(
                result.getString("description")
        );

        double rating =
                result.getDouble("rating");

        if (result.wasNull()) {
            hostel.setRating(null);
        } else {
            hostel.setRating(rating);
        }

        hostel.setStatus(
                result.getString("status")
        );

        return hostel;
    }
}