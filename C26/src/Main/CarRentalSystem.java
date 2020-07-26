package Main;

import java.util.HashMap;
import java.util.Scanner;

public class CarRentalSystem {

    private static Scanner sc = new Scanner(System.in);
    private static HashMap<String, RentedCars> ownerDetails = new HashMap<String, RentedCars>();
    private HashMap<String, String> rentedCars = new HashMap<String, String>(100, 0.5f);

    private static void getCarsNo() {
        String owner = getOwnerName();
        if (ownerDetails.get(owner) == null) {
            System.out.println("Proprietarul nu exista");
        } else {
            System.out.println("Numarul de masini: " + ownerDetails.get(owner).getNoOfCars());
        }
    }

    private static void getCarsList() {
        String owner = getOwnerName();
        if (ownerDetails.get(owner) == null) {
            System.out.println("Proprietarul nu exista");
        } else {
            System.out.print("Lista de masini: ");
            for (String s : ownerDetails.get(owner).getListOfCars()) {
                System.out.print(s + " ");
            }
            System.out.println();
        }
    }

    private static String getPlateNo() {
        System.out.println("Introduceti numarul de inmatriculare:");
        return sc.nextLine();
    }

    private static String getOwnerName() {
        System.out.println("Introduceti numele proprietarului:");
        return sc.nextLine();
    }

    private static void printCommandsList() {
        System.out.println("help         - Afiseaza aceasta lista de comenzi");
        System.out.println("add          - Adauga o noua pereche (masina, sofer)");
        System.out.println("check        - Verifica daca o masina este deja luata");
        System.out.println("remove       - Sterge o masina existenta din hashtable");
        System.out.println("getOwner     - Afiseaza proprietarul curent al masinii");
        System.out.println("totalRented  - Afiseaza numarul de masini inchiriate");
        System.out.println("getCarsNo    - Afiseaza numarul de masini inchiriate de proprietarul temporar");
        System.out.println("getCarsList  - Afiseaza lista de masini inchiriate de proprietarul temporar");
        System.out.println("quit         - Inchide aplicatia");
    }

    private boolean isCarRent(String plateNo) {
        return rentedCars.containsKey(plateNo);
    }

    private String getCarRent(String plateNo) {
        if (rentedCars.get(plateNo) == null) {
            System.out.println("Masina nu exista!");
        } else {
            return rentedCars.get(plateNo);
        }
        return "";
    }

    private void rentCar(String plateNo, String ownerName) {
        if (rentedCars.containsKey(plateNo)) {
            System.out.println("Masina exista deja!");
        } else {
            rentedCars.put(plateNo, ownerName);
            if (ownerDetails.containsKey(ownerName)) {
                ownerDetails.get(ownerName).addCarToOwner(plateNo);
                ownerDetails.get(ownerName).updateNoOfCars();
            } else {
                ownerDetails.put(ownerName, new RentedCars());
                ownerDetails.get(ownerName).addCarToOwner(plateNo);
                ownerDetails.get(ownerName).updateNoOfCars();
            }
            System.out.println("Masina a fost adaugata cu succes!");
        }
    }

    private void returnCar(String plateNo) {
        if (rentedCars.remove(plateNo) == null) {
            System.out.println("Masina nu exista!");
        } else {
            rentedCars.remove(plateNo);
            System.out.println("Masina a fost stearsa cu succes!");
        }
    }

    private int totalRented() {
        return rentedCars.size();
    }

    public void run() {
        boolean quit = false;
        while (!quit) {
            System.out.println("Asteapta comanda: (help - Afiseaza lista de comnezi)");
            String command = sc.nextLine();
            switch (command) {
                case "help":
                    printCommandsList();
                    break;
                case "add":
                    rentCar(getPlateNo(), getOwnerName());
                    break;
                case "check":
                    System.out.println(isCarRent(getPlateNo()));
                    break;
                case "remove":
                    returnCar(getPlateNo());
                    break;
                case "getOwner":
                    System.out.println(getCarRent(getPlateNo()));
                    break;
                case "totalRented":
                    System.out.println("Numarul de masini inchiriate: " + totalRented());
                    break;
                case "quit":
                    System.out.println("Aplicatia se inchide...");
                    quit = true;
                    break;
                case "getCarsNo":
                    getCarsNo();
                    break;
                case "getCarsList":
                    getCarsList();
                    break;
                default:
                    System.out.println("Unknown command. Choose from:");
                    printCommandsList();
            }
        }
    }
}