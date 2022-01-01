package ru.gorbunov.tasks._0169majorityelement;

import java.util.HashMap;
import java.util.Map;

/**
 * 169. Majority Element
 * <p>
 * Given an array nums of size n, return the majority element.
 * The majority element is the element that appears more than ⌊n / 2⌋ times. You may assume that the majority element
 * always exists in the array.
 * Example 1:
 * Input: nums = [3,2,3]
 * Output: 3
 * Example 2:
 * Input: nums = [2,2,1,1,1,2,2]
 * Output: 2
 * Constraints:
 * n == nums.length
 * 1 <= n <= 5 * 10^4
 * -2^31 <= nums[i] <= 2^31 - 1
 * Follow-up: Could you solve the problem in linear time and in O(1) space?
 */
public class Solution {

    public int majorityElement(int[] nums) {
        Map<Integer, Integer> map = new HashMap<>();
        int target = nums.length / 2;
        for (int num : nums) {
            int current = map.getOrDefault(num, 0) + 1;
            if (current > target) {
                return num;
            }
            map.put(num, current);
        }
        throw new IllegalArgumentException("There is no number");
    }
}
