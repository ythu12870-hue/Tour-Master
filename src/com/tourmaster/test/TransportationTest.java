package com.tourmaster.test;

import com.tourmaster.dao.TransportationDAO;
import com.tourmaster.dao.BusDAO;
import com.tourmaster.dao.BusSeatDAO;

import com.tourmaster.model.Transportation;
import com.tourmaster.model.Bus;
import com.tourmaster.model.BusSeat;

import java.util.List;

public class TransportationTest {

    public static void main(String[] args) {

        TransportationDAO transportationDAO =
                new TransportationDAO();

        BusDAO busDAO =
                new BusDAO();

        BusSeatDAO busSeatDAO =
                new BusSeatDAO();


        // =====================================================
        // 1. ADD VIP TRANSPORTATION
        // =====================================================

        Transportation vipCar =
                new Transportation(
                        1,              // Package ID
                        "Car",
                        "Toyota Alphard",
                        "MDY-1234",
                        2,
                        "Active"
                );

        boolean carAdded =
                transportationDAO.addTransportation(vipCar);

        if (carAdded) {
            System.out.println(
                    "VIP Car added successfully!"
            );
        } else {
            System.out.println(
                    "Failed to add VIP Car!"
            );
        }


        // =====================================================
        // 2. ADD NORMAL BUS TRANSPORTATION
        // =====================================================

        Transportation normalBus =
                new Transportation(
                        2,              // Package ID
                        "Bus",
                        "Tour Master Bus",
                        "MDY-5678",
                        40,
                        "Active"
                );

        boolean busTransportAdded =
                transportationDAO.addTransportation(
                        normalBus
                );

        if (busTransportAdded) {
            System.out.println(
                    "Normal Bus transportation added successfully!"
            );
        } else {
            System.out.println(
                    "Failed to add Normal Bus transportation!"
            );
        }


        // =====================================================
        // 3. GET ALL TRANSPORTATION
        // =====================================================

        System.out.println();
        System.out.println(
                "========== TRANSPORTATION =========="
        );

        List<Transportation> transportations =
                transportationDAO.getAllTransportations();

        for (Transportation t : transportations) {
            System.out.println(t);
        }


        // =====================================================
        // 4. FIND BUS TRANSPORTATION
        // =====================================================

        Transportation foundBus =
                transportationDAO
                        .getTransportationByPackage(2);

        if (foundBus != null) {

            System.out.println();
            System.out.println(
                    "Bus Transportation Found:"
            );

            System.out.println(foundBus);
        }


        // =====================================================
        // 5. CREATE BUS
        // =====================================================

        if (foundBus != null) {

            Bus bus =
                    new Bus(
                            foundBus.getId(),
                            "Tour Master Express",
                            "MDY-BUS-001",
                            40,
                            "2x2",
                            "Active"
                    );

            boolean busAdded =
                    busDAO.addBus(bus);

            if (busAdded) {

                System.out.println();
                System.out.println(
                        "Bus added successfully!"
                );

            } else {

                System.out.println(
                        "Failed to add bus!"
                );
            }
        }


        // =====================================================
        // 6. FIND BUS
        // =====================================================

        Bus foundBusObject = null;

        if (foundBus != null) {

            foundBusObject =
                    busDAO.getBusByTransportation(
                            foundBus.getId()
                    );
        }

        if (foundBusObject != null) {

            System.out.println();
            System.out.println(
                    "Bus Found:"
            );

            System.out.println(foundBusObject);
        }


        // =====================================================
        // 7. CREATE BUS SEATS
        // =====================================================

        if (foundBusObject != null) {

            String[] seatNumbers = {
                    "A1", "A2",
                    "A3", "A4",
                    "B1", "B2",
                    "B3", "B4",
                    "C1", "C2",
                    "C3", "C4",
                    "D1", "D2",
                    "D3", "D4"
            };

            for (String seatNumber : seatNumbers) {

                BusSeat seat =
                        new BusSeat(
                                foundBusObject.getId(),
                                seatNumber,
                                "Regular",
                                "Available"
                        );

                boolean seatAdded =
                        busSeatDAO.addSeat(seat);

                if (!seatAdded) {

                    System.out.println(
                            "Failed to add seat: "
                            + seatNumber
                    );
                }
            }

            System.out.println();
            System.out.println(
                    "Bus seats created successfully!"
            );
        }


        // =====================================================
        // 8. SHOW ALL BUS SEATS
        // =====================================================

        if (foundBusObject != null) {

            System.out.println();
            System.out.println(
                    "========== BUS SEATS =========="
            );

            List<BusSeat> seats =
                    busSeatDAO.getSeatsByBus(
                            foundBusObject.getId()
                    );

            for (BusSeat seat : seats) {

                System.out.println(seat);
            }
        }


        // =====================================================
        // 9. SHOW AVAILABLE SEATS
        // =====================================================

        if (foundBusObject != null) {

            System.out.println();
            System.out.println(
                    "========== AVAILABLE SEATS =========="
            );

            List<BusSeat> availableSeats =
                    busSeatDAO.getAvailableSeats(
                            foundBusObject.getId()
                    );

            for (BusSeat seat : availableSeats) {

                System.out.println(
                        seat.getSeatNumber()
                        + " - "
                        + seat.getStatus()
                );
            }
        }


        // =====================================================
        // FINISHED
        // =====================================================

        System.out.println();
        System.out.println(
                "========================================"
        );

        System.out.println(
                "Transportation module test completed!"
        );

        System.out.println(
                "========================================"
        );
    }
}