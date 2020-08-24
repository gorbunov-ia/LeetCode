package ru.gorbunov.tasks.fb.heaps;

import org.w3c.dom.ls.LSOutput;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Queue;

/**
 * Median Stream
 * <p>
 * You're given a list of n integers arr[0..(n-1)]. You must compute a list output[0..(n-1)] such that, for each index
 * i (between 0 and n-1, inclusive), output[i] is equal to the median of the elements arr[0..i] (rounded down to the
 * nearest integer).
 * The median of a list of integers is defined as follows. If the integers were to be sorted, then:
 * If there are an odd number of integers, then the median is equal to the middle integer in the sorted order.
 * Otherwise, if there are an even number of integers, then the median is equal to the average of the two middle-most
 * integers in the sorted order.
 * <p>
 * Signature
 * int[] findMedian(int[] arr)
 * Input
 * n is in the range [1, 1,000,000].
 * Each value arr[i] is in the range [1, 1,000,000].
 * Output
 * Return a list of n integers output[0..(n-1)], as described above.
 * Example 1
 * n = 4
 * arr = [5, 15, 1, 3]
 * output = [5, 10, 5, 4]
 * The median of [5] is 5, the median of [5, 15] is (5 + 15) / 2 = 10, the median of [5, 15, 1] is 5, and the median
 * of [5, 15, 1, 3] is (3 + 5) / 2 = 4.
 * Example 2
 * n = 2
 * arr = [1, 2]
 * output = [1, 1]
 * The median of [1] is 1, the median of [1, 2] is (1 + 2) / 2 = 1.5 (which should be rounded down to 1).
 */
public class MedianStream {

    public static void main(String[] args) {
        int[] arr = new int[]{5, 15, 1, 3};
        System.out.println(Arrays.toString(new MedianStream().findMedian(arr)));
        System.out.println(Arrays.toString(new MedianStream().fastFindMedian(arr)));
    }

    // Add any helper functions you may need here
    private void fixSort(int[] arr, int last) {
        //like babble sort

        while (last > 0 && arr[last] < arr[last - 1]) {
            int temp = arr[last - 1];
            arr[last - 1] = arr[last];
            arr[last] = temp;
            last--;
        }
    }

    int[] findMedian(int[] arr) {
        // Write your code here
        int[] sorted = new int[arr.length];
        int[] result = new int[arr.length];

        for (int i = 0; i < arr.length; i++) {
            sorted[i] = arr[i];
            fixSort(sorted, i);
            if ((i + 1) % 2 == 0) {
                result[i] = (sorted[i / 2] + sorted[i / 2 + 1]) / 2;
            } else {
                result[i] = sorted[i / 2];
            }
        }

        return result;
    }

    int[] fastFindMedian(int[] arr) {
        // Write your code here
        int[] result = new int[arr.length];

        final Queue<Integer> lo = new PriorityQueue<>(Comparator.reverseOrder());
        final Queue<Integer> hi = new PriorityQueue<>(Comparator.naturalOrder());

        for (int i = 0; i < arr.length; i++) {

            // addNum
            lo.add(arr[i]);                                  // Add to max heap

            hi.add(lo.peek());                               // balancing step
            lo.poll();

            if (lo.size() < hi.size()) {                     // maintain size property
                lo.add(hi.peek());
                hi.poll();
            }

            // findMedian
            result[i] = lo.size() > hi.size() ? lo.peek() : (lo.peek() + hi.peek()) / 2;
        }

        return result;
    }

}
