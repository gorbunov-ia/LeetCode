package ru.gorbunov.tasks._0039combinationsum;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

/**
 * Combination Sum
 * <p>
 * Given a set of candidate numbers (candidates) (without duplicates) and a target number (target), find all unique
 * combinations in candidates where the candidate numbers sums to target.
 * The same repeated number may be chosen from candidates unlimited number of times.
 * Note:
 *     All numbers (including target) will be positive integers.
 *     The solution set must not contain duplicate combinations.
 * Example 1:
 * Input: candidates = [2,3,6,7], target = 7,
 * A solution set is:
 * [
 *   [7],
 *   [2,2,3]
 * ]
 * Example 2:
 * Input: candidates = [2,3,5], target = 8,
 * A solution set is:
 * [
 *   [2,2,2,2],
 *   [2,3,3],
 *   [3,5]
 * ]
 * Constraints:
 *     1 <= candidates.length <= 30
 *     1 <= candidates[i] <= 200
 *     Each element of candidate is unique.
 *     1 <= target <= 500
 */
public class Solution {

    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<Set<List<Integer>>> dp = new ArrayList<>(target);
        dp.add(Collections.singleton(Collections.emptyList()));

        for (int i = 1; i <= target; i++) {
            Set<List<Integer>> combinations = new HashSet<>();
            for(int j : candidates) {
                if (i - j >= 0 && !dp.get(i - j).isEmpty()) {
                    Set<List<Integer>> original = dp.get(i - j);
                    for (List<Integer> s : original) {
                        List<Integer> newList = buildNewList(j, s);
                        combinations.add(newList);
                    }
                }
            }
            dp.add(combinations);
        }

        return new ArrayList<>(dp.get(target));
    }

    private List<Integer> buildNewList(int newItem, List<Integer> s) {
        ArrayList<Integer> newList = new ArrayList<>(s.size() + 1);
        newList.addAll(s);
        newList.add(newItem);
        fixOrder(newList);
        return newList;
    }

    private void fixOrder(ArrayList<Integer> list) {
        for(int i = list.size() - 1; i > 0; i--) {
            if (list.get(i) >= list.get(i - 1)) {
                break;
            };
            int temp = list.get(i);
            list.set(i, list.get(i - 1));
            list.set(i - 1, temp);
        }
    }

    public List<List<Integer>> fastCombinationSum(int[] candidates, int target) {
        List<List<Integer>> results = new ArrayList<List<Integer>>();
        LinkedList<Integer> comb = new LinkedList<Integer>();

        this.backtrack(target, comb, 0, candidates, results);
        return results;
    }

    protected void backtrack(
            int remain,
            LinkedList<Integer> comb,
            int start, int[] candidates,
            List<List<Integer>> results) {

        if (remain == 0) {
            // make a deep copy of the current combination
            results.add(new ArrayList<Integer>(comb));
            return;
        } else if (remain < 0) {
            // exceed the scope, stop exploration.
            return;
        }

        for (int i = start; i < candidates.length; ++i) {
            // add the number into the combination
            comb.add(candidates[i]);
            this.backtrack(remain - candidates[i], comb, i, candidates, results);
            // backtrack, remove the number from the combination
            comb.removeLast();
        }
    }
}
