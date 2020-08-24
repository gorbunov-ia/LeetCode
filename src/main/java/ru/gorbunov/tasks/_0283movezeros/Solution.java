package ru.gorbunov.tasks._0283movezeros;

/**
 * Move zeros
 * <p>
 * Given an array nums, write a function to move all 0's to the end of it while maintaining the relative order of the non-zero elements.
 * <p>
 * Example:
 * Input: [0,1,0,3,12]
 * Output: [1,3,12,0,0]
 * <p>
 * Note:
 * You must do this in-place without making a copy of the array.
 * Minimize the total number of operations.
 */
public class Solution {
    public void moveZeroes(int[] nums) {
        int j = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != 0) {
                if (i != j) { //optimization. Array without zeros [1, 1, 1]
                    nums[j] = nums[i];
                }
                j++;
            }
        }

        if (j > 0) { //optimization. Array with all zeros [0, 0, 0]
            for (; j < nums.length; j++) {
                nums[j] = 0;
            }
        }
    }
}
