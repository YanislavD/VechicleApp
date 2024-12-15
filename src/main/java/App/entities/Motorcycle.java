package App.entities;

public class Motorcycle extends Vehicle{

    private String hasSidecar;

    public Motorcycle(String registrationNumber, String brand, String model, int mileage, String hasSidecar) {
        super(registrationNumber, brand, model, mileage);
        this.hasSidecar = hasSidecar;
    }

}
