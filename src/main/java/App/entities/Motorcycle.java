package App.entities;

public class Motorcycle extends Vehicle{

    private boolean hasSidecar;

    public Motorcycle(String registrationNumber, String brand, String model, int mileage, boolean hasSidecar) {
        super(registrationNumber, brand, model, mileage);
        this.hasSidecar = hasSidecar;
    }

}
