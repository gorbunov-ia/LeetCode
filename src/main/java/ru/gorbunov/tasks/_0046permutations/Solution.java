package ru.gorbunov.tasks._0046permutations;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

/**
 * Permutations
 * <p>
 * Given a collection of distinct integers, return all possible permutations.
 * Example:
 * Input: [1,2,3]
 * Output:
 * [
 *   [1,2,3],
 *   [1,3,2],
 *   [2,1,3],
 *   [2,3,1],
 *   [3,1,2],
 *   [3,2,1]
 * ]
 */
public class Solution {

    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();

        backtrack(result, new LinkedList<>(), new HashSet<>(), nums);

        return result;
    }

    private void backtrack(List<List<Integer>> accumulator, List<Integer> current, Set<Integer> usedNums, int[] nums) {
        if (current.size() == nums.length) {
            accumulator.add(new ArrayList<>(current));
            return;
        }
        for (Integer num : nums) {
            if (usedNums.contains(num)) {
                continue;
            }
            current.add(num);
            usedNums.add(num);

            backtrack(accumulator, current, usedNums, nums);

            current.remove(current.size() - 1);
            usedNums.remove(num);
        }
    }
}
