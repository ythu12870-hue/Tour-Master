package com.tourmaster.dao;

import com.tourmaster.config.DatabaseConnection;
import com.tourmaster.model.TourGuide;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class TourGuideDAO {


    // =========================================================
    // ADD TOUR GUIDE
    // =========================================================

    public boolean addTourGuide(TourGuide guide) {

        String sql = """
                INSERT INTO tour_guides
                (
                    full_name,
                    gender,
                    phone,
                    email,
                    language,
                    experience_years,
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
                    guide.getFullName()
            );

            statement.setString(
                    2,
                    guide.getGender()
            );

            statement.setString(
                    3,
                    guide.getPhone()
            );

            statement.setString(
                    4,
                    guide.getEmail()
            );

            statement.setString(
                    5,
                    guide.getLanguages()
            );

            statement.setInt(
                    6,
                    guide.getExperienceYears()
            );

            statement.setString(
                    7,
                    guide.getStatus()
            );

            return statement.executeUpdate() > 0;

        } catch (SQLException e) {

            System.out.println(
                    "Error adding tour guide:"
            );

            e.printStackTrace();

            return false;
        }
    }


    // =========================================================
    // GET GUIDE BY ID
    // =========================================================

    public TourGuide getTourGuideById(int id) {

        String sql = """
                SELECT *
                FROM tour_guides
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

                return mapTourGuide(result);
            }

        } catch (SQLException e) {

            e.printStackTrace();
        }

        return null;
    }


    // =========================================================
    // GET ALL GUIDES
    // =========================================================

    public List<TourGuide> getAllTourGuides() {

        List<TourGuide> guides =
                new ArrayList<>();

        String sql = """
                SELECT *
                FROM tour_guides
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

                guides.add(
                        mapTourGuide(result)
                );
            }

        } catch (SQLException e) {

            e.printStackTrace();
        }

        return guides;
    }


    // =========================================================
    // GET AVAILABLE GUIDES
    // =========================================================

    public List<TourGuide> getAvailableGuides() {

        List<TourGuide> guides =
                new ArrayList<>();

        String sql = """
                SELECT *
                FROM tour_guides
                WHERE status = 'Available'
                ORDER BY full_name
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

                guides.add(
                        mapTourGuide(result)
                );
            }

        } catch (SQLException e) {

            e.printStackTrace();
        }

        return guides;
    }


    // =========================================================
    // UPDATE GUIDE
    // =========================================================

    public boolean updateTourGuide(
            TourGuide guide) {

        String sql = """
                UPDATE tour_guides
                SET
                    full_name = ?,
                    gender = ?,
                    phone = ?,
                    email = ?,
                    language = ?,
                    experience_years = ?,
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
                    guide.getFullName()
            );

            statement.setString(
                    2,
                    guide.getGender()
            );

            statement.setString(
                    3,
                    guide.getPhone()
            );

            statement.setString(
                    4,
                    guide.getEmail()
            );

            statement.setString(
                    5,
                    guide.getLanguages()
            );

            statement.setInt(
                    6,
                    guide.getExperienceYears()
            );

            statement.setString(
                    7,
                    guide.getStatus()
            );

            statement.setInt(
                    8,
                    guide.getId()
            );

            return statement.executeUpdate() > 0;

        } catch (SQLException e) {

            e.printStackTrace();

            return false;
        }
    }


    // =========================================================
    // UPDATE STATUS
    // =========================================================

    public boolean updateStatus(
            int guideId,
            String status) {

        String sql = """
                UPDATE tour_guides
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
            statement.setInt(2, guideId);

            return statement.executeUpdate() > 0;

        } catch (SQLException e) {

            e.printStackTrace();

            return false;
        }
    }


    // =========================================================
    // DELETE GUIDE
    // =========================================================

    public boolean deleteTourGuide(int id) {

        String sql = """
                DELETE FROM tour_guides
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
                    "Cannot delete tour guide."
            );

            e.printStackTrace();

            return false;
        }
    }


    // =========================================================
    // HELPER
    // =========================================================

    private TourGuide mapTourGuide(
            ResultSet result)
            throws SQLException {

        TourGuide guide =
                new TourGuide();

        guide.setId(
                result.getInt("id")
        );

        guide.setFullName(
                result.getString("full_name")
        );

        guide.setGender(
                result.getString("gender")
        );

        guide.setPhone(
                result.getString("phone")
        );

        guide.setEmail(
                result.getString("email")
        );

        guide.setLanguages(
                result.getString("languages")
        );

        guide.setExperienceYears(
                result.getInt("experience_years")
        );

        guide.setStatus(
                result.getString("status")
        );

        return guide;
    }
}