package io.wcygan.questions.leetcode.medium.q785isBipartite;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class SolutionTest {

    @Test
    public void testBipartiteGraph() {
        Solution solution = new Solution();
        int[][] graph = {{1, 3}, {0, 2}, {1, 3}, {0, 2}};
        Assertions.assertTrue(solution.isBipartite(graph));
    }

    @Test
    public void testNonBipartiteGraph() {
        Solution solution = new Solution();
        int[][] graph = {{1, 2, 3}, {0, 2}, {0, 1, 3}, {0, 2}};
        Assertions.assertFalse(solution.isBipartite(graph));
    }

    @Test
    public void testSingleNodeGraph() {
        Solution solution = new Solution();
        int[][] graph = {{}};
        Assertions.assertTrue(solution.isBipartite(graph));
    }

    @Test
    public void testDisconnectedGraph() {
        Solution solution = new Solution();
        int[][] graph = {{1}, {0}, {3}, {2}};
        Assertions.assertTrue(solution.isBipartite(graph));
    }

    @Test
    public void testEmptyGraph() {
        Solution solution = new Solution();
        int[][] graph = {};
        Assertions.assertTrue(solution.isBipartite(graph));
    }

    @Test
    public void testNonBipartiteGraphWithOddCycle() {
        Solution solution = new Solution();
        int[][] graph = {{1, 2}, {0, 2}, {0, 1}};
        Assertions.assertFalse(solution.isBipartite(graph));
    }

    @Test
    public void testNonBipartiteGraphWithSelfLoop() {
        Solution solution = new Solution();
        int[][] graph = {{1, 2}, {0, 2}, {0, 1, 2}};
        Assertions.assertFalse(solution.isBipartite(graph));
    }

    @Test
    public void testNonBipartiteGraphWithComplexStructure() {
        Solution solution = new Solution();
        int[][] graph = {{1, 2, 3}, {0, 2, 4}, {0, 1, 3}, {0, 2, 4}, {1, 3}};
        Assertions.assertFalse(solution.isBipartite(graph));
    }


    @Test
    public void testBipartiteGraph1() {
        Solution solution = new Solution();
        int[][] graph = {{1}, {0, 2}, {1, 3}, {2}};
        Assertions.assertTrue(solution.isBipartite(graph));
    }

    @Test
    public void testBipartiteGraph2() {
        Solution solution = new Solution();
        int[][] graph = {{1, 2}, {0, 3}, {0, 3}, {1, 2}};
        Assertions.assertTrue(solution.isBipartite(graph));
    }

    @Test
    public void testBipartiteGraph3() {
        Solution solution = new Solution();
        int[][] graph = {{1, 4}, {0, 2, 3}, {1, 3}, {1, 2, 4}, {0, 3}};
        Assertions.assertFalse(solution.isBipartite(graph));
    }

    @Test
    public void testBipartiteGraph4() {
        Solution solution = new Solution();
        int[][] graph = {{1, 3, 5}, {0, 2, 4}, {1, 3, 5}, {0, 2, 4}, {1, 3, 5}, {0, 2, 4}};
        Assertions.assertTrue(solution.isBipartite(graph));
    }

    @Test
    public void testBipartiteGraph5() {
        Solution solution = new Solution();
        int[][] graph = {{1, 2, 3}, {0, 4}, {0, 4}, {0, 4}, {1, 2, 3}};
        Assertions.assertTrue(solution.isBipartite(graph));
    }

    @Test
    public void testNonBipartiteGraph1() {
        Solution solution = new Solution();
        int[][] graph = {{1, 2}, {0, 2}, {0, 1, 3}, {2}};
        Assertions.assertFalse(solution.isBipartite(graph));
    }

    @Test
    public void testNonBipartiteGraph2() {
        Solution solution = new Solution();
        int[][] graph = {{1, 2, 3}, {0, 2, 3}, {0, 1, 3}, {0, 1, 2}};
        Assertions.assertFalse(solution.isBipartite(graph));
    }

    @Test
    public void testNonBipartiteGraph3() {
        Solution solution = new Solution();
        int[][] graph = {{1, 2, 3}, {0, 2, 4}, {0, 1, 3}, {0, 2, 4}, {1, 3}};
        Assertions.assertFalse(solution.isBipartite(graph));
    }

    @Test
    public void testNonBipartiteGraph4() {
        Solution solution = new Solution();
        int[][] graph = {{1, 2, 3}, {0, 2, 3}, {0, 1, 3}, {0, 1, 2, 4}, {3}};
        Assertions.assertFalse(solution.isBipartite(graph));
    }

    @Test
    public void testNonBipartiteGraph5() {
        Solution solution = new Solution();
        int[][] graph = {{1, 2, 3}, {0, 2, 3}, {0, 1, 3, 4}, {0, 1, 2, 4}, {2, 3}};
        Assertions.assertFalse(solution.isBipartite(graph));
    }

    @Test
    public void testBipartiteGraph6() {
        Solution solution = new Solution();
        int[][] graph = {{1, 3}, {0, 2, 4}, {1, 3}, {0, 2, 4}, {1, 3}};
        Assertions.assertTrue(solution.isBipartite(graph));
    }

    @Test
    public void testBipartiteGraph7() {
        Solution solution = new Solution();
        int[][] graph = {{1, 4}, {0, 2, 3}, {1, 3}, {1, 2, 4}, {0, 3}};
        Assertions.assertFalse(solution.isBipartite(graph));
    }

    @Test
    public void testBipartiteGraph8() {
        Solution solution = new Solution();
        int[][] graph = {{1, 3}, {0, 2, 4}, {1, 3}, {0, 2, 4}, {1, 3}};
        Assertions.assertTrue(solution.isBipartite(graph));
    }

    @Test
    public void testBipartiteGraph9() {
        Solution solution = new Solution();
        int[][] graph = {{1, 2, 3}, {0, 4}, {0, 4}, {0, 4}, {1, 2, 3}};
        Assertions.assertTrue(solution.isBipartite(graph));
    }

    @Test
    public void testBipartiteGraph10() {
        Solution solution = new Solution();
        int[][] graph = {{1, 3, 5}, {0, 2, 4}, {1, 3, 5}, {0, 2, 4}, {1, 3, 5}, {0, 2, 4}};
        Assertions.assertTrue(solution.isBipartite(graph));
    }

    @Test
    public void testNonBipartiteGraph6() {
        Solution solution = new Solution();
        int[][] graph = {{1, 2, 3}, {0, 2, 3}, {0, 1, 3}, {0, 1, 2}};
        Assertions.assertFalse(solution.isBipartite(graph));
    }

    @Test
    public void testNonBipartiteGraph7() {
        Solution solution = new Solution();
        int[][] graph = {{1, 2, 3}, {0, 2, 3}, {0, 1, 3, 4}, {0, 1, 2, 4}, {2, 3}};
        Assertions.assertFalse(solution.isBipartite(graph));
    }

    @Test
    public void testNonBipartiteGraph8() {
        Solution solution = new Solution();
        int[][] graph = {{1, 2, 3}, {0, 2, 3}, {0, 1, 3}, {0, 2, 4}, {3}};
        Assertions.assertFalse(solution.isBipartite(graph));
    }

    @Test
    public void testNonBipartiteGraph9() {
        Solution solution = new Solution();
        int[][] graph = {{1, 2, 3}, {0, 2, 3}, {0, 1, 3}, {0, 1, 2, 4}, {3}};
        Assertions.assertFalse(solution.isBipartite(graph));
    }

    @Test
    public void testNonBipartiteGraph10() {
        Solution solution = new Solution();
        int[][] graph = {{1, 2, 3}, {0, 2, 3}, {0, 1, 3}, {0, 1, 2}};
        Assertions.assertFalse(solution.isBipartite(graph));
    }

    @Test
    public void testNonBipartiteGraph11() {
        Solution solution = new Solution();
        int[][] graph = {{4}, {}, {4}, {4}, {0, 2, 3}};
        Assertions.assertTrue(solution.isBipartite(graph));
    }

    @Test
    public void testBipartiteGraphComplex() {
        Solution solution = new Solution();
        int[][] graph = {
                {},                // Vertex 0
                {2, 4, 6},         // Vertex 1
                {1, 4, 8, 9},      // Vertex 2
                {7, 8},            // Vertex 3
                {1, 2, 8, 9},      // Vertex 4
                {6, 9},            // Vertex 5
                {1, 5, 7, 8, 9},   // Vertex 6
                {3, 6, 9},         // Vertex 7
                {2, 3, 4, 6, 9},   // Vertex 8
                {2, 4, 5, 6, 7, 8} // Vertex 9
        };
        Assertions.assertFalse(solution.isBipartite(graph), "The graph should not be bipartite.");
    }
}