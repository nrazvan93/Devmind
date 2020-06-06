package com.company;

import java.util.Scanner;

public class Recapitulare1 {

    Scanner sc = new Scanner(System.in);


    public void complementaryNumber() {
        int n;
        int temp = 1;
        System.out.println("Write down your number: ");
        n = sc.nextInt();

        while(temp < n) {
            temp *= 10;
        }

        System.out.println("The complementary number for " + n + " is: \n" + (temp - n));
    }


    public void powerOfBase() {

        int b,e;
        int current = 1;

        System.out.println("Write down your base: ");
        b = sc.nextInt();
        System.out.println("Write down your exponent: ");
        e = sc.nextInt();

        for (int i = 0; i <= e; i++) {
            System.out.println(current + " ");
            current *= b;
        }
    }

    public int highestMultipleOfFiveSmaller(int n) {

        return n - n % 5;

    }

    public int highestMultipleOfFiveBigger(int n) {

        return n - n % 5 + 5;

    }

    public void friendsPair() {

        int lowerLimit;
        int upperLimit;

        System.out.println("Lowerlimit: ");
        lowerLimit = sc.nextInt();
        System.out.println("Upperlimit: ");
        upperLimit = sc.nextInt();

        for (int i = lowerLimit; i <= upperLimit; i++) {
            int result = checkForAmical(i);
            if (i < result) {
                System.out.println(i + " " + result);
            }
        }

    }

    public int possibleFriend(int n) {

        int sum = 0;

        for (int i = 1; i <= n/2; i++) {
            if (n % i == 0) {
                sum += i;
            }
        }

        return sum;
    }

    public int checkForAmical(int n) {

        int possibleFriend = possibleFriend(n);
        int possibleFriendOfPossibleFriend = possibleFriend(possibleFriend);

        if (possibleFriendOfPossibleFriend == n) {
            return possibleFriend;
        }

        return n;
    }



}
