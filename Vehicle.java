public class Vehicle {

    private String vehicleNumber;
    private String ownerName;
    private String vehicleType;
    private int slotNumber;

    // Constructor
    public Vehicle(String vehicleNumber,
                   String ownerName,
                   String vehicleType,
                   int slotNumber) {

        this.vehicleNumber = vehicleNumber;
        this.ownerName = ownerName;
        this.vehicleType = vehicleType;
        this.slotNumber = slotNumber;
    }

    // Getters

    public String getVehicleNumber() {
        return vehicleNumber;
    }

    public String getOwnerName() {
        return ownerName;
    }

    public String getVehicleType() {
        return vehicleType;
    }

    public int getSlotNumber() {
        return slotNumber;
    }

    // Display vehicle details
    public void displayVehicle() {

        System.out.println(
            vehicleNumber + "\t" +
            ownerName + "\t" +
            vehicleType + "\t" +
            slotNumber
        );
    }
}