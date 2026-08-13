package com.tourmaster.dao;

import com.tourmaster.config.DatabaseConnection;
import com.tourmaster.model.PackageGuide;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class PackageGuideDAO {

    // =====================================================
    // ADD GUIDE TO PACKAGE
    // =====================================================

    public boolean addPackageGuide(PackageGuide packageGuide) {

        String sql = """
                INSERT INTO package_guides
                (
                    package_id,
                    guide_id,
                    assignment_type,
                    notes
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
                    packageGuide.getPackageId()
            );

            statement.setInt(
                    2,
                    packageGuide.getGuideId()
            );

            statement.setString(
                    3,
                    packageGuide.getAssignmentType()
            );

            statement.setString(
                    4,
                    packageGuide.getNotes()
            );

            return statement.executeUpdate() > 0;

        } catch (SQLException e) {

            System.out.println(
                    "Error assigning guide to package:"
            );

            e.printStackTrace();

            return false;
        }
    }


    // =====================================================
    // GET BY ID
    // =====================================================

    public PackageGuide getPackageGuideById(int id) {

        String sql = """
                SELECT *
                FROM package_guides
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

                return mapPackageGuide(result);
            }

        } catch (SQLException e) {

            e.printStackTrace();
        }

        return null;
    }


    // =====================================================
    // GET ALL
    // =====================================================

    public List<PackageGuide> getAllPackageGuides() {

        List<PackageGuide> list =
                new ArrayList<>();

        String sql = """
                SELECT *
                FROM package_guides
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
                        mapPackageGuide(result)
                );
            }

        } catch (SQLException e) {

            e.printStackTrace();
        }

        return list;
    }


    // =====================================================
    // GET GUIDES FOR PACKAGE
    // =====================================================

    public List<PackageGuide> getGuidesByPackage(
            int packageId) {

        List<PackageGuide> list =
                new ArrayList<>();

        String sql = """
                SELECT *
                FROM package_guides
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
                        mapPackageGuide(result)
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

    public boolean updatePackageGuide(
            PackageGuide packageGuide) {

        String sql = """
                UPDATE package_guides
                SET
                    package_id = ?,
                    guide_id = ?,
                    assignment_type = ?,
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
                    packageGuide.getPackageId()
            );

            statement.setInt(
                    2,
                    packageGuide.getGuideId()
            );

            statement.setString(
                    3,
                    packageGuide.getAssignmentType()
            );

            statement.setString(
                    4,
                    packageGuide.getNotes()
            );

            statement.setInt(
                    5,
                    packageGuide.getId()
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

    public boolean deletePackageGuide(int id) {

        String sql = """
                DELETE FROM package_guides
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

    private PackageGuide mapPackageGuide(
            ResultSet result)
            throws SQLException {

        PackageGuide packageGuide =
                new PackageGuide();

        packageGuide.setId(
                result.getInt("id")
        );

        packageGuide.setPackageId(
                result.getInt("package_id")
        );

        packageGuide.setGuideId(
                result.getInt("guide_id")
        );

        packageGuide.setAssignmentType(
                result.getString("assignment_type")
        );

        packageGuide.setNotes(
                result.getString("notes")
        );

        return packageGuide;
    }
}