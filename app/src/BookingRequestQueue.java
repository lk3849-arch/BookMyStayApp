import java.util.LinkedList;
import java.util.Queue;

public class BookingRequestQueue {

    // Queue to store requests (FIFO)
    private Queue<Reservation> requestQueue;

    // Constructor
    public BookingRequestQueue() {
        requestQueue = new LinkedList<>();
    }

    // Add request to queue
    public void addRequest(Reservation reservation) {
        requestQueue.offer(reservation);
    }

    // Get next request (FIFO)
    public Reservation getNextRequest() {
        return requestQueue.poll();
    }

    // Check if queue is not empty
    public boolean hasPendingRequests() {
        return !requestQueue.isEmpty();
    }
}