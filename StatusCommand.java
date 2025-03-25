import java.util.List;

public class StatusCommand implements Command {
    private final ParkingLotManager manager;

    public StatusCommand(ParkingLotManager manager) {
        this.manager = manager;
    }

    @Override
    public void execute(String[] args) {
        ParkingLot parkingLot = manager.getParkingLot();
        if (parkingLot == null) {
            System.out.println("Parking lot not created");
            return;
        }
        List<ParkingLot.ParkingStatus> status = parkingLot.getStatus();
        if (status.isEmpty()) {
            System.out.println("Parking lot is empty");
        } else {
            System.out.println("Slot No.\tRegistration No.\tColor");
            for (ParkingLot.ParkingStatus ps : status) {
                System.out.println(ps);
            }
        }
    }
}