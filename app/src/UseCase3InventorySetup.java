/**
 * ------------------------------------------------------------
 * MAIN CLASS - UseCase3InventorySetup
 * ------------------------------------------------------------
 *
 * Use Case 3: Centralized Room Inventory Management
 *
 * @version 3.1
 */

public class UseCase3InventorySetup {

    public static void main(String[] args) {

        System.out.println("Hotel Room Inventory Status\n");

        RoomInventoryuc3 inventory = new RoomInventoryuc3();

        Roomuc2 single = new SingleRoomuc2();
        Roomuc2 doubleRoom = new DoubleRoomuc2();
        Roomuc2 suite = new SuiteRoomuc2();

        System.out.println("Single Room:");
        single.displayRoomDetails();
        System.out.println("Available Rooms: " + inventory.getRoomAvailability().get("Single"));

        System.out.println("\nDouble Room:");
        doubleRoom.displayRoomDetails();
        System.out.println("Available Rooms: " + inventory.getRoomAvailability().get("Double"));

        System.out.println("\nSuite Room:");
        suite.displayRoomDetails();
        System.out.println("Available Rooms: " + inventory.getRoomAvailability().get("Suite"));
    }
}