import java.util.List;

public class RegistrationNumbersByColorCommand implements Command {
    private final ParkingLotManager manager;

    public RegistrationNumbersByColorCommand(ParkingLotManager manager) {
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
        List<String> cars = parkingLot.getCarsByColor(args[1]);
        if (cars.isEmpty()) {
            System.out.println("Not found");
        } else {
            System.out.println(String.join(", ", cars));
        }
    }
}