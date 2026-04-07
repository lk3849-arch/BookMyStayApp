public class UseCase10BookingCancellation {

    public static void main(String[] args) {

        System.out.println("Booking Cancellation");

        // Step 1: Inventory
        RoomInventoryuc3 inventory = new RoomInventoryuc3();
        inventory.initializeInventory();

        // Step 2: Allocation simulation (UC6 output)
        CancellationService cancellationService = new CancellationService();

        // Assume these were allocated earlier
        cancellationService.registerBooking("Single-1", "Single");
        cancellationService.registerBooking("Single-2", "Single");
        cancellationService.registerBooking("Suite-1", "Suite");

        // Step 3: Cancel one booking
        cancellationService.cancelBooking("Single-1", inventory);

        // Step 4: Show rollback
        cancellationService.showRollbackHistory();

        // Step 5: Show updated inventory
        System.out.println("\nUpdated Single Room Availability: "
                + inventory.getRoomAvailability().get("Single"));
    }
}