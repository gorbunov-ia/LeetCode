package ru.gorbunov.tasks._0528randompickwithweight;

import java.util.TreeSet;
import java.util.concurrent.ThreadLocalRandom;

public class TreeSolution implements Solution {

    private final ThreadLocalRandom random = ThreadLocalRandom.current();
    private final TreeSet<Key> indexes = new TreeSet<>();
    private final int sum;

    //[1,3]

    /**
     * Runtime complexity O(N)
     * Space complexity O(N)
     */
    public TreeSolution(int[] w) {
        int sum = 0;
        for (int weight : w) {
            sum += weight;
        }
        this.sum = sum;

        int current = 0;
        indexes.add(new Key(current, 0));
        for (int i = 0; i < w.length - 1; i++) {
            current += w[i];
            indexes.add(new Key(current, i + 1));
        }
    }
    //1,3,1
    //s = 5
    //[0,1)
    //[1,4)
    //[4,5)

    //[0.00;1.00)
    //[1.00;4.00)
    /**
     * Runtime complexity O(LogN)
     * Space complexity O(1)
     */
    @Override
    public int pickIndex() {
        int value = random.nextInt(sum);
        System.out.println("value:" + value);
        return indexes.floor(new Key(value)).index;
    }

    private static class Key implements Comparable<Key> {
        final int loValue;
        final int index;

        private Key(int loValue) {
            this(loValue, -1);
        }

        private Key(int loValue, int index) {
            this.loValue = loValue;
            this.index = index;
        }

        @Override
        public int compareTo(Key o) {
            return Integer.compare(loValue, o.loValue);
        }
    }
}
