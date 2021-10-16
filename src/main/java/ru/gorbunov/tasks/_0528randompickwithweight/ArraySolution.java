package ru.gorbunov.tasks._0528randompickwithweight;

import java.util.concurrent.ThreadLocalRandom;

public class ArraySolution implements Solution {

    private final ThreadLocalRandom random = ThreadLocalRandom.current();
    //[1,3]
    private final int[] indexes;
    private final int sum;

    /**
     * S - summary of numbers
     * N - element's number of w
     * Runtime complexity O(N * S)
     * Space complexity O(S)
     */
    public ArraySolution(int[] w) {
        int sum = 0;
        for (int weight : w) {
            sum += weight;
        }
        this.sum = sum;
        indexes = new int[sum];
        int s = 0;
        for (int i = 0; i < w.length; i++) {
            for (int j = 0; j < w[i]; j++) {
                indexes[s++] = i;
            }
        }
    }

    //[0.00;0.25)
    //[0.25;1.00)

    //[0.00;1.00)
    //[1.00;4.00)
    //[0,1,1,1]

    /**
     * Runtime complexity O(1)
     * Space complexity O(1)
     */
    @Override
    public int pickIndex() {
        int index = random.nextInt(sum);
        System.out.println("index:" + index);
        return indexes[index];
    }

}
