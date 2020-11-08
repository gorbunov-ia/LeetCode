package ru.gorbunov.tasks._0078subsets;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

/**
 * Subsets
 * <p>
 * Given a set of distinct integers, nums, return all possible subsets (the power set).
 * Note: The solution set must not contain duplicate subsets.
 * Example:
 * Input: nums = [1,2,3]
 * Output:
 * [
 * [3],
 * [1],
 * [2],
 * [1,2,3],
 * [1,3],
 * [2,3],
 * [1,2],
 * []
 * ]
 */
public class Solution {

    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        LinkedList<Integer> current = new LinkedList<>();
        Set<Integer> other = Arrays.stream(nums)
                .boxed()
                .collect(Collectors.toSet());
        backtrack(other, current, result);
        return result;
    }

    private void backtrack(Set<Integer> other, LinkedList<Integer> current, List<List<Integer>> accumulator) {
        accumulator.add(new ArrayList<>(current));
        Set<Integer> copy = new HashSet<>(other);
        for (Integer digit : other) {
            current.add(digit);
            copy.remove(digit);

            backtrack(copy, current, accumulator);

            current.removeLast();
        }
    }

    /**
     * Runtime complexity (N * 2^N)
     */
    public List<List<Integer>> easySubsets(int[] nums) {
        List<List<Integer>> output = new ArrayList<>();
        LinkedList<Integer> current = new LinkedList<>();
        for (int k = 0; k < nums.length + 1; k++) {
            backtrack(0, k, nums, current, output);
        }
        return output;
    }

    private void backtrack(int first, int numberOfDigits, int[] nums, List<Integer> current, List<List<Integer>> accumulator) {
        if (current.size() == numberOfDigits) {
            accumulator.add(new ArrayList<>(current));
            return;
        }

        for (int i = first; i < nums.length; i++) {
            current.add(nums[i]);

            backtrack(i + 1, numberOfDigits, nums, current, accumulator);

            current.remove(current.size() - 1);
        }
    }

}
