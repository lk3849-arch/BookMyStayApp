public class uc2RoomInitialization {
    public static void main(String[] args) {

        Roomuc2 single = new SingleRoomuc2();
        Roomuc2 doubleRoom = new DoubleRoomuc2();
        Roomuc2 suite = new SuiteRoomuc2();

        int singleAvailable = 5;
        int doubleAvailable = 3;
        int suiteAvailable = 2;

        System.out.println("Hotel Room Initialization\n");

        System.out.println("Single Room:");
        single.displayRoomDetails();
        System.out.println("Available: " + singleAvailable);

        System.out.println("\nDouble Room:");
        doubleRoom.displayRoomDetails();
        System.out.println("Available: " + doubleAvailable);

        System.out.println("\nSuite Room:");
        suite.displayRoomDetails();
        System.out.println("Available: " + suiteAvailable);
    }
}