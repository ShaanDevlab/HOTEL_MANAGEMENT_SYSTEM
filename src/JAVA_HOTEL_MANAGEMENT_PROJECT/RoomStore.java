package JAVA_HOTEL_MANAGEMENT_PROJECT;

import java.util.HashMap;
import java.util.Map;

public class RoomStore {

    private static final Map<Integer, Boolean> roomOccupied = new HashMap<>();
    private static final Map<Integer, String> guestNameByRoom = new HashMap<>();

    public static boolean isRoomKnown(int roomNumber) {
        return roomOccupied.containsKey(roomNumber);
    }

    public static boolean isOccupied(int roomNumber) {
        return roomOccupied.getOrDefault(roomNumber, false);
    }

    public static String getGuestName(int roomNumber) {
        return guestNameByRoom.get(roomNumber);
    }

    public static void checkIn(int roomNumber, String guestName) {
        roomOccupied.put(roomNumber, true);
        guestNameByRoom.put(roomNumber, guestName);
    }

    public static void checkOut(int roomNumber) {
        roomOccupied.put(roomNumber, false);
        guestNameByRoom.remove(roomNumber);
    }

    public static void printAllRooms() {
        System.out.println("---- Current Room Status ----");
        if (roomOccupied.isEmpty()) {
            System.out.println("No rooms tracked yet.");
        } else {
            for (Map.Entry<Integer, Boolean> e : roomOccupied.entrySet()) {
                int room = e.getKey();
                boolean occupied = e.getValue();
                String guest = guestNameByRoom.get(room);
                if (occupied) {
                    System.out.println("Room " + room + ": OCCUPIED by " + guest);
                } else {
                    System.out.println("Room " + room + ": EMPTY");
                }
            }
        }
    }
}

