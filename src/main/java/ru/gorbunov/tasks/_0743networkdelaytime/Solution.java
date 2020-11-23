package ru.gorbunov.tasks._0743networkdelaytime;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Set;

/**
 * Network Delay Time
 * <p>
 * There are N network nodes, labelled 1 to N.
 * Given times, a list of travel times as directed edges times[i] = (u, v, w), where u is the source node, v is the
 * target node, and w is the time it takes for a signal to travel from source to target. Now, we send a signal from
 * a certain node K. How long will it take for all nodes to receive the signal? If it is impossible, return -1.
 * Example 1:
 * Input: times = [[2,1,1],[2,3,1],[3,4,1]], N = 4, K = 2
 * Output: 2
 * Note:
 * N will be in the range [1, 100].
 * K will be in the range [1, N].
 * The length of times will be in the range [1, 6000].
 * All edges times[i] = (u, v, w) will have 1 <= u, v <= N and 0 <= w <= 100.
 */
public class Solution {

    /**
     * Dijkstra's Algorithm
     */
    public int networkDelayTime(int[][] times, int n, int k) {
        Map<Integer, List<Edge>> network = new HashMap<>();
        for (int[] time : times) {
            network.computeIfAbsent(time[0], key -> new ArrayList<>()).add(new Edge(time));
        }
        Map<Integer, Integer> path = new HashMap<>();
        for (int i = 1; i <= n; i++) {
            path.put(i, Integer.MAX_VALUE);
        }
        path.put(k, 0);
        Set<Integer> visited = new HashSet<>();
        Set<Integer> vertexes = new HashSet<>(path.keySet());

        while (!vertexes.isEmpty()) {
            int currentVertex = getNext(vertexes, path);
            vertexes.remove(currentVertex);

            if (!visited.contains(currentVertex)) {
                final Integer currentPath = path.get(currentVertex);
                for (Edge edge : network.getOrDefault(currentVertex, Collections.emptyList())) {
                    final Integer targetPath = path.get(edge.to);
                    path.put(edge.to, Math.min(currentPath + edge.weight, targetPath));
                }
                visited.add(currentVertex);
            }
        }
        return path.values().stream()
                .max(Integer::compareTo)
                .filter(maxPath -> maxPath < Integer.MAX_VALUE)
                .orElse(-1);
    }

    private Integer getNext(Set<Integer> vertexes, Map<Integer, Integer> paths) {
        Integer minPath = Integer.MAX_VALUE;
        Integer value = -1;
        for (Integer vertex : vertexes) {
            final Integer current = paths.get(vertex);
            if (current <= minPath) {
                minPath = current;
                value = vertex;
            }
        }
        return value;
    }

    private static class Edge {
        int from;
        int to;
        int weight;

        Edge(int[] arr) {
            from = arr[0];
            to = arr[1];
            weight = arr[2];
        }
    }

    /**
     * Via heap
     */
    public int fastNetworkDelayTime(int[][] times, int N, int K) {
        Map<Integer, List<int[]>> graph = new HashMap<>();
        for (int[] edge : times) {
            if (!graph.containsKey(edge[0]))
                graph.put(edge[0], new ArrayList<>());
            graph.get(edge[0]).add(new int[]{edge[1], edge[2]});
        }
        PriorityQueue<int[]> heap = new PriorityQueue<>(
                Comparator.comparingInt(info -> info[0]));
        heap.offer(new int[]{0, K});

        Map<Integer, Integer> dist = new HashMap<>();

        while (!heap.isEmpty()) {
            int[] info = heap.poll();
            int d = info[0], node = info[1];
            if (dist.containsKey(node)) continue;
            dist.put(node, d);
            if (graph.containsKey(node))
                for (int[] edge : graph.get(node)) {
                    int nei = edge[0], d2 = edge[1];
                    if (!dist.containsKey(nei))
                        heap.offer(new int[]{d + d2, nei});
                }
        }

        if (dist.size() != N) return -1;
        int ans = 0;
        for (int cand : dist.values())
            ans = Math.max(ans, cand);
        return ans;
    }
}
