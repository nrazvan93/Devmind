package com.company;

import java.util.ArrayList;
import java.util.Scanner;

public class GuestList {

    private int availableSeats;
    private ArrayList<Guest> guestList = new ArrayList<>();
    private ArrayList<Guest> waitingList = new ArrayList<>();

    public int getAvailableSeats() {
        return this.availableSeats;
    }

    public void setAvailableSeats(int availableSeats) {
        this.availableSeats = availableSeats;
    }

    public void getParticipants() {
        if (this.guestList.isEmpty()) {
            System.out.println("Nu exista participanti");
        } else {
            for (Guest g : guestList) {
                g.info();
            }
        }
    }
    public void getWaiting() {
        if (this.waitingList.isEmpty()) {
            System.out.println("Lista de asteptare este goala");
        } else {
            for (Guest g : waitingList) {
                g.info();
            }
        }
    }

    public ArrayList<Guest> getGuestList() {
        return this.guestList;
    }

    public ArrayList<Guest> getWaitingList() {
        return this.waitingList;
    }


    public int add(String firstName, String lastName, String email, String phoneNumber) {
        if (searchByName(lastName, firstName) != null && searchByEmail(email) != null && searchByPhoneNumber(phoneNumber) != null) {
            System.out.println("Persoana este deja inscrisa la eveniment!");
            return -1;
        } else {
            Guest g = new Guest(firstName, lastName, email, phoneNumber);
            if (this.guestList.size() < this.availableSeats) {
                this.guestList.add(g);
                System.out.println("Felicitari! Locul tau la eveniment este confirmat. Te asteptam!.");
                return 0;
            } else {
                this.waitingList.add(g);
                for (int i = 0; i < waitingList.size(); i++) {
                    if (waitingList.get(i) == g) {
                        System.out.println("Te-ai inscris cu succes in lista de asteptare si ai primit numarul de ordine <" + (i + 1) + "> Te vom notifica daca un loc devine disponibil");
                        return i + 1;
                    }
                }
            }
        }
        return -2;
    }

    private Guest searchByName(String lastName, String firstName) {
        for (Guest guest : this.guestList) {
            if (guest.getFirstName().equals(firstName) && guest.getLastName().equals(lastName)) {
                return guest;
            }
        }

        for (Guest guest : this.waitingList) {
            if (guest.getFirstName().equals(firstName) && guest.getLastName().equals(lastName)) {
                return guest;
            }
        }
        return null;
    }

    private Guest searchByEmail(String email) {
        for (Guest guest : this.guestList) {
            if (guest.getEmail().equals(email)) {
                return guest;
            }
        }

        for (Guest guest : this.waitingList) {
            if (guest.getEmail().equals(email)) {
                return guest;
            }
        }
        return null;
    }

    private Guest searchByPhoneNumber(String phoneNumber) {
        for (Guest guest : this.guestList) {
            if (guest.getPhoneNumber().equals(phoneNumber)) {
                return guest;
            }
        }
        for (Guest guest : this.waitingList) {
            if (guest.getPhoneNumber().equals(phoneNumber)) {
                return guest;
            }
        }
        return null;
    }

    public boolean removePerson(Guest g) {

        if (this.guestList.size() == 1 && this.waitingList.size() == 0) {
            this.guestList.remove(0);
            System.out.println("Lista de participanti este goala");
        } else {
            if (this.guestList.contains(g)) {
                this.guestList.remove(g);
                System.out.println("[" + this.waitingList.get(0).getFirstName() + " " + this.waitingList.get(0).getLastName() + " ] " + "Felicitari! Locul tau la eveniment este confirmat. Te asteptam!");
                this.guestList.add(this.waitingList.get(0));
                this.waitingList.remove(0);
                return true;
            } else if (this.waitingList.contains(g)){
                this.waitingList.remove(g);
                return true;
            }
        }

        return false;
    }

    public Guest check() {
        if (this.guestList.size() > 0) {
            System.out.println("Se verifica daca o persoana este inscrisa la eveniment.");
            Scanner keyboard = new Scanner(System.in);
            System.out.println("Verificati dupa: \n" +
                    "1 - nume \n" +
                    "2 - email \n" +
                    "3 - numar de telefon \n");
            String choice = keyboard.next();
            switch (choice) {
                case "1":
                    System.out.println("Introduceti numele: ");
                    String lastName = keyboard.next();
                    System.out.println("Introduceti prenumele: ");
                    String firstName = keyboard.next();
                    if (this.searchByName(lastName, firstName) != null) {
                        return this.searchByName(lastName, firstName);
                    }
                    break;
                case "2":
                    System.out.println("Introduceti email: ");
                    String email = keyboard.next();
                    if (this.searchByEmail(email) != null) {
                        return this.searchByEmail(email);
                    }
                    break;
                case "3":
                    System.out.println("Introduceti numarul de telefon: ");
                    String phoneNumber = keyboard.next();
                    if (this.searchByPhoneNumber(phoneNumber) != null) {
                        return this.searchByPhoneNumber(phoneNumber);
                    }
                    break;
            }
        }
        return null;
    }

    public void updateGuestInfo(Guest g) {
        Scanner keyboard = new Scanner(System.in);
        System.out.println("Alege campul de actualizat: \n" +
                                    "1 - Nume \n" +
                                    "2 - Prenume \n" +
                                    "3 - Email \n" +
                                    "4 - Numar de telefon (format \"+40733386463\")");
        String choice = keyboard.next();
        switch (choice) {
            case "1":
                System.out.println("Introduceti numele de familie: ");
                String lastName = keyboard.next();
                g.setLastName(lastName);
                break;
            case "2":
                System.out.println("Introduceti prenumele: ");
                String firstName = keyboard.next();
                g.setLastName(firstName);
                break;
            case "3":
                System.out.println("Introduceti email: ");
                String email = keyboard.next();
                g.setEmail(email);
            case "4":
                System.out.println("Introduceti numarul de telefon: ");
                String phoneNumber = keyboard.next();
                g.setPhoneNumber(phoneNumber);
                break;
        }
    }

    public void helpCommands() {
        System.out.println("help - Afiseaza aceasta lista de comenzi \n" +
                "add - Adauga o noua persoana (inscriere) \n" +
                "check - Verifica daca o persoana este inscrisa la eveniment \n" +
                "remove - Sterge o persoana existenta din lista \n" +
                "update - Actualizeaza detaliile unei persoane \n" +
                "guests - Lista de persoane care participa la eveniment \n" +
                "waitlist - Persoanele din lista de asteptare \n" +
                "available - Numarul de locuri libere \n" +
                "guests_no - Numarul de persoane care participa la eveniment \n" +
                "waitlist_no - Numarul de persoane din lista de asteptare \n" +
                "subscribe_no - Numarul total de persoane inscrise \n" +
                "search - Cauta toti invitatii conform sirului de caractere introdus \n" +
                "quit - Inchide aplicatia)");
    }

    public ArrayList<String> search() {


        Scanner keyboard = new Scanner(System.in);
        System.out.println("Introduceti sirul de cautat: ");
        String search = keyboard.next();
        search = search.toLowerCase();
        ArrayList<String> results = new ArrayList<>();
        for (Guest g : this.guestList) {
            if (g.getLastName().toLowerCase().contains(search)) {
                results.add("lastName = " + g.getLastName());
            } else if (g.getFirstName().toLowerCase().contains(search)) {
                results.add("firstName = " + g.getFirstName());
            } else if (g.getEmail().toLowerCase().contains(search)) {
                results.add("email = " + g.getEmail());
            }
        }

        for (Guest g : this.waitingList) {
            if (g.getLastName().toLowerCase().contains(search)) {
                results.add("lastName = " + g.getLastName());
            } else if (g.getFirstName().toLowerCase().contains(search)) {
                results.add("firtName = " + g.getFirstName());
            } else if (g.getEmail().toLowerCase().contains(search)) {
                results.add("email = " + g.getEmail());
            }
        }

        return results;
    }



}
