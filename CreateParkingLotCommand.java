public class CreateParkingLotCommand implements Command {
    private final ParkingLotManager manager;

    public CreateParkingLotCommand(ParkingLotManager manager) {
        this.manager = manager;
    }

    @Override
    public void execute(String[] args) {
        if (args.length != 2) {
            System.out.println("Invalid command format");
            return;
        }
        int size = Integer.parseInt(args[1]);
        manager.createParkingLot(size);
        System.out.println("Created a parking lot with " + size + " slots");
    }
}