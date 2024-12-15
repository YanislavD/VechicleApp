package App.service;

import App.entities.Car;
import App.entities.Vehicle;

import java.util.*;

import static App.exceptions.ExceptionMessages.*;

public class FleetManagerImpl implements FleetManager {

    private Map<String, Vehicle> fleet;

    public FleetManagerImpl() {
        this.fleet = new HashMap<>();
    }



    @Override
    public void addVehicle(Vehicle vehicle) {
        if (vehicle == null) {
            throw new NullPointerException(VEHICLE_NULL);
        }
        if (fleet.containsKey(vehicle.getRegistrationNumber())) {
            throw new IllegalArgumentException(EXISTING_REGISTRATION_NUMBER);
        }
        fleet.put(vehicle.getRegistrationNumber(), vehicle);
    }

    @Override
    public void removeVehicle(String registrationNumber) {
        if (!fleet.containsKey(registrationNumber)){
            throw new NoSuchElementException(NO_SUCH_THE_REGISTRATION_NUMBER);
        }
        fleet.remove(registrationNumber);
    }

    @Override
    public Vehicle getVehicle(String registrationNumber) {
        if (!fleet.containsKey(registrationNumber)) {
            throw new NoSuchElementException(NO_SUCH_THE_REGISTRATION_NUMBER);
        }
        return fleet.get(registrationNumber);
    }

    @Override
    public long countElectricCars() {
        return fleet.values().stream()
                .filter(vehicle -> vehicle instanceof Car && ((Car) vehicle).isElectric())
                .count();
    }

    @Override
    public List<Vehicle> getAllVehicles() {
        return new ArrayList<>(fleet.values());
    }
}
