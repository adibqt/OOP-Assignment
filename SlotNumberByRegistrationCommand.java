public class SlotNumberByRegistrationCommand implements Command {
    private final ParkingLotManager manager;

    public SlotNumberByRegistrationCommand(ParkingLotManager manager) {
        this.manager = manager;
    }

    @Override
    public void execute(String[] args) {
        if (args.length != 2) {
            System.out.println("Invalid command format");
            return;
        }
        ParkingLot parkingLot = manager.getParkingLot();
        if (parkingLot == null) {
            System.out.println("Parking lot not created");
            return;
        }
        int slot = parkingLot.getSlotByRegistration(args[1]);
        if (slot != -1) {
            System.out.println(slot);
        } else {
            System.out.println("Not found");
        }
    }
}