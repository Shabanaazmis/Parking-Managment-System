import java.util.ArrayList;
import java.util.Scanner;

public class ParkingManagement {

    static ArrayList<Vehicle> vehicles =
            new ArrayList<>();

    static Scanner sc = new Scanner(System.in);

    // Maximum parking slots
    static final int TOTAL_SLOTS = 10;

    // Park Vehicle
    public static void parkVehicle() {

        if (vehicles.size() >= TOTAL_SLOTS) {

            System.out.println(
                "Parking is full!"
            );

            return;
        }

        System.out.print(
            "Enter Vehicle Number: "
        );

        String vehicleNumber = sc.nextLine();

        System.out.print(
            "Enter Owner Name: "
        );

        String ownerName = sc.nextLine();

        System.out.print(
            "Enter Vehicle Type (Car/Bike): "
        );

        String vehicleType = sc.nextLine();

        int slotNumber = findAvailableSlot();

        Vehicle vehicle = new Vehicle(
            vehicleNumber,
            ownerName,
            vehicleType,
            slotNumber
        );

        vehicles.add(vehicle);

        System.out.println(
            "Vehicle parked successfully!"
        );

        System.out.println(
            "Assigned Parking Slot: "
            + slotNumber
        );
    }

    // Find available slot
    public static int findAvailableSlot() {

        for (int slot = 1; slot <= TOTAL_SLOTS; slot++) {

            boolean occupied = false;

            for (Vehicle v : vehicles) {

                if (v.getSlotNumber() == slot) {

                    occupied = true;
                    break;
                }
            }

            if (!occupied) {
                return slot;
            }
        }

        return -1;
    }

    // Display Parked Vehicles
    public static void displayVehicles() {

        if (vehicles.isEmpty()) {

            System.out.println(
                "No vehicles are currently parked."
            );

            return;
        }

        System.out.println(
            "\nVehicle No\tOwner\tType\tSlot"
        );

        System.out.println(
            "------------------------------------------"
        );

        for (Vehicle v : vehicles) {

            v.displayVehicle();
        }
    }

    // Search Vehicle
    public static void searchVehicle() {

        System.out.print(
            "Enter Vehicle Number to search: "
        );

        String number = sc.nextLine();

        boolean found = false;

        for (Vehicle v : vehicles) {

            if (v.getVehicleNumber()
                 .equalsIgnoreCase(number)) {

                System.out.println(
                    "\nVehicle Found"
                );

                System.out.println(
                    "Vehicle Number: "
                    + v.getVehicleNumber()
                );

                System.out.println(
                    "Owner Name: "
                    + v.getOwnerName()
                );

                System.out.println(
                    "Vehicle Type: "
                    + v.getVehicleType()
                );

                System.out.println(
                    "Parking Slot: "
                    + v.getSlotNumber()
                );

                found = true;

                break;
            }
        }

        if (!found) {

            System.out.println(
                "Vehicle not found."
            );
        }
    }

    // Remove Vehicle
    public static void removeVehicle() {

        System.out.print(
            "Enter Vehicle Number: "
        );

        String number = sc.nextLine();

        Vehicle foundVehicle = null;

        for (Vehicle v : vehicles) {

            if (v.getVehicleNumber()
                 .equalsIgnoreCase(number)) {

                foundVehicle = v;
                break;
            }
        }

        if (foundVehicle == null) {

            System.out.println(
                "Vehicle not found."
            );

            return;
        }

        System.out.print(
            "Enter number of parking hours: "
        );

        int hours = sc.nextInt();

        sc.nextLine();

        double fee = calculateFee(
            foundVehicle.getVehicleType(),
            hours
        );

        vehicles.remove(foundVehicle);

        System.out.println(
            "\nVehicle removed successfully!"
        );

        System.out.println(
            "Parking Slot: "
            + foundVehicle.getSlotNumber()
        );

        System.out.println(
            "Parking Hours: "
            + hours
        );

        System.out.println(
            "Parking Fee: ₹"
            + fee
        );
    }

    // Calculate Parking Fee
    public static double calculateFee(
            String vehicleType,
            int hours) {

        double rate;

        if (vehicleType.equalsIgnoreCase("Car")) {

            rate = 30;

        } else if (vehicleType.equalsIgnoreCase("Bike")) {

            rate = 15;

        } else {

            rate = 20;
        }

        return rate * hours;
    }

    // Display Available Slots
    public static void displayAvailableSlots() {

        System.out.println(
            "\nAvailable Parking Slots:"
        );

        boolean available = false;

        for (int slot = 1;
             slot <= TOTAL_SLOTS;
             slot++) {

            boolean occupied = false;

            for (Vehicle v : vehicles) {

                if (v.getSlotNumber() == slot) {

                    occupied = true;
                    break;
                }
            }

            if (!occupied) {

                System.out.print(
                    slot + " "
                );

                available = true;
            }
        }

        if (!available) {

            System.out.println(
                "No slots available."
            );

        } else {

            System.out.println();
        }
    }

    // Main Method
    public static void main(String[] args) {

        while (true) {

            System.out.println(
                "\n===== PARKING MANAGEMENT SYSTEM ====="
            );

            System.out.println(
                "1. Park Vehicle"
            );

            System.out.println(
                "2. Display Parked Vehicles"
            );

            System.out.println(
                "3. Search Vehicle"
            );

            System.out.println(
                "4. Remove Vehicle"
            );

            System.out.println(
                "5. Display Available Slots"
            );

            System.out.println(
                "6. Exit"
            );

            System.out.print(
                "Enter your choice: "
            );

            int choice = sc.nextInt();

            sc.nextLine();

            switch (choice) {

                case 1:
                    parkVehicle();
                    break;

                case 2:
                    displayVehicles();
                    break;

                case 3:
                    searchVehicle();
                    break;

                case 4:
                    removeVehicle();
                    break;

                case 5:
                    displayAvailableSlots();
                    break;

                case 6:

                    System.out.println(
                        "Thank you for using Parking Management System."
                    );

                    sc.close();

                    System.exit(0);

                default:

                    System.out.println(
                        "Invalid choice. Please try again."
                    );
            }
        }
    }
}