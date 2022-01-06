package ru.gorbunov.tasks._0300longestincreasingsubsequence;

/**
 * 300. Longest Increasing Subsequence
 * <p>
 * Given an integer array nums, return the length of the longest strictly increasing subsequence.
 * A subsequence is a sequence that can be derived from an array by deleting some or no elements without changing
 * the order of the remaining elements. For example, [3,6,2,7] is a subsequence of the array [0,3,1,6,2,2,7].
 * Example 1:
 * Input: nums = [10,9,2,5,3,7,101,18]
 * Output: 4
 * Explanation: The longest increasing subsequence is [2,3,7,101], therefore the length is 4.
 * Example 2:
 * Input: nums = [0,1,0,3,2,3]
 * Output: 4
 * Example 3:
 * Input: nums = [7,7,7,7,7,7,7]
 * Output: 1
 * Constraints:
 * 1 <= nums.length <= 2500
 * -10^4 <= nums[i] <= 10^4
 * Follow up: Can you come up with an algorithm that runs in O(n log(n)) time complexity?
 */
public class Solution {
    private int maxLength = 0;

    /**
     * Runtime complexity O(N!)
     * Space complexity O(1)
     */
    public int lengthOfLIS(int[] nums) {
        //n! solution = brut force
        for (int i = 0; i < nums.length; i++) {
            maxLength(nums, i, 1);
        }
        return maxLength;
    }

    private void maxLength(int[] nums, int index, int length) {
        if (index >= nums.length) {
            return;
        }
        int lastValue = nums[index];
        for (int i = index + 1; i < nums.length; i++) {
            if (nums[i] > lastValue) {
                maxLength(nums, i, length + 1);
            }
        }
        maxLength = Math.max(maxLength, length);
    }

    /**
     * Runtime complexity O(N^2)
     * Space complexity O(N)
     */
    public int dpLengthOfLIS(int[] nums) {
        int[] dp = new int[nums.length];
        int maxLength = 1;
        for (int i = nums.length - 1; i >= 0; i--) {
            dp[i] = 1;
            for (int j = i + 1; j < nums.length; j++) {
                if (nums[i] < nums[j]) {
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                }
            }
            maxLength = Math.max(maxLength, dp[i]);
        }
        return maxLength;
    }

    /**
     * Runtime complexity O(N*logN)
     * Space complexity O(N)
     */
    public int fastLengthOfLIS(int[] nums) {
        int[] tails = new int[nums.length];
        int size = 0;
        for (int x : nums) {
            int i = 0, j = size;
            while (i != j) {
                int m = (i + j) / 2;
                if (tails[m] < x)
                    i = m + 1;
                else
                    j = m;
            }
            tails[i] = x;
            if (i == size) ++size;
        }
        return size;
    }
}
