import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ParkingLotManager manager = new ParkingLotManager();
        Map<String, Command> commands = new HashMap<>();
        commands.put("create_parking_lot", new CreateParkingLotCommand(manager));
        commands.put("park", new ParkCarCommand(manager));
        commands.put("leave", new LeaveSlotCommand(manager));
        commands.put("status", new StatusCommand(manager));
        commands.put("registration_numbers_for_cars_with_colour", new RegistrationNumbersByColorCommand(manager));
        commands.put("slot_number_for_registration_number", new SlotNumberByRegistrationCommand(manager));
        commands.put("slot_numbers_for_cars_with_colour", new SlotNumbersByColorCommand(manager));

        while (true) {
            System.out.print("Enter command: ");
            String commandLine = scanner.nextLine().trim();
            String[] parts = commandLine.split(" ");
            String commandName = parts[0];

            if (commandName.equals("exit")) {
                break;
            }

            Command command = commands.get(commandName);
            if (command != null) {
                command.execute(parts);
            } else {
                System.out.println("Invalid command");
            }
        }
        scanner.close();
    }
}