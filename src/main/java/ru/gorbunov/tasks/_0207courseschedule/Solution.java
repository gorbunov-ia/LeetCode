package ru.gorbunov.tasks._0207courseschedule;

import java.util.*;

/**
 * 207. Course Schedule
 * <p>
 * There are a total of numCourses courses you have to take, labeled from 0 to numCourses - 1. You are given an array
 * prerequisites where prerequisites[i] = [a_i, b_i] indicates that you must take course b_i first if you want to
 * take course a_i.
 * For example, the pair [0, 1], indicates that to take course 0 you have to first take course 1.
 * Return true if you can finish all courses. Otherwise, return false.
 * Example 1:
 * Input: numCourses = 2, prerequisites = [[1,0]]
 * Output: true
 * Explanation: There are a total of 2 courses to take.
 * To take course 1 you should have finished course 0. So it is possible.
 * Example 2:
 * Input: numCourses = 2, prerequisites = [[1,0],[0,1]]
 * Output: false
 * Explanation: There are a total of 2 courses to take.
 * To take course 1 you should have finished course 0, and to take course 0 you should also have finished course 1.
 * So it is impossible.
 * Constraints:
 * 1 <= numCourses <= 10^5
 * 0 <= prerequisites.length <= 5000
 * prerequisites[i].length == 2
 * 0 <= a_i, b_i < numCourses
 * All the pairs prerequisites[i] are unique.
 */
public class Solution {

    public boolean canFinish(int numCourses, int[][] prerequisites) {
        Map<Integer, Set<Integer>> map = new HashMap<>();
        for (int[] pair : prerequisites) {
            if (pair[0] == pair[1]) {
                return false;
            }
            map.computeIfAbsent(pair[0], (k) -> new HashSet<>()).add(pair[1]);
        }
        while (!map.isEmpty()) {
            Set<Integer> visited = new HashSet<>();
            Integer vertex = map.keySet().iterator().next();
            visited.add(vertex);
            Set<Integer> dependencies = map.get(vertex);
            if (hasCycle(visited, dependencies, map)) {
                return false;
            }
            visited.forEach(map::remove);
        }
        return true;
    }

    private boolean hasCycle(Set<Integer> visited, Set<Integer> candidates, Map<Integer, Set<Integer>> storage) {
        for (Integer candidate : candidates) {
            if (!storage.containsKey(candidate)) {
                continue;
            }
            if (visited.contains(candidate)) {
                return true;
            }
            visited.add(candidate);
            if (hasCycle(visited, storage.get(candidate), storage)) {
                return true;
            }
            visited.remove(candidate);
        }
        return false;
    }

    public boolean bfsCanFinish(int numCourses, int[][] prerequisites) {
        int[][] matrix = new int[numCourses][numCourses]; // i -> j
        int[] indegree = new int[numCourses];

        for (int[] prerequisite : prerequisites) {
            int ready = prerequisite[0];
            int pre = prerequisite[1];
            if (matrix[pre][ready] == 0)
                indegree[ready]++; //duplicate case
            matrix[pre][ready] = 1;
        }

        int count = 0;
        Queue<Integer> queue = new LinkedList<>();
        for (int i=0; i<indegree.length; i++) {
            if (indegree[i] == 0) queue.offer(i);
        }
        while (!queue.isEmpty()) {
            int course = queue.poll();
            count++;
            for (int i=0; i<numCourses; i++) {
                if (matrix[course][i] != 0) {
                    if (--indegree[i] == 0)
                        queue.offer(i);
                }
            }
        }
        return count == numCourses;
    }
}
