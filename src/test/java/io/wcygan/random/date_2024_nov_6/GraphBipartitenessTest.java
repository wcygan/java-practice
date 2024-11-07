package io.wcygan.random.date_2024_nov_6;

import org.junit.Test;
import static org.junit.Assert.*;

import java.util.ArrayList;
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

    @Test
    public void isBipartiteWithSingleNode() {
        List<List<Integer>> graph = Arrays.asList(
                Arrays.asList()
        );
        assertTrue(bipartiteness.isBipartite(graph));
    }

    @Test
    public void isBipartiteWithDisconnectedGraph() {
        List<List<Integer>> graph = Arrays.asList(
                Arrays.asList(1),
                Arrays.asList(0),
                Arrays.asList(3),
                Arrays.asList(2)
        );
        assertTrue(bipartiteness.isBipartite(graph));
    }

    @Test
    public void isBipartiteWithSelfLoop() {
        List<List<Integer>> graph = Arrays.asList(
                Arrays.asList(0)
        );
        assertFalse(bipartiteness.isBipartite(graph));
    }

    @Test
    public void isBipartiteWithEmptyGraph() {
        List<List<Integer>> graph = new ArrayList<>();
        assertTrue(bipartiteness.isBipartite(graph));
    }

    @Test
    public void isBipartiteWithLargeBipartiteGraph() {
        List<List<Integer>> graph = Arrays.asList(
                Arrays.asList(1, 3, 5),
                Arrays.asList(0, 2, 4),
                Arrays.asList(1, 3, 5),
                Arrays.asList(0, 2, 4),
                Arrays.asList(1, 3, 5),
                Arrays.asList(0, 2, 4)
        );
        assertTrue(bipartiteness.isBipartite(graph));
    }

    @Test
    public void isBipartiteWithLargeNonBipartiteGraph() {
        List<List<Integer>> graph = Arrays.asList(
                Arrays.asList(1, 2, 3),
                Arrays.asList(0, 2, 4),
                Arrays.asList(0, 1, 3, 5),
                Arrays.asList(0, 2, 4),
                Arrays.asList(1, 3, 5),
                Arrays.asList(2, 4)
        );
        assertFalse(bipartiteness.isBipartite(graph));
    }

    @Test
    public void isBipartiteWithTwoNodesConnected() {
        List<List<Integer>> graph = Arrays.asList(
                Arrays.asList(1),
                Arrays.asList(0)
        );
        assertTrue(bipartiteness.isBipartite(graph));
    }

    @Test
    public void isBipartiteWithThreeNodesInLine() {
        List<List<Integer>> graph = Arrays.asList(
                Arrays.asList(1),
                Arrays.asList(0, 2),
                Arrays.asList(1)
        );
        assertTrue(bipartiteness.isBipartite(graph));
    }

    @Test
    public void isBipartiteWithThreeNodesInTriangle() {
        List<List<Integer>> graph = Arrays.asList(
                Arrays.asList(1, 2),
                Arrays.asList(0, 2),
                Arrays.asList(0, 1)
        );
        assertFalse(bipartiteness.isBipartite(graph));
    }

    @Test
    public void isBipartiteWithFourNodesInSquare() {
        List<List<Integer>> graph = Arrays.asList(
                Arrays.asList(1, 3),
                Arrays.asList(0, 2),
                Arrays.asList(1, 3),
                Arrays.asList(0, 2)
        );
        assertTrue(bipartiteness.isBipartite(graph));
    }

    @Test
    public void isBipartiteWithFourNodesInLine() {
        List<List<Integer>> graph = Arrays.asList(
                Arrays.asList(1),
                Arrays.asList(0, 2),
                Arrays.asList(1, 3),
                Arrays.asList(2)
        );
        assertTrue(bipartiteness.isBipartite(graph));
    }

    @Test
    public void isBipartiteWithFourNodesInStar() {
        List<List<Integer>> graph = Arrays.asList(
                Arrays.asList(1, 2, 3),
                Arrays.asList(0),
                Arrays.asList(0),
                Arrays.asList(0)
        );
        assertTrue(bipartiteness.isBipartite(graph));
    }

    @Test
    public void isBipartiteWithFiveNodesInLine() {
        List<List<Integer>> graph = Arrays.asList(
                Arrays.asList(1),
                Arrays.asList(0, 2),
                Arrays.asList(1, 3),
                Arrays.asList(2, 4),
                Arrays.asList(3)
        );
        assertTrue(bipartiteness.isBipartite(graph));
    }

    @Test
    public void isBipartiteWithFiveNodesInStar() {
        List<List<Integer>> graph = Arrays.asList(
                Arrays.asList(1, 2, 3, 4),
                Arrays.asList(0),
                Arrays.asList(0),
                Arrays.asList(0),
                Arrays.asList(0)
        );
        assertTrue(bipartiteness.isBipartite(graph));
    }

    @Test
    public void isBipartiteWithFiveNodesInCycle() {
        List<List<Integer>> graph = Arrays.asList(
                Arrays.asList(1, 4),
                Arrays.asList(0, 2),
                Arrays.asList(1, 3),
                Arrays.asList(2, 4),
                Arrays.asList(0, 3)
        );
        assertFalse(bipartiteness.isBipartite(graph));
    }

    @Test
    public void isBipartiteWithSixNodesInCycle() {
        List<List<Integer>> graph = Arrays.asList(
                Arrays.asList(1, 5),
                Arrays.asList(0, 2),
                Arrays.asList(1, 3),
                Arrays.asList(2, 4),
                Arrays.asList(3, 5),
                Arrays.asList(0, 4)
        );
        assertTrue(bipartiteness.isBipartite(graph));
    }

    @Test
    public void isBipartiteWithSixNodesInCompleteBipartite() {
        List<List<Integer>> graph = Arrays.asList(
                Arrays.asList(3, 4, 5),
                Arrays.asList(3, 4, 5),
                Arrays.asList(3, 4, 5),
                Arrays.asList(0, 1, 2),
                Arrays.asList(0, 1, 2),
                Arrays.asList(0, 1, 2)
        );
        assertTrue(bipartiteness.isBipartite(graph));
    }

    @Test
    public void isBipartiteWithSevenNodesInLine() {
        List<List<Integer>> graph = Arrays.asList(
                Arrays.asList(1),
                Arrays.asList(0, 2),
                Arrays.asList(1, 3),
                Arrays.asList(2, 4),
                Arrays.asList(3, 5),
                Arrays.asList(4, 6),
                Arrays.asList(5)
        );
        assertTrue(bipartiteness.isBipartite(graph));
    }

    @Test
    public void isBipartiteWithSevenNodesInStar() {
        List<List<Integer>> graph = Arrays.asList(
                Arrays.asList(1, 2, 3, 4, 5, 6),
                Arrays.asList(0),
                Arrays.asList(0),
                Arrays.asList(0),
                Arrays.asList(0),
                Arrays.asList(0),
                Arrays.asList(0)
        );
        assertTrue(bipartiteness.isBipartite(graph));
    }

    @Test
    public void isBipartiteWithSevenNodesInCycle() {
        List<List<Integer>> graph = Arrays.asList(
                Arrays.asList(1, 6),
                Arrays.asList(0, 2),
                Arrays.asList(1, 3),
                Arrays.asList(2, 4),
                Arrays.asList(3, 5),
                Arrays.asList(4, 6),
                Arrays.asList(0, 5)
        );
        assertFalse(bipartiteness.isBipartite(graph));
    }

    @Test
    public void isBipartiteWithEightNodesInCycle() {
        List<List<Integer>> graph = Arrays.asList(
                Arrays.asList(1, 7),
                Arrays.asList(0, 2),
                Arrays.asList(1, 3),
                Arrays.asList(2, 4),
                Arrays.asList(3, 5),
                Arrays.asList(4, 6),
                Arrays.asList(5, 7),
                Arrays.asList(0, 6)
        );
        assertTrue(bipartiteness.isBipartite(graph));
    }

    @Test
    public void isBipartiteWithEightNodesInCompleteBipartite() {
        List<List<Integer>> graph = Arrays.asList(
                Arrays.asList(4, 5, 6, 7),
                Arrays.asList(4, 5, 6, 7),
                Arrays.asList(4, 5, 6, 7),
                Arrays.asList(4, 5, 6, 7),
                Arrays.asList(0, 1, 2, 3),
                Arrays.asList(0, 1, 2, 3),
                Arrays.asList(0, 1, 2, 3),
                Arrays.asList(0, 1, 2, 3)
        );
        assertTrue(bipartiteness.isBipartite(graph));
    }

    @Test
    public void isBipartiteWithNineNodesInLine() {
        List<List<Integer>> graph = Arrays.asList(
                Arrays.asList(1),
                Arrays.asList(0, 2),
                Arrays.asList(1, 3),
                Arrays.asList(2, 4),
                Arrays.asList(3, 5),
                Arrays.asList(4, 6),
                Arrays.asList(5, 7),
                Arrays.asList(6, 8),
                Arrays.asList(7)
        );
        assertTrue(bipartiteness.isBipartite(graph));
    }

    @Test
    public void isBipartiteWithNineNodesInStar() {
        List<List<Integer>> graph = Arrays.asList(
                Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8),
                Arrays.asList(0),
                Arrays.asList(0),
                Arrays.asList(0),
                Arrays.asList(0),
                Arrays.asList(0),
                Arrays.asList(0),
                Arrays.asList(0),
                Arrays.asList(0)
        );
        assertTrue(bipartiteness.isBipartite(graph));
    }

    @Test
    public void isBipartiteWithNineNodesInCycle() {
        List<List<Integer>> graph = Arrays.asList(
                Arrays.asList(1, 8),
                Arrays.asList(0, 2),
                Arrays.asList(1, 3),
                Arrays.asList(2, 4),
                Arrays.asList(3, 5),
                Arrays.asList(4, 6),
                Arrays.asList(5, 7),
                Arrays.asList(6, 8),
                Arrays.asList(0, 7)
        );
        assertFalse(bipartiteness.isBipartite(graph));
    }

    @Test
    public void isBipartiteWithTenNodesInCycle() {
        List<List<Integer>> graph = Arrays.asList(
                Arrays.asList(1, 9),
                Arrays.asList(0, 2),
                Arrays.asList(1, 3),
                Arrays.asList(2, 4),
                Arrays.asList(3, 5),
                Arrays.asList(4, 6),
                Arrays.asList(5, 7),
                Arrays.asList(6, 8),
                Arrays.asList(7, 9),
                Arrays.asList(0, 8)
        );
        assertTrue(bipartiteness.isBipartite(graph));
    }
}