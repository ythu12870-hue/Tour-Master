package com.tourmaster.test;

import com.tourmaster.dao.PackageDAO;
import com.tourmaster.model.Package;

import java.math.BigDecimal;
import java.util.List;

public class PackageTest {

    public static void main(String[] args) {

        PackageDAO packageDAO =
                new PackageDAO();


        // =====================================================
        // 1. ADD VIP PACKAGE
        // =====================================================

        Package vipPackage =
                new Package(
                        1,                          // Bagan ID
                        "Bagan VIP Tour",
                        "VIP",
                        "Private Bagan tour with car and tour guide.",
                        new BigDecimal("450000.00"),
                        2,
                        1,
                        2,
                        "Car",
                        "Active"
                );

        boolean vipAdded =
                packageDAO.addPackage(vipPackage);

        if (vipAdded) {

            System.out.println(
                    "VIP package added successfully!"
            );

        } else {

            System.out.println(
                    "Failed to add VIP package!"
            );
        }


        // =====================================================
        // 2. ADD NORMAL PACKAGE
        // =====================================================

        Package normalPackage =
                new Package(
                        1,                          // Bagan ID
                        "Bagan Normal Tour",
                        "Normal",
                        "Group Bagan tour by bus with tour guide.",
                        new BigDecimal("180000.00"),
                        2,
                        1,
                        40,
                        "Bus",
                        "Active"
                );

        boolean normalAdded =
                packageDAO.addPackage(normalPackage);

        if (normalAdded) {

            System.out.println(
                    "Normal package added successfully!"
            );

        } else {

            System.out.println(
                    "Failed to add Normal package!"
            );
        }


        // =====================================================
        // 3. GET ALL PACKAGES
        // =====================================================

        System.out.println();
        System.out.println(
                "========== ALL PACKAGES =========="
        );

        List<Package> packages =
                packageDAO.getAllPackages();

        for (Package p : packages) {

            System.out.println(p);
        }


        // =====================================================
        // 4. GET VIP PACKAGES
        // =====================================================

        System.out.println();
        System.out.println(
                "========== VIP PACKAGES =========="
        );

        List<Package> vipPackages =
                packageDAO.getVipPackages();

        for (Package p : vipPackages) {

            System.out.println(p);
        }


        // =====================================================
        // 5. GET NORMAL PACKAGES
        // =====================================================

        System.out.println();
        System.out.println(
                "========== NORMAL PACKAGES =========="
        );

        List<Package> normalPackages =
                packageDAO.getNormalPackages();

        for (Package p : normalPackages) {

            System.out.println(p);
        }


        // =====================================================
        // 6. GET PACKAGES FOR BAGAN
        // =====================================================

        System.out.println();
        System.out.println(
                "========== BAGAN PACKAGES =========="
        );

        List<Package> baganPackages =
                packageDAO.getPackagesByDestination(1);

        for (Package p : baganPackages) {

            System.out.println(p);
        }
    }
}