package Main;

import java.util.ArrayList;

public class RentedCars extends CarRentalSystem {

    private int noOfCars;
    private  ArrayList<String> listOfCars = new ArrayList<>();

    public RentedCars() {}

    protected void updateNoOfCars() {
        this.noOfCars++;
    }

    protected void addCarToOwner(String car) {
        this.listOfCars.add(car);
    }

    protected int getNoOfCars() {
        return noOfCars;
    }

    protected ArrayList<String> getListOfCars() {
        return listOfCars;
    }


}
