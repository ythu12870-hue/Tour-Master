package com.tourmaster.test;

import com.tourmaster.dao.DestinationDAO;
import com.tourmaster.model.Destination;

import java.util.List;

public class DestinationTest {

    public static void main(String[] args) {

        DestinationDAO destinationDAO =
                new DestinationDAO();

        // ==========================================
        // 1. ADD DESTINATION
        // ==========================================

        Destination destination =
                new Destination(
                        "Bagan",
                        "Ancient temples and historical places.",
                        "Mandalay Region, Myanmar",
                        "bagan.jpg",
                        "Active"
                );

        boolean added =
                destinationDAO.addDestination(destination);

        if (added) {
            System.out.println(
                    "Destination added successfully!"
            );
        } else {
            System.out.println(
                    "Failed to add destination!"
            );
        }


        // ==========================================
        // 2. DISPLAY ALL DESTINATIONS
        // ==========================================

        System.out.println();
        System.out.println(
                "===== ALL DESTINATIONS ====="
        );

        List<Destination> destinations =
                destinationDAO.getAllDestinations();

        for (Destination d : destinations) {

            System.out.println(
                    d
            );
        }


        // ==========================================
        // 3. SEARCH DESTINATION
        // ==========================================

        System.out.println();
        System.out.println(
                "===== SEARCH BAGAN ====="
        );

        List<Destination> searchResults =
                destinationDAO.searchDestinations(
                        "Bagan"
                );

        for (Destination d : searchResults) {

            System.out.println(d);
        }
    }
}