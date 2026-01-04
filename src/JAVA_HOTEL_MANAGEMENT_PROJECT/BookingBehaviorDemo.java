package JAVA_HOTEL_MANAGEMENT_PROJECT;

import java.util.Scanner;

class Booking {
    public void describeBooking() {
        System.out.println("General booking");
    }
}

class StandardBooking extends Booking {
    @Override
    public void describeBooking() {
        System.out.println("Standard room booking: Basic facilities.");
    }
}

class DeluxeBooking extends Booking {
    @Override
    public void describeBooking() {
        System.out.println("Deluxe room booking: Extra comfort and facilities.");
    }
}

public class BookingBehaviorDemo {
    public static void run(Scanner scanner) {
        System.out.println("---- Booking Behavior ----");

        System.out.print("Enter room number to view status: ");
        int room = Integer.parseInt(scanner.nextLine());

        if (RoomStore.isRoomKnown(room)) {
            if (RoomStore.isOccupied(room)) {
                System.out.println("Room " + room + " is occupied by " + RoomStore.getGuestName(room));
            } else {
                System.out.println("Room " + room + " is currently empty.");
            }
        } else {
            System.out.println("Room " + room + " is not yet tracked.");
        }

        System.out.print("Choose booking type (1 = standard, 2 = deluxe): ");
        String choice = scanner.nextLine();

        Booking booking;
        if ("1".equals(choice)) {
            booking = new StandardBooking();
        } else {
            booking = new DeluxeBooking();
        }

        booking.describeBooking();
    }
}
