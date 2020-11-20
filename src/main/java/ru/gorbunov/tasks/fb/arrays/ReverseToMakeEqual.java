package ru.gorbunov.tasks.fb.arrays;

import java.util.Arrays;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

/**
 * Reverse to Make Equal
 * <p>
 * Given two arrays A and B of length N, determine if there is a way to make A equal to B by reversing any subarrays
 * from array B any number of times.
 * Signature
 * bool areTheyEqual(int[] arr_a, int[] arr_b)
 * Input
 * All integers in array are in the range [0, 1,000,000,000].
 * Output
 * Return true if B can be made equal to A, return false otherwise.
 * <p>
 * Example
 * A = [1, 2, 3, 4]
 * B = [1, 4, 3, 2]
 * output = true
 * After reversing the subarray of B from indices 1 to 3, array B will equal array A.
 *
 * @see ru.gorbunov.tasks._1460maketwoarraysequal.Solution#canBeEqual(int[], int[])
 */
public class ReverseToMakeEqual {

    boolean areTheyEqual(int[] array_a, int[] array_b) {
        // Write your code here
        Map<Integer, Long> aDict = Arrays.stream(array_a)
                .boxed()
                .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));

        for (int value : array_b) {
            Long count = aDict.get(value);
            if (count == null) {
                return false;
            }
            count--;
            if (count.equals(0L)) {
                aDict.remove(value);
            } else {
                aDict.put(value, count);
            }
        }
        return aDict.isEmpty();
    }
}
