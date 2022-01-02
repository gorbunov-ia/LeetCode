package ru.gorbunov.tasks._0448findallnumbersdisappearedinanarray;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * 448. Find All Numbers Disappeared in an Array
 * <p>
 * Given an array nums of n integers where nums[i] is in the range [1, n], return an array of all the integers in the
 * range [1, n] that do not appear in nums.
 * Example 1:
 * Input: nums = [4,3,2,7,8,2,3,1]
 * Output: [5,6]
 * Example 2:
 * Input: nums = [1,1]
 * Output: [2]
 * Constraints:
 * n == nums.length
 * 1 <= n <= 10^5
 * 1 <= nums[i] <= n
 */
public class Solution {

    public List<Integer> findDisappearedNumbers(int[] nums) {
        if (nums == null || nums.length == 0) {
            return Collections.emptyList();
        }
        Arrays.sort(nums);

        List<Integer> result = new ArrayList<>();
        int previous = 0;
        for (int num : nums) {
            if (num - previous > 1) {
                result.addAll(range(previous + 1, num));
            }
            previous = num;
        }
        if (previous != nums.length) {
            result.addAll(range(previous + 1, nums.length + 1));
        }
        return result;
    }

    private List<Integer> range(int from, int to) {
        List<Integer> result = new ArrayList<>(to - from);
        for (int i = from; i < to; i++) {
            result.add(i);
        }
        return result;
    }
}
