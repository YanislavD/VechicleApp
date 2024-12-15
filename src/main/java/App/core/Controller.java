package App.core;

public interface Controller {

    void addCar(String regNumber, String brand, String model, int mileage, int doors, boolean isElectric);

    void addTruck(String regNumber, String brand, String model, int mileage, int capacity);

    void addMotorcycle(String registrationNumber, String brand, String model, int mileage, String hasSidecar);

    String getVehicleDetails(String regNumber);

    void removeVehicle(String regNumber);

    String getFleetStatistics();

    String getAllVehicles();
}
