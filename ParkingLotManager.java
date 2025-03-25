public class ParkingLotManager {
    private ParkingLot parkingLot;

    public void createParkingLot(int size) {
        parkingLot = new ParkingLot(size);
    }

    public ParkingLot getParkingLot() {
        return parkingLot;
    }
}