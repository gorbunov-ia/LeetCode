package ru.gorbunov.tasks._0075sortcolors;

import java.util.HashMap;
import java.util.Map;

/**
 * Sort Colors
 * <p>
 * Given an array nums with n objects colored red, white, or blue, sort them in-place so that objects of the same
 * color are adjacent, with the colors in the order red, white, and blue.
 * Here, we will use the integers 0, 1, and 2 to represent the color red, white, and blue respectively.
 * Follow up:
 * Could you solve this problem without using the library's sort function?
 * Could you come up with a one-pass algorithm using only O(1) constant space?
 * Example 1:
 * Input: nums = [2,0,2,1,1,0]
 * Output: [0,0,1,1,2,2]
 * Example 2:
 * Input: nums = [2,0,1]
 * Output: [0,1,2]
 * Example 3:
 * Input: nums = [0]
 * Output: [0]
 * Example 4:
 * Input: nums = [1]
 * Output: [1]
 */
public class Solution {

    public void sortColors(int[] nums) {
        Map<Integer, Integer> counters = new HashMap<>();

        for (int num : nums) {
            counters.merge(num, 1, Integer::sum);
        }

        int index = 0;
        for (int i = 0; i <= 2; i++) {
            Integer count = counters.getOrDefault(i, 0);
            for (int j = 0; j < count; j++) {
                nums[index] = i;
                index++;
            }
        }
    }

    public void onePassSortColors(int[] nums) {
        int p1 = 0;
        int p2 = nums.length - 1;
        int index = 0;
        while (index <= p2) {
            if (nums[index] == 0) {
                nums[index] = nums[p1];
                nums[p1] = 0;
                p1++;
            }
            if (nums[index] == 2) {
                nums[index] = nums[p2];
                nums[p2] = 2;
                p2--;
                index--;
            }
            index++;
        }
    }
}
