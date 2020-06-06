package com.company;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;

public class Recapitulare3 {


    public HashMap stringToDict(String s) {

        s = s.toLowerCase();
        s = s.replaceAll("[^a-z]", "");

        HashMap<Character, Integer> characterCount = new HashMap<>();

        for (int i = 0; i < s.length(); i++) {
            if (characterCount.containsKey(s.charAt(i))) {
                characterCount.put(s.charAt(i), characterCount.get(s.charAt(i)) + 1);
            } else {
                characterCount.put(s.charAt(i), 1);
            }
        }

        return characterCount;
    }

    public void numberOfCharacter(String sentence) {

        HashMap<Character, Integer> characterCount = stringToDict(sentence);

//        int maxValue = Collections.max(characterCount.values());
//        int minValue = Collections.min(characterCount.values());

        for (Character c : characterCount.keySet()) {
//            if (characterCount.get(c) == maxValue && c != ' ') {
            System.out.println("Character " + c.toString() + " appears " + characterCount.get(c) + " times");
//            }
        }
    }

    public boolean anagramSolver(String anag1, String anag2) {

        HashMap<Character, Integer> countString1 = stringToDict(anag1);
        HashMap<Character, Integer> countString2 = stringToDict(anag2);

        return compareHash(countString1, countString2) && compareHash(countString2, countString1);

    }

    public boolean compareHash(HashMap<Character,Integer> dict1, HashMap<Character, Integer> dict2) {

        for (Character c : dict1.keySet()) {
            if (dict1.get(c).equals(dict2.get(c))) {
                return false;
            }
        }
        return true;
    }


    public static int convertStringToNumber(String numberStr) {

        char[] digits = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9'};
        int numValue = 0;

        for (int i = 0; i < numberStr.length(); i++) {
            for (int j = 0; j < digits.length; j++) {
                if (numberStr.charAt(i) == digits[j]) {
                    numValue = numValue * 10 + j;
                }
            }
        }

        return numValue;
    }


    public void filterArray(String [] array, String key, int matchKey) {


        ArrayList<String> result = new ArrayList<>();
//        String [] result = new String[array.length];

        for (int i = 0; i< array.length; i ++) {
            if (compareStrings(array[i], key) >= matchKey) {
                result.add(array[i]);
            }
        }

        for (String s : result) {
            System.out.println(s);
        }
    }

    public int compareStrings(String a, String b) {

        a = a.toLowerCase();
        b = b.toLowerCase();

        int result = 0;
        int minimumSize = Math.min(a.length(), b.length());

        for (int i = 0; i < minimumSize; i++) {
            if (a.charAt(i) == b.charAt(i)) {
                result += 1;
            }
        }

        return result;
    }


}
