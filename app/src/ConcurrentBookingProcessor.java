public class ConcurrentBookingProcessor implements Runnable {

    private BookingRequestQueue bookingQueue;
    private RoomInventoryuc3 inventory;
    private RoomAllocationService allocationService;

    // Constructor
    public ConcurrentBookingProcessor(
            BookingRequestQueue bookingQueue,
            RoomInventoryuc3 inventory,
            RoomAllocationService allocationService) {

        this.bookingQueue = bookingQueue;
        this.inventory = inventory;
        this.allocationService = allocationService;
    }

    @Override
    public void run() {

        while (true) {

            Reservation reservation;

            // 🔒 Synchronize queue access
            synchronized (bookingQueue) {

                if (!bookingQueue.hasPendingRequests()) {
                    break; // stop thread if no requests
                }

                reservation = bookingQueue.getNextRequest();
            }

            // 🔒 Synchronize inventory (critical section)
            synchronized (inventory) {
                allocationService.allocateRoom(reservation, inventory);
            }
        }
    }
}