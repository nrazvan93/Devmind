package Main;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class RadixSort {

    public static ArrayList sorted(int[] numbers) {
        ArrayList<Integer> all = new ArrayList<>(numbers.length);
        for (Integer nr : numbers) {
            all.add(nr);
        }

        int maxDigitCount = 0;
        for (Integer x : numbers) {
            maxDigitCount = Math.max(maxDigitCount, digitCount(x));
        }

        Queue[] queues = new LinkedList[10];
        for (int i = 0; i < 10; i++) {
            queues[i] = new LinkedList<Integer>();
        }

        for (int step = 0; step < maxDigitCount; step++) {
            for (int i = 0; i < all.size(); i++) {
                System.out.println(digit(all.get(i), step));
                queues[digit(all.get(i), step)].add(all.get(i));
            }
            all.clear();
            for (int i = 0; i < 10; i++) {
                while(queues[i].size() > 0) {
                    all.add((Integer) queues[i].poll());
                }
            }
        }
        return all;
    }

    private static int digit(int nr, int pos) {
        for (int i = 0; i < pos; i++) {
            nr /= 10;
        }
        return nr % 10;
    }

    private static int digitCount(Integer number) {
        return number.toString().length();
    }
}
