package JAVA_HOTEL_MANAGEMENT_PROJECT;

import java.util.Scanner;


class BasicRoom {
    protected int roomNumber;
    protected boolean occupied;

    public BasicRoom(int roomNumber, boolean occupied) {
        this.roomNumber = roomNumber;
        this.occupied = occupied;
    }

    public void showStatus() {
        System.out.println("Room " + roomNumber + " status: " + (occupied ? "Occupied" : "Empty"));
    }
}


class StandardRoom extends BasicRoom {
    public StandardRoom(int roomNumber, boolean occupied) {
        super(roomNumber, occupied);
    }

    public void showFacilities() {
        System.out.println("Standard room: Fan, TV, Free Wi‑Fi");
    }
}


class SuiteRoom extends StandardRoom {
    public SuiteRoom(int roomNumber, boolean occupied) {
        super(roomNumber, occupied);
    }

    public void showExtra() {
        System.out.println("Suite: Separate living area, complimentary breakfast");
    }
}

public class RoomTypesDemo {
    public static void run(Scanner scanner) {
        System.out.println("---- Different Room Types (Single & Multilevel) ----");

        // Example 1: single-level
        System.out.println("\nExample 1: Standard room");
        System.out.print("Enter room number: ");
        int stdRoomNo = Integer.parseInt(scanner.nextLine());
        boolean stdOcc = RoomStore.isRoomKnown(stdRoomNo) && RoomStore.isOccupied(stdRoomNo);

        StandardRoom standard = new StandardRoom(stdRoomNo, stdOcc);
        standard.showStatus();
        standard.showFacilities();

        // Example 2: multilevel
        System.out.println("\nExample 2: Suite room");
        System.out.print("Enter room number: ");
        int suiteRoomNo = Integer.parseInt(scanner.nextLine());
        boolean suiteOcc = RoomStore.isRoomKnown(suiteRoomNo) && RoomStore.isOccupied(suiteRoomNo);

        SuiteRoom suite = new SuiteRoom(suiteRoomNo, suiteOcc);
        suite.showStatus();
        suite.showFacilities();
        suite.showExtra();
    }
}
