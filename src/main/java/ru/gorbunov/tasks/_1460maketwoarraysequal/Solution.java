package ru.gorbunov.tasks._1460maketwoarraysequal;

import java.util.Arrays;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

/**
 * Make Two Arrays Equal by Reversing Sub-arrays
 * <p>
 * Given two integer arrays of equal length target and arr.
 * In one step, you can select any non-empty sub-array of arr and reverse it. You are allowed to make any number of steps.
 * Return True if you can make arr equal to target, or False otherwise.
 * <p>
 * Constraints:
 * target.length == arr.length
 * 1 <= target.length <= 1000
 * 1 <= target[i] <= 1000
 * 1 <= arr[i] <= 1000
 */
public class Solution {

    public boolean canBeEqual(int[] target, int[] arr) {
        Map<Integer, Long> aDict = Arrays.stream(target)
                .boxed()
                .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));

        for (int value : arr) {
            Long count = aDict.get(value);
            if (count == null) {
                return false;
            }
            if (count.equals(1L)) {
                aDict.remove(value);
            } else {
                aDict.put(value, count - 1);
            }
        }
        return aDict.isEmpty();
    }

}
