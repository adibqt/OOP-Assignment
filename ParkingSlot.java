public class ParkingSlot {
    private final int slotNumber;
    private Car car;

    public ParkingSlot(int slotNumber) {
        this.slotNumber = slotNumber;
        this.car = null;
    }

    public boolean parkCar(Car car) {
        if (this.car == null) {
            this.car = car;
            return true;
        }
        return false;
    }

    public boolean removeCar() {
        if (this.car != null) {
            this.car = null;
            return true;
        }
        return false;
    }

    public int getSlotNumber() {
        return slotNumber;
    }

    public Car getCar() {
        return car;
    }

    public boolean isOccupied() {
        return car != null;
    }
}