package ru.gorbunov.tasks._0347topkfrequentelements;

import java.util.Arrays;
import java.util.LinkedList;
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

    /**
     * Runtime complexity O(N*logK)
     * Space complexity O(N+K)
     */
    public int[] topKFrequent(int[] nums, int k) {
        Map<Integer, Long> counts = getCounts(nums);

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

    private Map<Integer, Long> getCounts(int[] nums) {
        return Arrays.stream(nums)
                .boxed()
                .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));
    }

    /**
     * Runtime complexity O(N)
     * Space complexity O(N)
     */
    public int[] fastTopKFrequent(int[] nums, int k) {
        Map<Integer, Long> frequencies = getCounts(nums);
        LinkedList<Integer>[] buckets = bucketSort(frequencies, nums.length);

        int[] ans = new int[k];
        int i = 0;

        for (LinkedList<Integer> bucket : buckets) {
            if (bucket == null) continue;

            for (int num : bucket) {
                ans[i++] = num;
                if (i == k) return ans;
            }
        }

        return ans;
    }

    private LinkedList<Integer>[] bucketSort(Map<Integer, Long> frequencies, int max) {
        LinkedList<Integer>[] buckets = new LinkedList[max];

        for (Map.Entry<Integer, Long> entry : frequencies.entrySet()) {
            int num = entry.getKey();
            int frequency = entry.getValue().intValue();
            int index = max - frequency;

            if (buckets[index] == null) {
                buckets[index] = new LinkedList<>();
            }
            buckets[index].addFirst(num);
        }

        return buckets;
    }

}
