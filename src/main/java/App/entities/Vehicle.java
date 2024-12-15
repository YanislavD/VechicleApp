package App.entities;

import static App.exceptions.ExceptionMessages.*;

public abstract class Vehicle {

    private String registrationNumber;
    private String brand;
    private String model;
    private int mileage;

    public Vehicle(String registrationNumber, String brand, String model, int mileage) {
        this.registrationNumber = registrationNumber;
        setBrand(brand);
        setModel(model);
        setMileage(mileage);
    }



    public String getRegistrationNumber() {
        return registrationNumber;
    }

    public void setRegistrationNumber(String registrationNumber) {
        this.registrationNumber = registrationNumber;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        if (brand == null || brand.isBlank()){
            throw new NullPointerException(BRAND_NAME_NULL_OR_EMPTY);
        }
        this.brand = brand;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        if (model == null || model.isBlank()){
            throw new NullPointerException(MODEL_NAME_NULL_OR_EMPTY);
        }
        this.model = model;
    }

    public int getMileage() {
        return mileage;
    }

    public void setMileage(int mileage) {
        if (mileage < 0 ) {
            throw new IllegalArgumentException(NEGATIVE_MILEAGE_VALUE);
        }
        this.mileage = mileage;
    }

    @Override
    public String toString() {
        return "Type: " + getBrand() + System.lineSeparator() +
                "Registration Number: " + getRegistrationNumber() + System.lineSeparator() +
                "Brand: " + getBrand() + System.lineSeparator() +
                "Mileage: " + getMileage() + System.lineSeparator();
    }
}
