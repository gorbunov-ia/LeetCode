package ru.gorbunov.tasks._0347topkfrequentelements;

import java.util.Arrays;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.function.Function;
import java.util.stream.Collectors;

/**
 * 347. Top K Frequent Elements
 * <p>
 * Given an integer array nums and an integer k, return the k most frequent elements. You may return the answer
 * in any order.
 * Example 1:
 * Input: nums = [1,1,1,2,2,3], k = 2
 * Output: [1,2]
 * Example 2:
 * Input: nums = [1], k = 1
 * Output: [1]
 * Constraints:
 * 1 <= nums.length <= 10^5
 * k is in the range [1, the number of unique elements in the array].
 * It is guaranteed that the answer is unique.
 * Follow up: Your algorithm's time complexity must be better than O(n log n), where n is the array's size.
 */
public class Solution {

    public int[] topKFrequent(int[] nums, int k) {
        Map<Integer, Long> counts = Arrays.stream(nums)
                .boxed()
                .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));

        PriorityQueue<Map.Entry<Integer, Long>> heap = new PriorityQueue<>(Map.Entry.comparingByValue());

        for (Map.Entry<Integer, Long> entry : counts.entrySet()) {
            heap.add(entry);
            if (heap.size() > k) {
                heap.poll();
            }
        }

        return heap.stream()
                .mapToInt(Map.Entry::getKey)
                .toArray();
    }

}
