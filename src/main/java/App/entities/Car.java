package App.entities;

import static App.common.ExceptionMessages.NEGATIVE_DOORS_VALUE;

public class Car extends Vehicle{


    private int doors;
    private boolean isElectric;




    public Car(String registrationNumber, String brand, String model, int mileage, int doors, boolean isElectric) {
        super(registrationNumber, brand, model, mileage);
        setDoors(doors);
        this.isElectric = isElectric;
    }

    public void setDoors(int doors) {
        if (doors < 0) {
            throw new IllegalArgumentException(NEGATIVE_DOORS_VALUE);
        }
        this.doors = doors;
    }

    public void setElectric(boolean electric) {
        isElectric = electric;
    }

    public boolean isElectric() {
        return isElectric;
    }
}
