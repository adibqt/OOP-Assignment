public class ParkCarCommand implements Command {
    private final ParkingLotManager manager;

    public ParkCarCommand(ParkingLotManager manager) {
        this.manager = manager;
    }

    @Override
    public void execute(String[] args) {
        if (args.length != 3) {
            System.out.println("Invalid command format");
            return;
        }
        ParkingLot parkingLot = manager.getParkingLot();
        if (parkingLot == null) {
            System.out.println("Parking lot not created");
            return;
        }
        int slot = parkingLot.parkCar(args[1], args[2]);
        if (slot != -1) {
            System.out.println("Allocated slot number: " + slot);
        } else {
            System.out.println("Sorry, parking lot is full");
        }
    }
}