package App.core;

import App.entities.Car;
import App.entities.Truck;
import App.entities.Vehicle;
import App.service.FleetManager;
import App.service.FleetManagerImpl;

public class ControllerImpl implements Controller {
    private FleetManager fleetManager;

    public ControllerImpl(FleetManager fleetManager) {
        this.fleetManager = fleetManager;
    }

    @Override
    public void addCar(String regNumber, String brand, String model, int mileage, int doors, boolean isElectric) {
        Vehicle car = new Car(regNumber, brand, model, mileage, doors, isElectric);
        fleetManager.addVehicle(car);
    }

    @Override
    public void addTruck(String regNumber, String brand, String model, int mileage, int capacity) {
        Vehicle truck = new Truck(regNumber, brand, model, mileage, capacity);
        fleetManager.addVehicle(truck);
    }

    @Override
    public String getVehicleDetails(String regNumber) {
        Vehicle vehicle = fleetManager.getVehicle(regNumber);
        return vehicle.toString();
    }

    @Override
    public void removeVehicle(String regNumber) {
        fleetManager.removeVehicle(regNumber);
    }

    @Override
    public String getFleetStatistics() {
        StringBuilder stats = new StringBuilder();
        stats.append("Total vehicles: ").append(fleetManager.getAllVehicles().size()).append(System.lineSeparator());
        stats.append("Electric cars: ").append(fleetManager.countElectricCars()).append(System.lineSeparator());
        return stats.toString();
    }
}
