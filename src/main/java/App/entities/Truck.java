package App.entities;

import static App.exceptions.ExceptionMessages.NEGATIVE_CAPACITY_VALUE;

public class Truck extends Vehicle{


    private int capacity;

    public Truck(String registrationNumber, String brand, String model, int mileage, int capacity) {
        super(registrationNumber, brand, model, mileage);
        setCapacity(capacity);
    }


    public void setCapacity(int capacity) {
        if (capacity < 0) {
            throw new IllegalArgumentException(NEGATIVE_CAPACITY_VALUE);
        }
        this.capacity = capacity;
    }
}

