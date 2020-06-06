package com.company;

import java.io.File;
import java.io.FileNotFoundException;
import java.sql.SQLOutput;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) throws Exception {

            GuestList lista = new GuestList();
//            File test = new File("in.txt");
            Scanner keyboard = new Scanner(System.in);
            System.out.println("Bun venit! Introduceti numarul de locuri disponibile:");
            lista.setAvailableSeats(keyboard.nextInt());
            while (true) {
                System.out.println("Asteapta comanda: (help - Afiseaza lista de comenzi)");
                String command = keyboard.next();
                if (command.equals("help")) {
                    lista.helpCommands();
                } else if (command.equals("check")) {
                    Guest g = lista.check();
                    if (g == null) {
                        System.out.println("Eroare: Persoana nu este inscrisa la eveniment.");
                    } else {
                        if (lista.getGuestList().contains(g)) {
                            System.out.println("Persoana " + g.getFirstName() + " " + g.getLastName() + " este inscrisa la eveniment pe lista de participare");
                        } else if (lista.getWaitingList().contains(g)) {
                            System.out.println("Persoana " + g.getFirstName() + " " + g.getLastName() + " este inscrisa la eveniment pe lista de asteptare, locul + "  + lista.getWaitingList().indexOf(g));
                        }
                    }
                } else if (command.equals("update")) {
                    System.out.println("Se actualizeaza detaliile unei persoane…");
                    Guest g = lista.check();
                    if (g != null) {
                        lista.updateGuestInfo(g);
                    } else {
                        System.out.println("Eroare: Persoana nu este inscrisa la eveniment.");
                    }
                } else if (command.equals("add")) {
                    System.out.println("Se adauga o noua persoana... \n" +
                            "Introduceti numele de familie: ");
                    String lastName = keyboard.next();
                    System.out.println("Introduceti prenumele: ");
                    String firstName = keyboard.next();
                    System.out.println("Introduceti email: ");
                    String email = keyboard.next();
                    System.out.println("Introduceti numar de telefon (format \"+40733386463\")");
                    String phoneNumber = keyboard.next();
                    lista.add(firstName, lastName, email, phoneNumber);
                } else if (command.equals("remove")) {
                    System.out.println("Se sterge o persoana existenta din lista...");
                    Guest g = lista.check();
                    if (g != null) {
                        lista.removePerson(g);
                        System.out.println("Persoana a fost stearsa cu succes.");
                    } else {
                        System.out.println("Eroare: Persoana nu este inscrisa la eveniment.");
                    }
                } else if (command.equals("guests")) {
                    lista.getParticipants();
                } else if (command.equals("waitlist")) {
                    lista.getWaiting();
                } else if (command.equals("available")) {
                    System.out.println("Numarul de locuri ramase: " + (lista.getAvailableSeats() - lista.getGuestList().size()));
                } else if (command.equals("guest_no")) {
                    System.out.println("Numarul de participanti: " + lista.getGuestList().size());
                } else if (command.equals("waitlist_no")) {
                    System.out.println("Numarul de persoane din lista de asteptare: " + lista.getWaitingList().size());
                } else if (command.equals("subscribe_no")) {
                    System.out.println("Numarul total de persoane inscrise: " + lista.getWaitingList().size() + lista.getGuestList().size());
                } else if (command.equals("search")) {
                    for (String s : lista.search()) {
                        System.out.println(s);
                    }
                } else if (command.equals("quit")) {
                    break;
                } else {
                    System.out.println("Eroare. Comanda gresita");
                }
            }
            keyboard.close();

    }
}
