package ru.gorbunov.tasks._0128longestconsecutivesequence;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * 128. Longest Consecutive Sequence
 * <p>
 * Given an unsorted array of integers nums, return the length of the longest consecutive elements sequence.
 * You must write an algorithm that runs in O(n) time.
 * Example 1:
 * Input: nums = [100,4,200,1,3,2]
 * Output: 4
 * Explanation: The longest consecutive elements sequence is [1, 2, 3, 4]. Therefore its length is 4.
 * Example 2:
 * Input: nums = [0,3,7,2,5,8,4,6,0,1]
 * Output: 9
 * Constraints:
 * 0 <= nums.length <= 10^5
 * -10^9 <= nums[i] <= 10^9
 */
public class Solution {

    public int longestConsecutive(int[] nums) {
        Map<Integer, Set<Integer>> map = new HashMap<>();
        int maxLength = 0;
        for (int num : nums) {
            if (map.containsKey(num)) {
                continue;
            }
            Set<Integer> previous = map.get(num - 1);
            Set<Integer> next = map.get(num + 1);
            Set<Integer> current = merge(num, previous, next);
            if (previous != null && next != null) {
                replaceSet(map, previous, current);
            }
            map.put(num, current);

            maxLength = Math.max(maxLength, current.size());
        }
        return maxLength;
    }

    private Set<Integer> merge(int num, Set<Integer> previous, Set<Integer> next) {
        Set<Integer> current = new HashSet<>();
        current.add(num);
        if (previous != null) {
            previous.addAll(current);
            current = previous;
        }
        if (next != null) {
            next.addAll(current);
            current = next;
        }
        return current;
    }

    private void replaceSet(Map<Integer, Set<Integer>> map, Set<Integer> previous, Set<Integer> current) {
        for (Integer integer : previous) {
            map.put(integer, current);
        }
    }
}
