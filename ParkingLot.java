import java.util.ArrayList;
import java.util.List;

public class ParkingLot {
    private final int totalSlots;
    private final List<ParkingSlot> slots;

    public ParkingLot(int totalSlots) {
        this.totalSlots = totalSlots;
        this.slots = new ArrayList<>();
        for (int i = 0; i < totalSlots; i++) {
            slots.add(new ParkingSlot(i + 1));
        }
    }

    private ParkingSlot getNearestAvailableSlot() {
        for (ParkingSlot slot : slots) {
            if (!slot.isOccupied()) {
                return slot;
            }
        }
        return null;
    }

    public int parkCar(String registrationNumber, String color) {
        ParkingSlot slot = getNearestAvailableSlot();
        if (slot != null) {
            Car car = new Car(registrationNumber, color);
            if (slot.parkCar(car)) {
                return slot.getSlotNumber();
            }
        }
        return -1;
    }

    public boolean leaveSlot(int slotNumber) {
        if (slotNumber >= 1 && slotNumber <= totalSlots) {
            return slots.get(slotNumber - 1).removeCar();
        }
        return false;
    }

    public List<ParkingStatus> getStatus() {
        List<ParkingStatus> status = new ArrayList<>();
        for (ParkingSlot slot : slots) {
            if (slot.isOccupied()) {
                Car car = slot.getCar();
                status.add(new ParkingStatus(
                        slot.getSlotNumber(),
                        car.getRegistrationNumber(),
                        car.getColor()
                ));
            }
        }
        return status;
    }

    public List<String> getCarsByColor(String color) {
        List<String> registrationNumbers = new ArrayList<>();
        for (ParkingSlot slot : slots) {
            if (slot.isOccupied() &&
                    slot.getCar().getColor().equalsIgnoreCase(color)) {
                registrationNumbers.add(slot.getCar().getRegistrationNumber());
            }
        }
        return registrationNumbers;
    }

    public int getSlotByRegistration(String registrationNumber) {
        for (ParkingSlot slot : slots) {
            if (slot.isOccupied() &&
                    slot.getCar().getRegistrationNumber().equalsIgnoreCase(registrationNumber)) {
                return slot.getSlotNumber();
            }
        }
        return -1;
    }

    public List<Integer> getSlotsByColor(String color) {
        List<Integer> slotNumbers = new ArrayList<>();
        for (ParkingSlot slot : slots) {
            if (slot.isOccupied() &&
                    slot.getCar().getColor().equalsIgnoreCase(color)) {
                slotNumbers.add(slot.getSlotNumber());
            }
        }
        return slotNumbers;
    }

    public static class ParkingStatus {
        private final int slotNumber;
        private final String registrationNumber;
        private final String color;

        public ParkingStatus(int slotNumber, String registrationNumber, String color) {
            this.slotNumber = slotNumber;
            this.registrationNumber = registrationNumber;
            this.color = color;
        }

        @Override
        public String toString() {
            return slotNumber + "\t" + registrationNumber + "\t" + color;
        }
    }
}