package ru.gorbunov.tasks.fb.graphs;

import java.util.Arrays;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;

/**
 * Minimizing Permutations
 * <p>
 * In this problem, you are given an integer N, and a permutation, P of the integers from 1 to N, denoted as
 * (a_1, a_2, ..., a_N). You want to rearrange the elements of the permutation into increasing order, repeatedly making
 * the following operation:
 * Select a sub-portion of the permutation, (a_i, ..., a_j), and reverse its order.
 * Your goal is to compute the minimum number of such operations required to return the permutation to increasing order.
 * Signature
 * int minOperations(int[] arr)
 * Input
 * Array arr is a permutation of all integers from 1 to N, N is between 1 and 8
 * Output
 * An integer denoting the minimum number of operations required to arrange the permutation in increasing order
 * Example
 * If N = 3, and P = (3, 1, 2), we can do the following operations:
 * Select (1, 2) and reverse it: P = (3, 2, 1).
 * Select (3, 2, 1) and reverse it: P = (1, 2, 3).
 * output = 2
 */
public class MinimizingPermutations {
    // Add any helper functions you may need here
    int get_index(int[] arr) {

        int val = 0;
        for (int j : arr) {
            val = arr.length * val + j - 1;
        }

        return val;
    }

    int minOperations(int[] arr) {
        // Write your code here
        int n = arr.length;
        if (n <= 1) {
            return 0;
        }

        Set<Integer> mySet = new HashSet<>();

        int target = 0;
        for (int i = 0; i < n; i++) {
            target = n * target + i;
        }
        int index = get_index(arr);
        if (index == target) {
            return 0;
        }

        mySet.add(index);
        Queue<Integer> q = new LinkedList<>();
        q.add(index);
        for (int steps = 1; ; steps++) {
            int size = q.size();
            for (int i = 0; i < size; i++) {
                index = q.poll();
                int[] u = new int[n];
                for (int j = n - 1; j >= 0; j--) {
                    u[j] = (index % n) + 1;
                    index /= n;
                }

                for (int j = 0; j < n; j++)
                    for (int k = j + 2; k <= n; k++) {
                        int[] w = Arrays.copyOf(u, u.length);
                        reverse(w, j, k); //reverse the subsequence
                        int index2 = get_index(w);
                        if (index2 == target) {
                            return steps;
                        }
                        if (mySet.contains(index2)) {
                            continue;
                        }
                        mySet.add(index2);
                        q.add(index2);
                    }
            }
        }
    }

    /**
     * Reverses the order of the elements in the range [first,last).
     */
    private void reverse(int[] a, int first, int last) {
        for (int i = 0; i < (last - first) / 2; i++) {
            int temp = a[first + i];
            a[first + i] = a[last - i - 1];
            a[last - i - 1] = temp;
        }
    }

}
