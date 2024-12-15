package App.service;

import App.entities.Vehicle;

import java.util.List;

public interface FleetManager {

    void addVehicle (Vehicle vehicle);

    void removeVehicle (String registrationNumber);
    Vehicle getVehicle(String registrationNumber);

    long countElectricCars();

    List<Vehicle> getAllVehicles();


}
