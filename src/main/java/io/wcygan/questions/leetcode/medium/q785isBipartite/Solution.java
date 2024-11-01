package io.wcygan.questions.leetcode.medium.q785isBipartite;

// There is an undirected graph with n nodes, where each node is numbered between 0 and n - 1.
// You are given a 2D array graph, where graph[u] is an array of nodes that node u is adjacent to.
// More formally, for each v in graph[u], there is an undirected edge between node u and node v. The graph has the following properties:
//
// There are no self-edges (graph[u] does not contain u).
// There are no parallel edges (graph[u] does not contain duplicate values).
// If v is in graph[u], then u is in graph[v] (the graph is undirected).
// The graph may not be connected, meaning there may be two nodes u and v such that there is no path between them.
// A graph is bipartite if the nodes can be partitioned into two independent sets A and B such that every edge in the graph connects a node in set A and a node in set B.
//
//        Return true if and only if it is bipartite.
//
//  Constraints:
//
//    graph.length == n
//    1 <= n <= 100
//    0 <= graph[u].length < n
//    0 <= graph[u][i] <= n - 1
//    graph[u] does not contain u.
//    All the values of graph[u] are unique.
//    If graph[u] contains v, then graph[v] contains u.
import java.util.ArrayDeque;
import java.util.HashMap;
import java.util.Map;
import java.util.Queue;

public class Solution {
    enum Color {
        Red,
        Blue
    }

    // Time:   O(V + E)   --> iterating over all edges & vertices
    // Space:  O(V)       --> assigning colors into a map
    public boolean isBipartite(int[][] graph) {
        if (graph.length == 0) return true;

        Queue<Integer> queue = new ArrayDeque<>();
        Map<Integer, Color> colors = new HashMap<>();

        // Make sure to iterate over the entire graph. We may have disconnected graphs...
        for (int node = 0; node < graph.length; node++) {
            if (!colors.containsKey(node)) {
                // Initialize BFS for a new sub-graph
                colors.put(node, Color.Red);
                queue.add(node);
            }

            // Run BFS on this graph
            while (!queue.isEmpty()) {
                int next = queue.remove();
                Color opposite = opposite(colors.get(next));

                // Check the neighbors of this vertex
                int[] neighbors = graph[next];
                for (int neighbor : neighbors) {
                    if (!colors.containsKey(neighbor)) {
                        // If the neighbor hasn't been colored, give them the opposite color
                        colors.put(neighbor, opposite);
                        queue.add(neighbor);
                        continue;
                    }

                    if (colors.containsKey(neighbor) && colors.get(neighbor) != opposite) {
                        // Early return: this graph is not bipartite
                        return false;
                    }
                }
            }
        }

        return true;
    }

    Color opposite(Color color) {
        return (color == Color.Red) ? Color.Blue : Color.Red;
    }
}
