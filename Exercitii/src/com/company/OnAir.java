package com.company;

public class OnAir extends Vehicle{

    private int noTurbines = 2;
    private boolean hasFirstClass;

    public OnAir(String serialNumber, int noPersons) {
        super(serialNumber, noPersons);
    }

    public OnAir(String serialNumber, int noPersons, String name) {
        super(serialNumber, noPersons, name);
    }

    public OnAir(String serialNumber, int noPersons, String name, int noTurbines) {
        super(serialNumber, noPersons, name);
        this.noTurbines = noTurbines;
    }

    public OnAir(String serialNumber, int noPersons, String name, int noTurbines, boolean hasFirstClass) {
        this(serialNumber, noPersons, name, noTurbines);
        this.hasFirstClass = hasFirstClass;
    }

    @Override
    public boolean goTo(double positionX, double positionY) {
        System.out.println("Flying the airplane to coordinates:" + "[" + positionX + ", " + positionY + "]");
        return true;
    }

    @Override
    public boolean addFuel(double amount) {
        System.out.println("Adding " + amount + " l of fuel to the airplane");
        return true;
    }

    public void printInfo() {
        super.printInfo();
        System.out.println("Vessel properties:");
        System.out.println("       - number of turbines: " + this.noTurbines);
        System.out.println(hasFirstClass ? "       - has first class" : "       - does not have first class");
    }

}
