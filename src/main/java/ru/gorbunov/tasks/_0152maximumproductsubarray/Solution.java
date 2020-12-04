package ru.gorbunov.tasks._0152maximumproductsubarray;

/**
 * Maximum Product Subarray
 * <p>
 * Given an integer array nums, find the contiguous subarray within an array (containing at least one number) which has the largest product.
 * Example 1:
 * Input: [2,3,-2,4]
 * Output: 6
 * Explanation: [2,3] has the largest product 6.
 * Example 2:
 * Input: [-2,0,-1]
 * Output: 0
 * Explanation: The result cannot be 2, because [-2,-1] is not a subarray.
 */
public class Solution {

    public int maxProduct(int[] nums) {
        if (nums.length == 0) {
            return 0;
        }
        int max = nums[0];
        int current = 1;
        for (int num : nums) {
            current *= num;
            max = Math.max(current, max);
            if (current == 0) {
                current = 1;
            }
        }
        current = 1;
        for (int i = nums.length - 1; i >= 0; i--) {
            current *= nums[i];
            max = Math.max(current, max);
            if (current == 0) {
                current = 1;
            }
        }
        return max;
    }

    public int fastMaxProduct(int[] nums) {
        if (nums.length == 0) {
            return 0;
        }
        int max = Integer.MIN_VALUE;    // global max
        int maxloc = 1;
        int minloc = 1;                 // max or min end here
        for (int num : nums) {          // negative could cause maxloc and minloc swap
            int prod1 = maxloc * num;
            int prod2 = minloc * num;

            maxloc = Math.max(num, Math.max(prod1, prod2));
            minloc = Math.min(num, Math.min(prod1, prod2));

            max = Math.max(max, maxloc);
        }
        return max;
    }
}
