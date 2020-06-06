package com.company;

public class OnWater extends Vehicle {

    private int noEngines = 2;
    private double cargoCapacity;

    public OnWater(String serialNUmber, int noPersons) {
        super(serialNUmber, noPersons);
    }

    public OnWater(String serialNumber, int noPersons, String name) {
        super(serialNumber, noPersons, name);
    }

    public OnWater(String serialNumber, int noPersons, String name, int noEngines, double cargoCapacity) {
        super(serialNumber, noPersons, name);
        this.noEngines = noEngines;
        this.cargoCapacity = cargoCapacity;
    }

    @Override
    public boolean goTo(double positionX, double positionY) {
        System.out.println("Sailing the vessel to coordinates:" + "[" + positionX + ", " + positionY + "]");
        return true;
    }

    @Override
    public boolean addFuel(double amount) {
        System.out.println("Adding " + amount + " l of fuel to the vessel");
        return true;
    }

    @Override
    public void printInfo() {
        super.printInfo();
        System.out.println("Vessel properties:");
        System.out.println("       - number of engines: " + this.noEngines);
        System.out.println("       - cargo capacity : " + this.cargoCapacity);

    }
}
