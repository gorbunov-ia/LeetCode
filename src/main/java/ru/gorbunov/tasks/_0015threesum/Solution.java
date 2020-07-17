package ru.gorbunov.tasks._0015threesum;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * 3Sum
 * <p>
 * Given an array nums of n integers, are there elements a, b, c in nums such that a + b + c = 0? Find all unique
 * triplets in the array which gives the sum of zero.
 * <p>
 * Note: The solution set must not contain duplicate triplets.
 * Example:
 * Given array nums = [-1, 0, 1, 2, -1, -4],
 * A solution set is:
 * [
 * [-1, 0, 1],
 * [-1, -1, 2]
 * ]
 */
public class Solution {

    /**
     * Time complexity is O(n^2 * lgN)
     */
    public List<List<Integer>> threeSum(int[] nums) {

        Arrays.sort(nums);

        List<List<Integer>> result = new ArrayList<>();
        for (int i = 0; i < nums.length; i++) {
            if (i > 0 && nums[i] == nums[i - 1]) {
                continue;
            }
            for (int j = i + 1; j < nums.length; j++) {
                if (j > i + 1 && nums[j] == nums[j - 1]) {
                    continue;
                }
                int k = -nums[i] - nums[j];
                if (Arrays.binarySearch(nums, j + 1, nums.length, k) >= 0) {
                    result.add(Arrays.asList(nums[i], nums[j], k));
                }
            }
        }

        return result;
    }

    /**
     * The idea is to sort an input array and then run through all indices of a possible first element of a triplet.
     * For each possible first element we make a standard bi-directional 2Sum sweep of the remaining part of the array.
     * Also we want to skip equal elements to avoid duplicates in the answer without making a set or smth like that.
     * Time complexity is O(n^2)
     */
    public List<List<Integer>> fastThreeSum(int[] num) {
        Arrays.sort(num);
        List<List<Integer>> res = new LinkedList<>();
        for (int i = 0; i < num.length - 2; i++) {
            if (i == 0 || num[i] != num[i - 1]) {
                int lo = i + 1, hi = num.length - 1, sum = -num[i];
                while (lo < hi) {
                    if (num[lo] + num[hi] == sum) {
                        res.add(Arrays.asList(num[i], num[lo], num[hi]));
                        while (lo < hi && num[lo] == num[lo + 1]) {
                            lo++;
                        }
                        while (lo < hi && num[hi] == num[hi - 1]) {
                            hi--;
                        }
                        lo++;
                        hi--;
                    } else if (num[lo] + num[hi] < sum) {
                        lo++;
                    } else {
                        hi--;
                    }
                }
            }
        }
        return res;
    }

}
