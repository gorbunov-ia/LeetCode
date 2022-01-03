package ru.gorbunov.tasks._0031nextpermutation;

/**
 * 31. Next Permutation
 * <p>
 * Implement next permutation, which rearranges numbers into the lexicographically next greater permutation of numbers.
 * If such an arrangement is impossible, it must rearrange it to the lowest possible order (i.e., sorted in
 * ascending order).
 * The replacement must be in place and use only constant extra memory.
 * Example 1:
 * Input: nums = [1,2,3]
 * Output: [1,3,2]
 * Example 2:
 * Input: nums = [3,2,1]
 * Output: [1,2,3]
 * Example 3:
 * Input: nums = [1,1,5]
 * Output: [1,5,1]
 * Constraints:
 * 1 <= nums.length <= 100
 * 0 <= nums[i] <= 100
 */
public class Solution {

    public void nextPermutation(int[] nums) {
        if (nums == null || nums.length <= 1) {
            return;
        }
        int fromIndex = permuteOne(nums);
        reverse(nums, fromIndex);
    }

    private int permuteOne(int[] nums) {
        for (int i = nums.length - 1; i > 0; i--) {
            if (nums[i] > nums[i-1]) {
                int j = nums.length - 1;
                while(nums[i - 1] >= nums[j]) {
                    j--;
                }
                swap(nums, i - 1, j);
                return i;
            }
        }
        return 0;
    }

    private void reverse(int[] nums, int fromIndex) {
        int toIndex = (nums.length - fromIndex) / 2;
        for (int i = 0; i < toIndex; i++) {
            swap(nums, fromIndex + i, nums.length - 1 - i);
        }
    }

    private void swap(int[] nums, int i, int j) {
        int tmp = nums[i];
        nums[i] = nums[j];
        nums[j] = tmp;
    }
}
