package JAVA_HOTEL_MANAGEMENT_PROJECT;

import java.util.Scanner;

abstract class StayChargeCalculator {
    protected int roomNumber;
    protected double nightlyRate;

    public StayChargeCalculator(int roomNumber, double nightlyRate) {
        this.roomNumber = roomNumber;
        this.nightlyRate = nightlyRate;
    }

    public abstract double calculateCharge(int nights);

    public void showInfo() {
        System.out.println("Room " + roomNumber + " nightly rate: " + nightlyRate);
    }
}

class StandardStayCalculator extends StayChargeCalculator {
    public StandardStayCalculator(int roomNumber, double nightlyRate) {
        super(roomNumber, nightlyRate);
    }

    @Override
    public double calculateCharge(int nights) {
        return nightlyRate * nights;
    }
}

public class StayChargeDemo {
    public static void run(Scanner scanner) {
        System.out.println("---- Stay Charge Calculation ----");

        System.out.print("Enter room number: ");
        int room = Integer.parseInt(scanner.nextLine());

        if (RoomStore.isRoomKnown(room) && RoomStore.isOccupied(room)) {
            System.out.println("Room " + room + " is occupied by " + RoomStore.getGuestName(room));
        } else {
            System.out.println("Room " + room + " currently has no guest.");
        }

        System.out.print("Enter nightly rate: ");
        double rate = Double.parseDouble(scanner.nextLine());

        System.out.print("Enter number of nights: ");
        int nights = Integer.parseInt(scanner.nextLine());

        StayChargeCalculator calc = new StandardStayCalculator(room, rate);
        calc.showInfo();
        double total = calc.calculateCharge(nights);
        System.out.println("Total charge for " + nights + " nights: " + total);
    }
}

