package ru.gorbunov.tasks._0001twosum;

import java.util.*;

public class Solution {
    public static void main(String[] args) {

        int[] nums = {2, 7, 11, 15};
        int target = 9;

        //int[] result = new Solution().twoSum(nums,target);
        int[] result = new Solution().fastTwoSum(nums,target);
        System.out.print("result: [ ");
        for(int i = 0; i < result.length; i++) {
            System.out.print(result[i] + " ");
        }
        System.out.println("]");
    }

    public int[] twoSum(int[] nums, int target) {
        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                if (nums[i] + nums[j] == target)
                    return new int[] {i,j};
            }
        }
        throw new IllegalArgumentException("No two sum solution");
    }

    public int[] fastTwoSum(int[] nums, int target) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            int complement = target - nums[i];
            if (map.containsKey(complement)) {
                return new int[] { map.get(complement), i };
            }
            map.put(nums[i], i);
        }
        throw new IllegalArgumentException("No two sum solution");
    }

}
