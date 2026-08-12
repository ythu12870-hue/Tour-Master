package com.tourmaster.dao;

import com.tourmaster.config.DatabaseConnection;
import com.tourmaster.model.Package;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class PackageDAO {


    // =========================================================
    // CREATE
    // =========================================================

    public boolean addPackage(Package packageData) {

        String sql = """
                INSERT INTO packages
                (
                    destination_id,
                    package_name,
                    package_type,
                    description,
                    price,
                    duration_days,
                    duration_nights,
                    max_people,
                    transportation_type,
                    status
                )
                VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?)
                """;

        try (
                Connection connection =
                        DatabaseConnection.getConnection();

                PreparedStatement statement =
                        connection.prepareStatement(sql)
        ) {

            statement.setInt(
                    1,
                    packageData.getDestinationId()
            );

            statement.setString(
                    2,
                    packageData.getPackageName()
            );

            statement.setString(
                    3,
                    packageData.getPackageType()
            );

            statement.setString(
                    4,
                    packageData.getDescription()
            );

            statement.setBigDecimal(
                    5,
                    packageData.getPrice()
            );

            statement.setInt(
                    6,
                    packageData.getDurationDays()
            );

            statement.setInt(
                    7,
                    packageData.getDurationNights()
            );

            statement.setInt(
                    8,
                    packageData.getMaxPeople()
            );

            statement.setString(
                    9,
                    packageData.getTransportationType()
            );

            statement.setString(
                    10,
                    packageData.getStatus()
            );

            return statement.executeUpdate() > 0;

        } catch (SQLException e) {

            System.out.println(
                    "Error adding package:"
            );

            e.printStackTrace();

            return false;
        }
    }


    // =========================================================
    // READ - Get package by ID
    // =========================================================

    public Package getPackageById(int id) {

        String sql = """
                SELECT
                    id,
                    destination_id,
                    package_name,
                    package_type,
                    description,
                    price,
                    duration_days,
                    duration_nights,
                    max_people,
                    transportation_type,
                    status
                FROM packages
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

                return mapPackage(result);
            }

        } catch (SQLException e) {

            System.out.println(
                    "Error finding package:"
            );

            e.printStackTrace();
        }

        return null;
    }


    // =========================================================
    // READ - Get all packages
    // =========================================================

    public List<Package> getAllPackages() {

        List<Package> packages =
                new ArrayList<>();

        String sql = """
                SELECT
                    id,
                    destination_id,
                    package_name,
                    package_type,
                    description,
                    price,
                    duration_days,
                    duration_nights,
                    max_people,
                    transportation_type,
                    status
                FROM packages
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

                packages.add(
                        mapPackage(result)
                );
            }

        } catch (SQLException e) {

            System.out.println(
                    "Error getting packages:"
            );

            e.printStackTrace();
        }

        return packages;
    }


    // =========================================================
    // READ - Get packages by destination
    // =========================================================

    public List<Package> getPackagesByDestination(
            int destinationId) {

        List<Package> packages =
                new ArrayList<>();

        String sql = """
                SELECT
                    id,
                    destination_id,
                    package_name,
                    package_type,
                    description,
                    price,
                    duration_days,
                    duration_nights,
                    max_people,
                    transportation_type,
                    status
                FROM packages
                WHERE destination_id = ?
                ORDER BY package_type ASC
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

                packages.add(
                        mapPackage(result)
                );
            }

        } catch (SQLException e) {

            System.out.println(
                    "Error getting packages by destination:"
            );

            e.printStackTrace();
        }

        return packages;
    }


    // =========================================================
    // READ - Get active packages
    // =========================================================

    public List<Package> getActivePackages() {

        List<Package> packages =
                new ArrayList<>();

        String sql = """
                SELECT
                    id,
                    destination_id,
                    package_name,
                    package_type,
                    description,
                    price,
                    duration_days,
                    duration_nights,
                    max_people,
                    transportation_type,
                    status
                FROM packages
                WHERE status = 'Active'
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

                packages.add(
                        mapPackage(result)
                );
            }

        } catch (SQLException e) {

            System.out.println(
                    "Error getting active packages:"
            );

            e.printStackTrace();
        }

        return packages;
    }


    // =========================================================
    // READ - Get VIP packages
    // =========================================================

    public List<Package> getVipPackages() {

        return getPackagesByType("VIP");
    }


    // =========================================================
    // READ - Get Normal packages
    // =========================================================

    public List<Package> getNormalPackages() {

        return getPackagesByType("Normal");
    }


    // =========================================================
    // PRIVATE - Get packages by type
    // =========================================================

    private List<Package> getPackagesByType(
            String packageType) {

        List<Package> packages =
                new ArrayList<>();

        String sql = """
                SELECT
                    id,
                    destination_id,
                    package_name,
                    package_type,
                    description,
                    price,
                    duration_days,
                    duration_nights,
                    max_people,
                    transportation_type,
                    status
                FROM packages
                WHERE package_type = ?
                AND status = 'Active'
                ORDER BY id DESC
                """;

        try (
                Connection connection =
                        DatabaseConnection.getConnection();

                PreparedStatement statement =
                        connection.prepareStatement(sql)
        ) {

            statement.setString(
                    1,
                    packageType
            );

            ResultSet result =
                    statement.executeQuery();

            while (result.next()) {

                packages.add(
                        mapPackage(result)
                );
            }

        } catch (SQLException e) {

            System.out.println(
                    "Error getting packages by type:"
            );

            e.printStackTrace();
        }

        return packages;
    }


    // =========================================================
    // UPDATE
    // =========================================================

    public boolean updatePackage(
            Package packageData) {

        String sql = """
                UPDATE packages
                SET
                    destination_id = ?,
                    package_name = ?,
                    package_type = ?,
                    description = ?,
                    price = ?,
                    duration_days = ?,
                    duration_nights = ?,
                    max_people = ?,
                    transportation_type = ?,
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
                    packageData.getDestinationId()
            );

            statement.setString(
                    2,
                    packageData.getPackageName()
            );

            statement.setString(
                    3,
                    packageData.getPackageType()
            );

            statement.setString(
                    4,
                    packageData.getDescription()
            );

            statement.setBigDecimal(
                    5,
                    packageData.getPrice()
            );

            statement.setInt(
                    6,
                    packageData.getDurationDays()
            );

            statement.setInt(
                    7,
                    packageData.getDurationNights()
            );

            statement.setInt(
                    8,
                    packageData.getMaxPeople()
            );

            statement.setString(
                    9,
                    packageData.getTransportationType()
            );

            statement.setString(
                    10,
                    packageData.getStatus()
            );

            statement.setInt(
                    11,
                    packageData.getId()
            );

            return statement.executeUpdate() > 0;

        } catch (SQLException e) {

            System.out.println(
                    "Error updating package:"
            );

            e.printStackTrace();

            return false;
        }
    }


    // =========================================================
    // DELETE
    // =========================================================

    public boolean deletePackage(int id) {

        String sql = """
                DELETE FROM packages
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
                    "Error deleting package:"
            );

            e.printStackTrace();

            return false;
        }
    }


    // =========================================================
    // UPDATE STATUS
    // =========================================================

    public boolean updateStatus(
            int id,
            String status) {

        String sql = """
                UPDATE packages
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
                    "Error updating package status:"
            );

            e.printStackTrace();

            return false;
        }
    }


    // =========================================================
    // SEARCH
    // =========================================================

    public List<Package> searchPackages(
            String keyword) {

        List<Package> packages =
                new ArrayList<>();

        String sql = """
                SELECT
                    id,
                    destination_id,
                    package_name,
                    package_type,
                    description,
                    price,
                    duration_days,
                    duration_nights,
                    max_people,
                    transportation_type,
                    status
                FROM packages
                WHERE package_name LIKE ?
                   OR package_type LIKE ?
                   OR transportation_type LIKE ?
                ORDER BY id DESC
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

            statement.setString(
                    3,
                    searchValue
            );

            ResultSet result =
                    statement.executeQuery();

            while (result.next()) {

                packages.add(
                        mapPackage(result)
                );
            }

        } catch (SQLException e) {

            System.out.println(
                    "Error searching packages:"
            );

            e.printStackTrace();
        }

        return packages;
    }


    // =========================================================
    // HELPER - ResultSet → Package
    // =========================================================

    private Package mapPackage(
            ResultSet result)
            throws SQLException {

        Package packageData =
                new Package();

        packageData.setId(
                result.getInt("id")
        );

        packageData.setDestinationId(
                result.getInt("destination_id")
        );

        packageData.setPackageName(
                result.getString("package_name")
        );

        packageData.setPackageType(
                result.getString("package_type")
        );

        packageData.setDescription(
                result.getString("description")
        );

        packageData.setPrice(
                result.getBigDecimal("price")
        );

        packageData.setDurationDays(
                result.getInt("duration_days")
        );

        packageData.setDurationNights(
                result.getInt("duration_nights")
        );

        packageData.setMaxPeople(
                result.getInt("max_people")
        );

        packageData.setTransportationType(
                result.getString("transportation_type")
        );

        packageData.setStatus(
                result.getString("status")
        );

        return packageData;
    }
}