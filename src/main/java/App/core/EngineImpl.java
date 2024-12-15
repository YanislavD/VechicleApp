package App.core;

import java.util.Scanner;

import static App.common.ExceptionMessages.INVALID_TYPE;
import static App.common.ExceptionMessages.SCANNER_NULL_OR_EMPTY;

public class EngineImpl implements Engine{
    private final ControllerImpl controller;

    public EngineImpl(ControllerImpl controller) {
        this.controller = controller;
    }


    public void run() {
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("Enter command (ADD, VIEW, REMOVE, ALL, STATS, EXIT):");
            String command = scanner.nextLine().trim().toUpperCase();

            try {
                switch (command) {
                    case "ADD":
                        handleAdd(scanner);
                        break;
                    case "VIEW":
                        handleView(scanner);
                        break;
                    case "REMOVE":
                        handleRemove(scanner);
                        break;
                    case "STATS":
                        handleStats();
                        break;
                    case "ALL":
                        handleAllVehicle();
                        break;
                    case "EXIT":
                        System.out.println("Exiting program...");
                        return;
                    default:
                        System.out.println("Invalid command!");
                }
            } catch (Exception e) {
                System.out.println("Error: " + e.getMessage());
            }
        }
    }

    private void handleAllVehicle() {
        String allVehicle = controller.getAllVehicles();
        System.out.println(allVehicle);
    }

    private void handleAdd(Scanner scanner) {

        System.out.println("Enter vehicle type (Car/Truck/Motorcycle):");
        String type = scanner.nextLine().trim();
        checkScanner(type);
        checkType(type);

        System.out.println("Enter registration number:");
        String regNumber = scanner.nextLine().trim();
        checkScanner(regNumber);

        System.out.println("Enter brand:");
        String brand = scanner.nextLine().trim();
        checkScanner(brand);


        System.out.println("Enter model:");
        String model = scanner.nextLine().trim();
        checkScanner(model);

        System.out.println("Enter mileage:");
        int mileage = Integer.parseInt(scanner.nextLine().trim());

        if (type.equalsIgnoreCase("Car")) {
            System.out.println("Enter number of doors:");
            int doors = Integer.parseInt(scanner.nextLine().trim());

            System.out.println("Is it electric? (true/false):");
            boolean isElectric = Boolean.parseBoolean(scanner.nextLine().trim());

            controller.addCar(regNumber, brand, model, mileage, doors, isElectric);
        } else if (type.equalsIgnoreCase("Truck")) {
            System.out.println("Enter cargo capacity (tons):");
            int capacity = Integer.parseInt(scanner.nextLine().trim());

            controller.addTruck(regNumber, brand, model, mileage, capacity);
        } else if (type.equalsIgnoreCase("Motorcycle")) {
            System.out.println("Has the Motorcycle a hasSidecar? true/false");
            String hasSidecar = scanner.nextLine();
            controller.addMotorcycle(regNumber,brand, model,mileage,hasSidecar);
        } else {
            System.out.println("Invalid vehicle type!");
        }
    }

    private void checkType(String input) {
        if(!input.equalsIgnoreCase("CAR") && !input.equalsIgnoreCase("TRUCK") && !input.equalsIgnoreCase("MOTORCYCLE")) {
            throw new IllegalArgumentException(INVALID_TYPE);
        }
    }

    private void checkScanner(String type) {
        if (type == null || type.isBlank()) {
            throw new NullPointerException(SCANNER_NULL_OR_EMPTY);
        }
    }

    private void handleView(Scanner scanner) {
        System.out.println("Enter registration number to view details:");
        String regNumber = scanner.nextLine().trim();
       // checkScanner(regNumber);
        System.out.println(controller.getVehicleDetails(regNumber));
    }

    private void handleRemove(Scanner scanner) {
        System.out.println("Enter registration number to remove:");
        String regNumber = scanner.nextLine().trim();
        controller.removeVehicle(regNumber);
        System.out.println("Vehicle removed.");
    }

    private void handleStats() {
        System.out.println(controller.getFleetStatistics());
    }
}
