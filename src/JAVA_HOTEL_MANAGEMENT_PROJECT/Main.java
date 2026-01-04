package JAVA_HOTEL_MANAGEMENT_PROJECT;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        int choice;

        do {
            System.out.println("\n=== Hotel Management – Console Demo ===");
            System.out.println("1. Guest and room details");
            System.out.println("2. Different room types");
            System.out.println("3. Booking behavior");
            System.out.println("4. Stay charge calculation");
            System.out.println("5. Show all rooms");
            System.out.println("0. Exit");
            System.out.print("Enter your choice: ");

            while (!scanner.hasNextInt()) {
                System.out.print("Please enter a number (0–5): ");
                scanner.next();
            }
            choice = scanner.nextInt();
            scanner.nextLine(); // consume newline

            switch (choice) {
                case 1 -> GuestRoomDetailsDemo.run(scanner);
                case 2 -> RoomTypesDemo.run(scanner);
                case 3 -> BookingBehaviorDemo.run(scanner);
                case 4 -> StayChargeDemo.run(scanner);
                case 5 -> RoomStore.printAllRooms();
                case 0 -> System.out.println("Exiting...");
                default -> System.out.println("Invalid choice, please try again.");
            }

        } while (choice != 0);

        scanner.close();
    }
}

