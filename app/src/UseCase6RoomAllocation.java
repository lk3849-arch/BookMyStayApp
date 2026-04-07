public class UseCase6RoomAllocation {

    public static void main(String[] args) {

        System.out.println("Room Allocation Processing");

        // Step 1: Inventory
        RoomInventoryuc3 inventory = new RoomInventoryuc3();
        inventory.initializeInventory();

        // Step 2: Booking Queue (UC5 reuse)
        BookingRequestQueue queue = new BookingRequestQueue();

        queue.addRequest(new Reservation("Abhi", "Single"));
        queue.addRequest(new Reservation("Subha", "Single"));
        queue.addRequest(new Reservation("Vanmathi", "Suite"));

        // Step 3: Allocation Service
        RoomAllocationService allocator = new RoomAllocationService();

        // Step 4: Process FIFO
        while (queue.hasPendingRequests()) {
            Reservation r = queue.getNextRequest();
            allocator.allocateRoom(r, inventory);
        }
    }
}