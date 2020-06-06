package com.company;

import java.util.Arrays;

public class Main {

    public static void main(String[] args) {
        // write your code here

        Recapitulare1 ex1 = new Recapitulare1();
        Recapitulare2 ex2 = new Recapitulare2();
        Recapitulare3 ex3 = new Recapitulare3();

//        ex1.complementaryNumber();
//        ex1.powerOfBase();
//        System.out.println(ex1.highestMultipleOfFiveSmaller(11));
//        System.out.println(ex1.highestMultipleOfFiveBigger(19));
//        ex1.friendsPair();

//        System.out.println(ex2.reverseNumberRecursive(35));
//        System.out.println(ex2.countDigits(23));
//        System.out.println(ex2.reverseNumberIterative(35));
//        System.out.println(ex2.myMathPowRecursive(2,3));
//        System.out.println(ex2.myMathPowIterative(2,3));
//        double [] a = {1,3,0,4,30,0,4,3,4};

//        ex2.orderZeros(a);
//        ex2.bubbleSort(a);
//        ex3.numberOfCharacter("parliament");
//        System.out.println();
//        ex3.numberOfCharacter("partial menffewe");

//        System.out.println(ex3.anagramSolver("parliament","partial men"));

//        System.out.println(ex3.convertStringToNumber("123"));
//        System.out.println(ex3.compareStrings("abcd","abcdeeedaw"));
//        String [] b = {"clothes", "ant", "drop", "Fly", "racoon", "class", "Plane"};
//
//        ex3.filterArray(b, "plot", 1);


        ////// MyIntArrayList

        MyIntArrayList arrayList = new MyIntArrayList(0);
        MyIntArrayList arrayList2 = new MyIntArrayList(0);
        arrayList.add(2);
        arrayList.add(2);
        arrayList.add(2);
        arrayList.add(2);
        arrayList.add(2);
        arrayList2.add(1);
        arrayList2.add(1);
        arrayList2.add(1);


        arrayList.add(3,44);
        arrayList.add(6,44);


//        System.out.println(Arrays.toString(arrayList.toArray()));
//        System.out.println(arrayList.get(1));
//        System.out.println(arrayList.lastIndexOf(2));
//
//        System.out.println(arrayList.indexOf(2));
//
//        arrayList.remove(2);
//        System.out.println(Arrays.toString(arrayList.toArray()));
//        arrayList.removeElementAtIndex(2);
//        System.out.println(Arrays.toString(arrayList.toArray()));
//        System.out.println();
//
////        arrayList.clear();
////        arrayList.get(3);
//        System.out.println(Arrays.toString(arrayList.toArray()));
//        System.out.println(Arrays.toString(arrayList2.toArray()));
//        arrayList.addAll(arrayList2);
//        System.out.println(Arrays.toString(arrayList.toArray()));
        Vehicle test = new Vehicle("wadawdwad", 4, "Moby");
        test.printInfo();

        OnRoad test2 = new OnRoad("blabla", 4,"test");
        test2.printInfo();

        test2.goTo(3,4);

        OnAir test3 = new OnAir("cdcdcd", 5,"avion",5,true);
        test3.printInfo();



    }
}
