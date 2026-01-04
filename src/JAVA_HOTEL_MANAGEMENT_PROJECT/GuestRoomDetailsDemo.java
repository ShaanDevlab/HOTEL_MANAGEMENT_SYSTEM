package JAVA_HOTEL_MANAGEMENT_PROJECT;

import java.util.Scanner;

class GuestRoomDetails {

    private int roomNumber;
    private String guestName;

    public GuestRoomDetails(int roomNumber, String guestName) {
        this.roomNumber = roomNumber;
        this.guestName = guestName;
    }

    // GETTERS
    public int getRoomNumber() {
        return roomNumber;
    }

    public String getGuestName() {
        return guestName;
    }

    // SETTERS (simple)
    public void setRoomNumber(int roomNumber) {
        this.roomNumber = roomNumber;
    }

    public void setGuestName(String guestName) {
        this.guestName = guestName;
    }
}

public class GuestRoomDetailsDemo {
    public static void run(Scanner scanner) {
        System.out.println("---- Guest and Room Details ----");

        System.out.print("Enter room number: ");
        int room = Integer.parseInt(scanner.nextLine());

        GuestRoomDetails details;

        if (RoomStore.isRoomKnown(room) && RoomStore.isOccupied(room)) {
            System.out.println("Room " + room + " is already occupied by " + RoomStore.getGuestName(room));
        } else {
            System.out.print("Enter guest name: ");
            String name = scanner.nextLine();

            details = new GuestRoomDetails(room, name);

            // Demo getters and setters
            System.out.println("Original: Room=" + details.getRoomNumber() + ", Guest=" + details.getGuestName());

            System.out.print("New guest name? ");
            String newName = scanner.nextLine();
            details.setGuestName(newName);

            System.out.print("New room number? ");
            int newRoom = Integer.parseInt(scanner.nextLine());
            details.setRoomNumber(newRoom);

            System.out.println("Updated: Room=" + details.getRoomNumber() + ", Guest=" + details.getGuestName());

            RoomStore.checkIn(details.getRoomNumber(), details.getGuestName());
        }
    }
}
