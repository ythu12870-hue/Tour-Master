package com.tourmaster.dao;

import com.tourmaster.config.DatabaseConnection;
import com.tourmaster.model.PackageHostel;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class PackageHostelDAO {

    // =====================================================
    // ADD HOSTEL TO PACKAGE
    // =====================================================

    public boolean addPackageHostel(
            PackageHostel packageHostel) {

        String sql = """
                INSERT INTO package_hostels
                (
                    package_id,
                    hostel_id,
                    nights,
                    room_type,
                    rooms_required,
                    notes
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
                    packageHostel.getPackageId()
            );

            statement.setInt(
                    2,
                    packageHostel.getHostelId()
            );

            statement.setInt(
                    3,
                    packageHostel.getNights()
            );

            statement.setString(
                    4,
                    packageHostel.getRoomType()
            );

            statement.setInt(
                    5,
                    packageHostel.getRoomsRequired()
            );

            statement.setString(
                    6,
                    packageHostel.getNotes()
            );

            return statement.executeUpdate() > 0;

        } catch (SQLException e) {

            System.out.println(
                    "Error assigning hostel to package:"
            );

            e.printStackTrace();

            return false;
        }
    }


    // =====================================================
    // GET BY ID
    // =====================================================

    public PackageHostel getPackageHostelById(
            int id) {

        String sql = """
                SELECT *
                FROM package_hostels
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

                return mapPackageHostel(result);
            }

        } catch (SQLException e) {

            e.printStackTrace();
        }

        return null;
    }


    // =====================================================
    // GET ALL
    // =====================================================

    public List<PackageHostel> getAllPackageHostels() {

        List<PackageHostel> list =
                new ArrayList<>();

        String sql = """
                SELECT *
                FROM package_hostels
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
                        mapPackageHostel(result)
                );
            }

        } catch (SQLException e) {

            e.printStackTrace();
        }

        return list;
    }


    // =====================================================
    // GET HOSTELS FOR PACKAGE
    // =====================================================

    public List<PackageHostel> getHostelsByPackage(
            int packageId) {

        List<PackageHostel> list =
                new ArrayList<>();

        String sql = """
                SELECT *
                FROM package_hostels
                WHERE package_id = ?
                ORDER BY id
                """;

        try (
                Connection connection =
                        DatabaseConnection.getConnection();

                PreparedStatement statement =
                        connection.prepareStatement(sql)
        ) {

            statement.setInt(
                    1,
                    packageId
            );

            ResultSet result =
                    statement.executeQuery();

            while (result.next()) {

                list.add(
                        mapPackageHostel(result)
                );
            }

        } catch (SQLException e) {

            e.printStackTrace();
        }

        return list;
    }


    // =====================================================
    // UPDATE
    // =====================================================

    public boolean updatePackageHostel(
            PackageHostel packageHostel) {

        String sql = """
                UPDATE package_hostels
                SET
                    package_id = ?,
                    hostel_id = ?,
                    nights = ?,
                    room_type = ?,
                    rooms_required = ?,
                    notes = ?
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
                    packageHostel.getPackageId()
            );

            statement.setInt(
                    2,
                    packageHostel.getHostelId()
            );

            statement.setInt(
                    3,
                    packageHostel.getNights()
            );

            statement.setString(
                    4,
                    packageHostel.getRoomType()
            );

            statement.setInt(
                    5,
                    packageHostel.getRoomsRequired()
            );

            statement.setString(
                    6,
                    packageHostel.getNotes()
            );

            statement.setInt(
                    7,
                    packageHostel.getId()
            );

            return statement.executeUpdate() > 0;

        } catch (SQLException e) {

            e.printStackTrace();

            return false;
        }
    }


    // =====================================================
    // DELETE
    // =====================================================

    public boolean deletePackageHostel(int id) {

        String sql = """
                DELETE FROM package_hostels
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


    // =====================================================
    // MAP RESULT
    // =====================================================

    private PackageHostel mapPackageHostel(
            ResultSet result)
            throws SQLException {

        PackageHostel packageHostel =
                new PackageHostel();

        packageHostel.setId(
                result.getInt("id")
        );

        packageHostel.setPackageId(
                result.getInt("package_id")
        );

        packageHostel.setHostelId(
                result.getInt("hostel_id")
        );

        packageHostel.setNights(
                result.getInt("nights")
        );

        packageHostel.setRoomType(
                result.getString("room_type")
        );

        packageHostel.setRoomsRequired(
                result.getInt("rooms_required")
        );

        packageHostel.setNotes(
                result.getString("notes")
        );

        return packageHostel;
    }
}