package ru.gorbunov.tasks.fb.arrays;

import java.util.Arrays;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

/**
 * Contiguous Subarrays
 * <p>
 * You are given an array arr of N integers. For each index i, you are required to determine the number of contiguous
 * subarrays that fulfills the following conditions:
 * The value at index i must be the maximum element in the contiguous subarrays, and
 * These contiguous subarrays must either start from or end on index i.
 * Signature
 * int[] countSubarrays(int[] arr)
 * Input
 * Array arr is a non-empty list of unique integers that range between 1 to 1,000,000,000
 * Size N is between 1 and 1,000,000
 * Output
 * An array where each index i contains an integer denoting the maximum number of contiguous subarrays of arr[i]
 * <p>
 * Example:
 * arr = [3, 4, 1, 6, 2]
 * output = [1, 3, 1, 5, 1]
 * Explanation:
 * <p>
 * For index 0 - [3] is the only contiguous subarray that starts (or ends) with 3, and the maximum value in this subarray is 3.
 * For index 1 - [4], [3, 4], [4, 1]
 * For index 2 - [1]
 * For index 3 - [6], [6, 2], [1, 6], [4, 1, 6], [3, 4, 1, 6]
 * For index 4 - [2]
 * <p>
 * So, the answer for the above input is [1, 3, 1, 5, 1]
 */
public class ContiguousSubarrays {

    public static void main(String[] args) {
        int[] arr = new int[]{3, 4, 1, 6, 2};
        System.out.println(Arrays.toString(new ContiguousSubarrays().fastCountSubarrays(arr)));
    }

    int[] countSubarrays(int[] arr) {
        // Write your code here

        int[] result = new int[arr.length];

        for (int i = 0; i < arr.length; i++) {

            int numberOfSubarrays = 1;

            int currentIndex = i - 1;
            while (currentIndex >= 0 && arr[currentIndex] < arr[i]) {
                numberOfSubarrays++;
                currentIndex--;
            }

            currentIndex = i + 1;
            while (currentIndex <= arr.length - 1 && arr[currentIndex] < arr[i]) {
                numberOfSubarrays++;
                currentIndex++;
            }

            result[i] = numberOfSubarrays;
        }

        return result;
    }

    int[] fastCountSubarrays(int[] arr) {
        Deque<Integer> stack = new LinkedList<>();
        int[] ans = new int[arr.length];
        for(int i = 0; i < arr.length; i++) {
            while(!stack.isEmpty() && arr[stack.peek()] < arr[i]) {
                ans[i] += ans[stack.pop()];
            }
            stack.push(i);
            ans[i]++;
        }
        stack.clear();
        int[] temp = new int[arr.length];
        for(int i = arr.length - 1; i >= 0; i--) {
            while(!stack.isEmpty() && arr[stack.peek()] < arr[i]) {
                int idx = stack.pop();
                ans[i] += temp[idx];
                temp[i] += temp[idx];
            }
            stack.push(i);
            temp[i]++;
        }
        return ans;
    }
}
