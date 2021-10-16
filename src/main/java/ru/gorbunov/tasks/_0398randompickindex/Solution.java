package ru.gorbunov.tasks._0398randompickindex;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ThreadLocalRandom;

/**
 * 398. Random Pick Index
 * <p>
 * Given an integer array nums with possible duplicates, randomly output the index of a given target number. You can
 * assume that the given target number must exist in the array.
 * Implement the Solution class:
 * Solution(int[] nums) Initializes the object with the array nums.
 * int pick(int target) Picks a random index i from nums where nums[i] == target. If there are multiple valid i's,
 * then each index should have an equal probability of returning.
 * Example 1:
 * Input
 * ["Solution", "pick", "pick", "pick"]
 * [[[1, 2, 3, 3, 3]], [3], [1], [3]]
 * Output
 * [null, 4, 0, 2]
 * Explanation
 * Solution solution = new Solution([1, 2, 3, 3, 3]);
 * solution.pick(3); // It should return either index 2, 3, or 4 randomly. Each index should have equal probability of returning.
 * solution.pick(1); // It should return 0. Since in the array only nums[0] is equal to 1.
 * solution.pick(3); // It should return either index 2, 3, or 4 randomly. Each index should have equal probability of returning.
 * Constraints:
 * 1 <= nums.length <= 2 * 10^4
 * -2^31 <= nums[i] <= 2^31 - 1
 * target is an integer from nums.
 * At most 10^4 calls will be made to pick.
 */
public class Solution {
    private final Map<Integer, List<Integer>> indexMap = new HashMap<>();
    private final ThreadLocalRandom random = ThreadLocalRandom.current();

    /**
     * Runtime complexity O(N)
     * Space complexity O(N)
     */
    public Solution(int[] nums) {
        for (int i = 0; i < nums.length; i++) {
            indexMap.computeIfAbsent(nums[i], k -> new ArrayList<>()).add(i);
        }
    }

    /**
     * Runtime complexity O(1)
     * Space complexity O(1)
     */
    public int pick(int target) {
        List<Integer> indexes = indexMap.get(target);
        int index = random.nextInt(indexes.size());
        return indexes.get(index);
    }

}
