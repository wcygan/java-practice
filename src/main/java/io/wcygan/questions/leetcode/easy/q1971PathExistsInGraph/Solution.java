package io.wcygan.questions.leetcode.easy.q1971PathExistsInGraph;

import java.util.*;

public class Solution {
    public boolean validPath(int n, int[][] edges, int source, int destination) {
        if (source == destination) {
            return true;
        }

        Map<Integer, Set<Integer>> graph = new HashMap<>();
        for (int[] edge : edges) {
            int from = edge[0];
            int to = edge[1];
            graph.computeIfAbsent(from, s -> new HashSet<>()).add(to);
            graph.computeIfAbsent(to, d -> new HashSet<>()).add(from);
        }


        // See if there is a path from the source to the destination
        // So, we must:
        //      - Explore every path
        //      - Start at the source
        //      - Search all neighbors, continue down their paths

        Set<Integer> visited = new HashSet<>();
        Queue<Integer> next = new ArrayDeque<>();
        next.add(source);
        visited.add(source);

        while (!next.isEmpty()) {
            int current = next.remove();

            Set<Integer> neighbors = graph.getOrDefault(current, Collections.emptySet());

            for (int neighbor : neighbors) {
                if (neighbor == destination) {
                    return true;
                }

                if (!visited.contains(neighbor)) {
                    next.add(neighbor);
                    visited.add(neighbor);
                }
            }

        }

        return false;
    }
}