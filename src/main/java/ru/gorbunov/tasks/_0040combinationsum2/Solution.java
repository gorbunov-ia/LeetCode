package ru.gorbunov.tasks._0040combinationsum2;

import java.util.*;

/**
 * 40. Combination Sum II
 * <p>
 * Given a collection of candidate numbers (candidates) and a target number (target), find all unique combinations in
 * candidates where the candidate numbers sum to target. Each number in candidates may only be used once in the combination.
 * Note: The solution set must not contain duplicate combinations.
 * Example 1:
 * Input: candidates = [10,1,2,7,6,1,5], target = 8
 * Output:
 * [
 * [1,1,6],
 * [1,2,5],
 * [1,7],
 * [2,6]
 * ]
 * Example 2:
 * Input: candidates = [2,5,2,1,2], target = 5
 * Output:
 * [
 * [1,2,2],
 * [5]
 * ]
 * Constraints:
 * 1 <= candidates.length <= 100
 * 1 <= candidates[i] <= 50
 * 1 <= target <= 30
 */
public class Solution {

    public List<List<Integer>> slowCombinationSum2(int[] candidates, int target) {
        Arrays.sort(candidates);

        Set<List<Integer>> result = new LinkedHashSet<>();
        generate(candidates, target, result, new CurrentSumList(), 0);

        return new ArrayList<>(result);
    }

    private void generate(int[] candidates, int target, Set<List<Integer>> result, CurrentSumList current, int index) {
        if (current.sum == target) {
            result.add(current.getList());
        }

        for (int i = index; i < candidates.length; i++) {
            current.add(candidates[i]);

            generate(candidates, target, result, current, i + 1);

            current.removeLast();
        }

    }

    private static class CurrentSumList {

        private final LinkedList<Integer> list = new LinkedList<>();
        private int sum = 0;


        public List<Integer> getList() {
            return new ArrayList<>(list);
        }

        public void add(int value) {
            list.add(value);
            sum += value;
        }

        public void removeLast() {
            sum -= list.removeLast();
        }
    }

}
