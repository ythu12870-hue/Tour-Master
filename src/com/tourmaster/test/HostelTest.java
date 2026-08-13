package com.tourmaster.test;

import com.tourmaster.dao.HostelDAO;
import com.tourmaster.model.Hostel;

import java.util.List;

public class HostelTest {

    public static void main(String[] args) {

        HostelDAO hostelDAO =
                new HostelDAO();

        // ==========================================
        // ADD HOSTEL
        // ==========================================

        Hostel hostel =
                new Hostel(
                        "Bagan View Hotel",
                        1,                  // destination_id
                        "Old Bagan, Myanmar",
                        "09234567890",
                        "Comfortable hotel near Bagan temples.",
                        4.5,
                        "Active"
                );

        boolean added =
                hostelDAO.addHostel(hostel);

        System.out.println(
                "Hostel added: " + added
        );


        // ==========================================
        // GET ALL HOSTELS
        // ==========================================

        System.out.println();
        System.out.println(
                "========== ALL HOSTELS =========="
        );

        List<Hostel> hostels =
                hostelDAO.getAllHostels();

        for (Hostel h : hostels) {
            System.out.println(h);
        }


        // ==========================================
        // GET ACTIVE HOSTELS
        // ==========================================

        System.out.println();
        System.out.println(
                "========== ACTIVE HOSTELS =========="
        );

        List<Hostel> activeHostels =
                hostelDAO.getActiveHostels();

        for (Hostel h : activeHostels) {
            System.out.println(h);
        }


        // ==========================================
        // GET BY DESTINATION
        // ==========================================

        System.out.println();
        System.out.println(
                "========== BAGAN HOSTELS =========="
        );

        List<Hostel> baganHostels =
                hostelDAO.getHostelsByDestination(1);

        for (Hostel h : baganHostels) {
            System.out.println(h);
        }


        // ==========================================
        // FIND ONE
        // ==========================================

        if (!hostels.isEmpty()) {

            int id =
                    hostels.get(0).getId();

            Hostel found =
                    hostelDAO.getHostelById(id);

            System.out.println();
            System.out.println(
                    "========== FOUND HOSTEL =========="
            );

            System.out.println(found);


            // ======================================
            // UPDATE STATUS
            // ======================================

            boolean updated =
                    hostelDAO.updateStatus(
                            id,
                            "Inactive"
                    );

            System.out.println();

            System.out.println(
                    "Status updated: " + updated
            );
        }


        System.out.println();
        System.out.println(
                "======================================"
        );

        System.out.println(
                "Hostel module test completed!"
        );

        System.out.println(
                "======================================"
        );
    }
}