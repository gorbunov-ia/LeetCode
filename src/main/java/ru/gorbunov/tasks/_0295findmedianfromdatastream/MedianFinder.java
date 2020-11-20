package ru.gorbunov.tasks._0295findmedianfromdatastream;


import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Queue;

/**
 * Find Median from Data Stream
 * <p>
 * Median is the middle value in an ordered integer list. If the size of the list is even, there is no middle value. So the median is the mean of the two middle value.
 * For example,
 * [2,3,4], the median is 3
 * [2,3], the median is (2 + 3) / 2 = 2.5
 * Design a data structure that supports the following two operations:
 * void addNum(int num) - Add a integer number from the data stream to the data structure.
 * double findMedian() - Return the median of all elements so far.
 * Example:
 * addNum(1)
 * addNum(2)
 * findMedian() -> 1.5
 * addNum(3)
 * findMedian() -> 2
 * <p>
 * Follow up:
 * If all integer numbers from the stream are between 0 and 100, how would you optimize it?
 * If 99% of all integer numbers from the stream are between 0 and 100, how would you optimize it?
 */
public class MedianFinder {

    private final Queue<Integer> lo = new PriorityQueue<>(Comparator.reverseOrder());
    private final Queue<Integer> hi = new PriorityQueue<>(Comparator.naturalOrder());

    /**
     * initialize your data structure here.
     */
    public MedianFinder() {
    }

    public void addNum(int num) {
        lo.add(num);                                    // Add to max heap

        hi.add(lo.poll());                               // balancing step

        if (lo.size() < hi.size()) {                     // maintain size property
            lo.add(hi.poll());
        }
    }

    public double findMedian() {
        return lo.size() > hi.size() ? lo.peek() : ((double) (lo.peek() + hi.peek())) * 0.5;
    }
}
