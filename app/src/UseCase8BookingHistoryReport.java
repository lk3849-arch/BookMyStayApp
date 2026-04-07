public class UseCase8BookingHistoryReport {

    public static void main(String[] args) {

        System.out.println("Booking History and Reporting");

        // Step 1: Create history
        BookingHistory history = new BookingHistory();

        // Step 2: Add confirmed reservations (simulate UC6 output)
        history.addReservation(new Reservation("Abhi", "Single"));
        history.addReservation(new Reservation("Subha", "Double"));
        history.addReservation(new Reservation("Vanmathi", "Suite"));

        // Step 3: Generate report
        BookingReportService reportService = new BookingReportService();
        reportService.generateReport(history);
    }
}