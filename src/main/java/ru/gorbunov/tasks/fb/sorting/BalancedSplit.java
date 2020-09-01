package ru.gorbunov.tasks.fb.sorting;

import java.util.Arrays;

/**
 * Balanced Split
 * <p>
 * Given an array of integers (which may include repeated integers), determine if there's a way to split the array into
 * two subarrays A and B such that the sum of the integers in both arrays is the same, and all of the integers in A are
 * strictly smaller than all of the integers in B.
 * Note: Strictly smaller denotes that every integer in A must be less than, and not equal to, every integer in B.
 * Signature
 * bool balancedSplitExists(int[] arr)
 * Input
 * All integers in array are in the range [0, 1,000,000,000].
 * Output
 * Return true if such a split is possible, and false otherwise.
 * Example 1
 * arr = [1, 5, 7, 1]
 * output = true
 * We can split the array into A = [1, 1, 5] and B = [7].
 * Example 2
 * arr = [12, 7, 6, 7, 6]
 * output = false
 * We can't split the array into A = [6, 6, 7] and B = [7, 12] since this doesn't satisfy the requirement that all
 * integers in A are smaller than all integers in B.
 */
public class BalancedSplit {

    boolean balancedSplitExists(int[] arr) {
        // Write your code here
        int sum = 0;
        for (int j : arr) {
            sum += j;
        }

        if (sum % 2 != 0) {
            return false;
        }

        Arrays.sort(arr);

        int targetSum = sum / 2;
        int sumOfSubarray = 0;
        for (int i = 0; i < arr.length && sumOfSubarray <= targetSum; i++) {
            sumOfSubarray += arr[i];
            if (sumOfSubarray == targetSum) {
                if (i < arr.length - 1 && arr[i] < arr[i + 1]) {
                    return true;
                }
            }
        }

        return false;
    }
}
