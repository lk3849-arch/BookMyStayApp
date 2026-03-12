import java.util.HashMap;
import java.util.Map;

/**
 * ------------------------------------------------------------
 * CLASS - RoomInventory
 * ------------------------------------------------------------
 *
 * Use Case 3: Centralized Room Inventory Management
 *
 * @version 3.1
 */

public class RoomInventoryuc3 {

    /**
     * Stores available room count for each room type.
     * Key   -> Room type name
     * Value -> Available room count
     */
    private Map<String, Integer> roomAvailability;

    /**
     * Constructor initializes the inventory
     */
    public RoomInventoryuc3() {
        roomAvailability = new HashMap<>();
        initializeInventory();
    }

    /**
     * Initializes room availability data
     */
    private void initializeInventory() {
        roomAvailability.put("Single", 5);
        roomAvailability.put("Double", 3);
        roomAvailability.put("Suite", 2);
    }

    /**
     * Returns availability map
     */
    public Map<String, Integer> getRoomAvailability() {
        return roomAvailability;
    }

    /**
     * Updates availability
     */
    public void updateAvailability(String roomType, int count) {
        roomAvailability.put(roomType, count);
    }
}