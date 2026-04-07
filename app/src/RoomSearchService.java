import java.util.Map;

public class RoomSearchService {

    /**
     * Use Case 4:
     * Displays only available rooms (READ-ONLY)
     */
    public void searchAvailableRooms(
            RoomInventoryuc3 inventory,
            SingleRoomuc2 singleRoom,
            DoubleRoomuc2 doubleRoom,
            SuiteRoomuc2 suiteRoom) {

        // Get availability (read-only)
        Map<String, Integer> availability = inventory.getRoomAvailability();

        System.out.println("Room Search\n");

        // Single Room
        if (availability.get("Single") != null && availability.get("Single") > 0) {
            System.out.println("Single Room:");
            display(singleRoom, availability.get("Single"));
        }

        // Double Room
        if (availability.get("Double") != null && availability.get("Double") > 0) {
            System.out.println("\nDouble Room:");
            display(doubleRoom, availability.get("Double"));
        }

        // Suite Room
        if (availability.get("Suite") != null && availability.get("Suite") > 0) {
            System.out.println("\nSuite Room:");
            display(suiteRoom, availability.get("Suite"));
        }
    }

    private void display(Roomuc2 room, int available) {
        room.displayRoomDetails();   // reuse existing method
        System.out.println("Available: " + available);
    }
}