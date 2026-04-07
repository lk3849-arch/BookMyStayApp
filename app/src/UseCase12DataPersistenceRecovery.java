public class UseCase12DataPersistenceRecovery {

    public static void main(String[] args) {

        System.out.println("System Recovery");

        String filePath = "inventory.txt";

        RoomInventoryuc3 inventory = new RoomInventoryuc3();
        FilePersistenceService persistenceService = new FilePersistenceService();

        // Load inventory from file
        persistenceService.loadInventory(inventory, filePath);

        // Display current inventory
        System.out.println("\nCurrent Inventory:");
        System.out.println("Single: " + inventory.getRoomAvailability().get("Single"));
        System.out.println("Double: " + inventory.getRoomAvailability().get("Double"));
        System.out.println("Suite: " + inventory.getRoomAvailability().get("Suite"));

        // Save inventory again
        persistenceService.saveInventory(inventory, filePath);
    }
}