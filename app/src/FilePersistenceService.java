import java.io.*;
import java.util.Map;

public class FilePersistenceService {

    /**
     * Save inventory to file
     * Format: RoomType=Count
     */
    public void saveInventory(RoomInventoryuc3 inventory, String filePath) {

        try (BufferedWriter writer = new BufferedWriter(new FileWriter(filePath))) {

            for (Map.Entry<String, Integer> entry : inventory.getRoomAvailability().entrySet()) {
                writer.write(entry.getKey() + "=" + entry.getValue());
                writer.newLine();
            }

            System.out.println("Inventory saved successfully.");

        } catch (IOException e) {
            System.out.println("Error saving inventory: " + e.getMessage());
        }
    }

    /**
     * Load inventory from file
     */
    public void loadInventory(RoomInventoryuc3 inventory, String filePath) {

        File file = new File(filePath);

        // If file doesn't exist
        if (!file.exists()) {
            System.out.println("No valid inventory data found. Starting fresh.");
            inventory.initializeInventory();
            return;
        }

        try (BufferedReader reader = new BufferedReader(new FileReader(file))) {

            Map<String, Integer> availability = inventory.getRoomAvailability();
            availability.clear();

            String line;

            while ((line = reader.readLine()) != null) {

                String[] parts = line.split("=");

                if (parts.length == 2) {
                    String roomType = parts[0];
                    int count = Integer.parseInt(parts[1]);

                    availability.put(roomType, count);
                }
            }

        } catch (Exception e) {
            System.out.println("Error loading inventory. Starting fresh.");
            inventory.initializeInventory();
        }
    }
}