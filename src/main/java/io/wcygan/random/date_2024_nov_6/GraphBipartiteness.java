package io.wcygan.random.date_2024_nov_6;

import java.util.*;

public class GraphBipartiteness {
    enum Color {
        Red,
        Blue
    }

    /**
     * Determines if the given graph is bipartite.
     *
     * @param graph The adjacency list of the graph.
     * @return True if the graph is bipartite, otherwise false.
     */
    public boolean isBipartite(List<List<Integer>> graph) {
        Map<Integer, Color> colors = new HashMap<>();
        Queue<Integer> next = new ArrayDeque<>();

        for (int i = 0; i < graph.size(); i++) {
            if (!colors.containsKey(i)) {
                next.add(i);
                colors.put(i, Color.Red);
            }

            while (!next.isEmpty()) {
                Integer node = next.remove();
                Color opposite = (Color.Blue == colors.get(node)) ? Color.Red : Color.Blue;
                List<Integer> neighbors = graph.get(node);

                for (Integer neighbor : neighbors) {
                    if (!colors.containsKey(neighbor)) {
                        next.add(neighbor);
                        colors.put(neighbor, opposite);
                    }

                    if (colors.get(neighbor) != opposite) {
                        return false;
                    }
                }
            }
        }

        return true;
    }
}