package com.tourmaster.test;

import com.tourmaster.dao.BookingDAO;
import com.tourmaster.dao.BookingPassengerDAO;
import com.tourmaster.dao.BookingSeatDAO;

import com.tourmaster.model.Booking;
import com.tourmaster.model.BookingPassenger;
import com.tourmaster.model.BookingSeat;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;

public class BookingTest {

    public static void main(String[] args) {

        BookingDAO bookingDAO =
                new BookingDAO();

        BookingPassengerDAO passengerDAO =
                new BookingPassengerDAO();

        BookingSeatDAO bookingSeatDAO =
                new BookingSeatDAO();


        // =====================================================
        // 1. CREATE BOOKING
        // =====================================================

        Booking booking =
                new Booking(
                        "TM-20260812-001",
                        2,                  // Customer ID
                        1,                  // Package ID
                        LocalDate.of(
                                2026,
                                9,
                                15
                        ),
                        2,
                        new BigDecimal(
                                "900000.00"
                        ),
                        "Pending"
                );


        boolean bookingAdded =
                bookingDAO.addBooking(booking);

        if (!bookingAdded) {

            System.out.println(
                    "Failed to create booking!"
            );

            return;
        }

        System.out.println(
                "Booking created successfully!"
        );


        // =====================================================
        // 2. FIND BOOKING
        // =====================================================

        Booking savedBooking =
                bookingDAO.getBookingByCode(
                        "TM-20260812-001"
                );

        if (savedBooking == null) {

            System.out.println(
                    "Booking could not be found!"
            );

            return;
        }


        System.out.println();
        System.out.println(
                "========== BOOKING =========="
        );

        System.out.println(
                savedBooking
        );


        int bookingId =
                savedBooking.getId();


        // =====================================================
        // 3. ADD PASSENGER 1
        // =====================================================

        BookingPassenger passenger1 =
                new BookingPassenger(
                        bookingId,
                        "Ye Win Thu",
                        "Male",
                        "12/LATHANA(N)123456",
                        "09123456789"
                );

        boolean passenger1Added =
                passengerDAO.addPassenger(
                        passenger1
                );

        System.out.println(
                "Passenger 1: "
                + passenger1Added
        );


        // =====================================================
        // 4. ADD PASSENGER 2
        // =====================================================

        BookingPassenger passenger2 =
                new BookingPassenger(
                        bookingId,
                        "Example Passenger",
                        "Female",
                        "12/LATHANA(N)654321",
                        "09876543210"
                );

        boolean passenger2Added =
                passengerDAO.addPassenger(
                        passenger2
                );

        System.out.println(
                "Passenger 2: "
                + passenger2Added
        );


        // =====================================================
        // 5. SHOW PASSENGERS
        // =====================================================

        System.out.println();
        System.out.println(
                "========== PASSENGERS =========="
        );

        List<BookingPassenger> passengers =
                passengerDAO.getPassengersByBooking(
                        bookingId
                );

        for (BookingPassenger passenger :
                passengers) {

            System.out.println(
                    passenger
            );
        }


        // =====================================================
        // 6. ADD SELECTED SEATS
        // =====================================================
        //
        // Only do this for a NORMAL package.
        //
        // These are example seat IDs.
        // Make sure seats 1 and 2 actually exist
        // in your bus_seats table.
        // =====================================================

        BookingSeat seat1 =
                new BookingSeat(
                        bookingId,
                        1
                );

        boolean seat1Added =
                bookingSeatDAO.addBookingSeat(
                        seat1
                );

        System.out.println(
                "Seat 1 booking: "
                + seat1Added
        );


        BookingSeat seat2 =
                new BookingSeat(
                        bookingId,
                        2
                );

        boolean seat2Added =
                bookingSeatDAO.addBookingSeat(
                        seat2
                );

        System.out.println(
                "Seat 2 booking: "
                + seat2Added
        );


        // =====================================================
        // 7. SHOW BOOKED SEATS
        // =====================================================

        System.out.println();
        System.out.println(
                "========== BOOKING SEATS =========="
        );

        List<BookingSeat> seats =
                bookingSeatDAO.getSeatsByBooking(
                        bookingId
                );

        for (BookingSeat seat : seats) {

            System.out.println(seat);
        }


        // =====================================================
        // 8. CHECK A SEAT
        // =====================================================

        System.out.println();
        System.out.println(
                "========== SEAT CHECK =========="
        );

        boolean booked =
                bookingSeatDAO.isSeatBooked(1);

        System.out.println(
                "Seat ID 1 booked: "
                + booked
        );


        // =====================================================
        // 9. FINISHED
        // =====================================================

        System.out.println();
        System.out.println(
                "======================================"
        );

        System.out.println(
                "Booking module test completed!"
        );

        System.out.println(
                "======================================"
        );
    }
}