import java.util.ArrayList;
import java.util.List;

public class BookingHistory {

    // List to store confirmed reservations
    private List<Reservation> confirmedReservations;

    // Constructor
    public BookingHistory() {
        confirmedReservations = new ArrayList<>();
    }

    // Add confirmed reservation
    public void addReservation(Reservation reservation) {
        confirmedReservations.add(reservation);
    }

    // Get all reservations
    public List<Reservation> getConfirmedReservations() {
        return confirmedReservations;
    }
}