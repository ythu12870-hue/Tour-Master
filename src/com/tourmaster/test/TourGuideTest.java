package com.tourmaster.test;

import com.tourmaster.dao.TourGuideDAO;
import com.tourmaster.model.TourGuide;

import java.util.List;

public class TourGuideTest {

    public static void main(String[] args) {

        TourGuideDAO guideDAO =
                new TourGuideDAO();


        // =====================================================
        // 1. ADD GUIDE
        // =====================================================

        TourGuide guide =
                new TourGuide(
                        "Aung Aung",
                        "Male",
                        "09123456789",
                        "aung@example.com",
                        "Myanmar, English",
                        5,
                        "Available"
                );

        boolean added =
                guideDAO.addTourGuide(guide);

        if (added) {

            System.out.println(
                    "Tour guide added successfully!"
            );

        } else {

            System.out.println(
                    "Failed to add tour guide!"
            );

            return;
        }


        // =====================================================
        // 2. GET ALL GUIDES
        // =====================================================

        System.out.println();
        System.out.println(
                "========== ALL TOUR GUIDES =========="
        );

        List<TourGuide> guides =
                guideDAO.getAllTourGuides();

        for (TourGuide g : guides) {

            System.out.println(g);
        }


        // =====================================================
        // 3. GET AVAILABLE GUIDES
        // =====================================================

        System.out.println();
        System.out.println(
                "========== AVAILABLE GUIDES =========="
        );

        List<TourGuide> availableGuides =
                guideDAO.getAvailableGuides();

        for (TourGuide g : availableGuides) {

            System.out.println(g);
        }


        // =====================================================
        // 4. FIND GUIDE
        // =====================================================

        if (!guides.isEmpty()) {

            int guideId =
                    guides.get(0).getId();

            TourGuide foundGuide =
                    guideDAO.getTourGuideById(
                            guideId
                    );

            System.out.println();
            System.out.println(
                    "========== FOUND GUIDE =========="
            );

            System.out.println(foundGuide);


            // =================================================
            // 5. UPDATE STATUS
            // =================================================

            boolean statusUpdated =
                    guideDAO.updateStatus(
                            guideId,
                            "Assigned"
                    );

            System.out.println();

            System.out.println(
                    "Status updated: "
                    + statusUpdated
            );


            // =================================================
            // 6. CHECK UPDATED GUIDE
            // =================================================

            TourGuide updatedGuide =
                    guideDAO.getTourGuideById(
                            guideId
                    );

            System.out.println();
            System.out.println(
                    "========== UPDATED GUIDE =========="
            );

            System.out.println(updatedGuide);
        }


        // =====================================================
        // FINISHED
        // =====================================================

        System.out.println();
        System.out.println(
                "======================================"
        );

        System.out.println(
                "Tour Guide module test completed!"
        );

        System.out.println(
                "======================================"
        );
    }
}