public class LeaveSlotCommand implements Command {
    private final ParkingLotManager manager;

    public LeaveSlotCommand(ParkingLotManager manager) {
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
        int slotNumber = Integer.parseInt(args[1]);
        if (parkingLot.leaveSlot(slotNumber)) {
            System.out.println("Slot number " + slotNumber + " is free");
        } else {
            System.out.println("Slot number " + slotNumber + " is already empty");
        }
    }
}