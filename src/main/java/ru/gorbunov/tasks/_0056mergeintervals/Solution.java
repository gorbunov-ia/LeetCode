package ru.gorbunov.tasks._0056mergeintervals;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

/**
 * Merge Intervals
 * <p>
 * Given a collection of intervals, merge all overlapping intervals.
 * Example 1:
 * Input: intervals = [[1,3],[2,6],[8,10],[15,18]]
 * Output: [[1,6],[8,10],[15,18]]
 * Explanation: Since intervals [1,3] and [2,6] overlaps, merge them into [1,6].
 * Example 2:
 * Input: intervals = [[1,4],[4,5]]
 * Output: [[1,5]]
 * Explanation: Intervals [1,4] and [4,5] are considered overlapping.
 * Constraints:
 * intervals[i][0] <= intervals[i][1]
 */
public class Solution {

    public int[][] merge(int[][] intervals) {
        if (intervals == null || intervals.length <= 1) {
            return intervals;
        }
        Arrays.sort(intervals, Comparator.comparing(a -> a[0], Integer::compareTo));

        List<int[]> result = new ArrayList<>();
        int[] interval = intervals[0];
        for (final int[] newInterval : intervals) {
            if (interval[1] >= newInterval[0]) {
                interval[1] = Math.max(interval[1], newInterval[1]);
            } else {
                result.add(interval);
                interval = newInterval;
            }
        }
        result.add(interval);

        return toArray(result);
    }

    private int[][] toArray(List<int[]> list) {
        int[][] a = new int[list.size()][2];
        return list.toArray(a);
    }
}
