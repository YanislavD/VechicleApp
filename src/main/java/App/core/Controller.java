package App.core;

public interface Controller {

    void addCar(String regNumber, String brand, String model, int mileage, int doors, boolean isElectric);

    void addTruck(String regNumber, String brand, String model, int mileage, int capacity);

    String getVehicleDetails(String regNumber);

    void removeVehicle(String regNumber);

    String getFleetStatistics();
}
