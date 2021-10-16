package ru.gorbunov.tasks._0398randompickindex;

import java.util.concurrent.ThreadLocalRandom;

/**
 * Reservoir sampling
 */
class SpaceSolution {
    private final int[] nums;
    private final ThreadLocalRandom rand = ThreadLocalRandom.current();

    /**
     * Runtime complexity O(1)
     * Space complexity O(1)
     */
    public SpaceSolution(int[] nums) {
        this.nums = nums;
    }

    /**
     * Runtime complexity O(N)
     * Space complexity O(1)
     */
    public int pick(int target) {
        int n = this.nums.length;
        int count = 0;
        int idx = 0;
        for (int i = 0; i < n; ++i) {
            // if nums[i] is equal to target, i is a potential candidate
            // which needs to be chosen uniformly at random
            if (this.nums[i] == target) {
                // increment the count of total candidates
                // available to be chosen uniformly at random
                count++;
                // we pick the current number with probability 1 / count (reservoir sampling)
                if (rand.nextInt(count) == 0) {
                    idx = i;
                }
            }
        }
        return idx;
    }
}
