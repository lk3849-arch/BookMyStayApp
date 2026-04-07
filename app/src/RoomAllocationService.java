import java.util.*;

public class RoomAllocationService {

    // Store all allocated room IDs (global uniqueness)
    private Set<String> allocatedRoomIds;

    // Store allocated IDs by room type
    private Map<String, Set<String>> assignedRoomsByType;

    // Constructor
    public RoomAllocationService() {
        allocatedRoomIds = new HashSet<>();
        assignedRoomsByType = new HashMap<>();
    }

    /**
     * Allocates room for a reservation
     */
    public void allocateRoom(Reservation reservation, RoomInventoryuc3 inventory) {

        String roomType = reservation.getRoomType();

        Map<String, Integer> availability = inventory.getRoomAvailability();

        // Check availability
        if (availability.get(roomType) == null || availability.get(roomType) <= 0) {
            System.out.println("No rooms available for " + reservation.getGuestName());
            return;
        }

        // Generate unique room ID
        String roomId = generateRoomId(roomType);

        // Store globally
        allocatedRoomIds.add(roomId);

        // Store by type
        assignedRoomsByType
                .computeIfAbsent(roomType, k -> new HashSet<>())
                .add(roomId);

        // Update inventory (VERY IMPORTANT)
        availability.put(roomType, availability.get(roomType) - 1);

        // Confirmation message
        System.out.println("Booking confirmed for Guest: "
                + reservation.getGuestName()
                + ", Room ID: " + roomId);
    }

    /**
     * Generate unique room ID
     * Example: Single-1, Single-2
     */
    private String generateRoomId(String roomType) {

        int count = assignedRoomsByType
                .getOrDefault(roomType, new HashSet<>())
                .size() + 1;

        String roomId = roomType + "-" + count;

        // Safety check (avoid duplicate)
        while (allocatedRoomIds.contains(roomId)) {
            count++;
            roomId = roomType + "-" + count;
        }

        return roomId;
    }
}