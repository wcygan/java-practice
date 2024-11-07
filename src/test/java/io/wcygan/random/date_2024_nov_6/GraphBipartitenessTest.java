package io.wcygan.random.date_2024_nov_6;

import org.junit.Test;
import static org.junit.Assert.*;
import java.util.Arrays;
import java.util.List;

public class GraphBipartitenessTest {
    private GraphBipartiteness bipartiteness = new GraphBipartiteness();

    @Test
    public void testIsBipartite() {
        List<List<Integer>> graph1 = Arrays.asList(
                Arrays.asList(1, 3),
                Arrays.asList(0, 2),
                Arrays.asList(1, 3),
                Arrays.asList(0, 2)
        );
        assertTrue(bipartiteness.isBipartite(graph1));

        List<List<Integer>> graph2 = Arrays.asList(
                Arrays.asList(1, 2, 3),
                Arrays.asList(0, 2),
                Arrays.asList(0, 1, 3),
                Arrays.asList(0, 2)
        );
        assertFalse(bipartiteness.isBipartite(graph2));

        List<List<Integer>> graph3 = Arrays.asList();
        assertTrue(bipartiteness.isBipartite(graph3));

        List<List<Integer>> graph4 = Arrays.asList(
                Arrays.asList(1),
                Arrays.asList(0, 3),
                Arrays.asList(3),
                Arrays.asList(1, 2)
        );
        assertTrue(bipartiteness.isBipartite(graph4));
    }
}