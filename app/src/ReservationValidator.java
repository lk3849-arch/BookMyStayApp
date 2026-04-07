import java.util.Map;

public class ReservationValidator {

    /**
     * Validates booking input
     */
    public void validate(
            String guestName,
            String roomType,
            RoomInventoryuc3 inventory
    ) throws InvalidBookingException {

        // Check guest name
        if (guestName == null || guestName.trim().isEmpty()) {
            throw new InvalidBookingException("Guest name cannot be empty.");
        }

        // Normalize input (important for case sensitivity)
        String normalizedRoomType =
                roomType.substring(0, 1).toUpperCase() +
                        roomType.substring(1).toLowerCase();

        Map<String, Integer> availability = inventory.getRoomAvailability();

        // Check valid room type
        if (!availability.containsKey(normalizedRoomType)) {
            throw new InvalidBookingException("Invalid room type selected.");
        }

        // Check availability
        if (availability.get(normalizedRoomType) <= 0) {
            throw new InvalidBookingException("No rooms available for selected type.");
        }
    }
}