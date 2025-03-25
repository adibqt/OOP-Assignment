import java.util.List;

public class SlotNumbersByColorCommand implements Command {
    private final ParkingLotManager manager;

    public SlotNumbersByColorCommand(ParkingLotManager manager) {
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
        List<Integer> slots = parkingLot.getSlotsByColor(args[1]);
        if (slots.isEmpty()) {
            System.out.println("Not found");
        } else {
            System.out.println(String.join(", ", slots.stream()
                    .map(String::valueOf)
                    .toArray(String[]::new)));
        }
    }
}