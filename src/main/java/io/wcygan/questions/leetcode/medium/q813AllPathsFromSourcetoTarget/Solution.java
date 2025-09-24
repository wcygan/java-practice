package io.wcygan.questions.leetcode.medium.q813AllPathsFromSourcetoTarget;

import java.util.*;

/**
 * 813. All Paths From Source to Target
 *
 * Difficulty: Medium
 * URL: https://leetcode.com/problems/all-paths-from-source-to-target/
 *
 * Given a directed acyclic graph (DAG) of n nodes labeled from 0 to n - 1, find all possible paths from node 0 to node n - 1 and return them in any order.
 * The graph is given as follows: graph[i] is a list of all nodes you can visit from node i (i.e., there is a directed edge from node i to node graph[i][j]).
 * &nbsp;
 * Example 1:
 * Input: graph = [[1,2],[3],[3],[]]
 * Output: [[0,1,3],[0,2,3]]
 * Explanation: There are two paths: 0 -> 1 -> 3 and 0 -> 2 -> 3.
 * Example 2:
 * Input: graph = [[4,3,1],[3,2,4],[3],[4],[]]
 * Output: [[0,4],[0,3,4],[0,1,3,4],[0,1,2,3,4],[0,1,4]]
 * &nbsp;
 * Constraints:
 * n == graph.length
 * 2 <= n <= 15
 * 0 <= graph[i][j] < n
 * graph[i][j] != i (i.e., there will be no self-loops).
 * All the elements of graph[i] are unique.
 * The input graph is guaranteed to be a DAG.
 */
class Solution {
    List<List<Integer>> answer;
    public List<List<Integer>> allPathsSourceTarget(int[][] graph) {
        answer = new ArrayList<>();
        List<Integer> path = new ArrayList<>();
        Set<Integer> membersOfPath = new HashSet<>();
        path.add(0);
        membersOfPath.add(0);

        backtrack(path, membersOfPath, graph, 0);
        return answer;
    }

    void backtrack(
            List<Integer> path,
            Set<Integer> membersOfPath,
            int[][] graph,
            int current
    ) {
        if (current == graph.length) return;
        if (current == graph.length - 1) {
            answer.add(new ArrayList<>(path));
        }

        int[] edges = graph[current];
        for (int next : edges) {
            path.add(next);
            membersOfPath.add(next);
            backtrack(path, membersOfPath, graph, next);
            path.remove(path.size() - 1);
            membersOfPath.remove(next);
        }
    }
}
