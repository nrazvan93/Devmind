package com.company;

public class Recapitulare2 {


    public int reverseNumberRecursive(int number) {

        if (number < 10) {
            return number;
        }

        return (int) (Math.pow(10, countDigits(number) - 1) * (number % 10) + reverseNumberRecursive(number / 10));
    }

    public int countDigits(int number) {
        int digits = 0;
        while (number > 0) {
            digits++;
            number /= 10;
        }
        return digits;
    }

    public int reverseNumberIterative(int number) {

        int reverse = 0;

        while (number > 0) {
            reverse = reverse * 10 + number % 10;
            number /= 10;
        }

        return reverse;
    }

    public int myMathPowRecursive(int x, int y) {

        if (y == 0) {
            return 1;
        }

        if (y == 1) {
            return x;
        }

        return x * myMathPowRecursive(x, y - 1);
    }

    public int myMathPowIterative(int x, int y) {

        int result = 1;

        while (y >= 1) {
            result *= x;
            y -= 1;
        }

        return result;
    }

    public void orderZeros(int [] array) {

        int zeroIndex = array.length - 1;
        int numberIndex = array.length - 1;
        int numberOfZeroes = 0;

        for (Integer i : array) {
            if (i == 0) {
                numberOfZeroes++;
            }
        }

        while (zeroIndex >= numberOfZeroes) {
            if (array[zeroIndex] != 0) {
                zeroIndex--;
            } else {
                numberIndex = zeroIndex;
                while (array[numberIndex] == 0) {
                    numberIndex--;
                }
                array[zeroIndex] = array[numberIndex];
                array[numberIndex] = 0;
            }
        }

        for (Integer i : array) {
            System.out.print(i + " ");
        }
    }

    public void bubbleSort(double[] values) {
        int n = values.length;

        while (n > 0) {
            for (int i = 0; i < n - 1; i++) {
                if (values[i] < values[i+1]) {
                    double temp = values[i+1];
                    values[i+1] = values[i];
                    values[i] = temp;
                }
            }
            n -= 1;
        }

        for (double x : values) {
            System.out.print(x + " ");
        }
    }


}
