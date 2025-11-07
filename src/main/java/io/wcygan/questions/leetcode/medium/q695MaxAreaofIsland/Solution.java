package io.wcygan.questions.leetcode.medium.q695MaxAreaofIsland;

import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

/**
 * 695. Max Area of Island
 *
 * Difficulty: Medium
 * URL: https://leetcode.com/problems/max-area-of-island/
 *
 * You are given an m x n binary matrix grid. An island is a group of 1's (representing land) connected 4-directionally (horizontal or vertical.) You may assume all four edges of the grid are surrounded by water.
 * The area of an island is the number of cells with a value 1 in the island.
 * Return the maximum area of an island in grid. If there is no island, return 0.
 * &nbsp;
 * Example 1:
 * Input: grid = [[0,0,1,0,0,0,0,1,0,0,0,0,0],[0,0,0,0,0,0,0,1,1,1,0,0,0],[0,1,1,0,1,0,0,0,0,0,0,0,0],[0,1,0,0,1,1,0,0,1,0,1,0,0],[0,1,0,0,1,1,0,0,1,1,1,0,0],[0,0,0,0,0,0,0,0,0,0,1,0,0],[0,0,0,0,0,0,0,1,1,1,0,0,0],[0,0,0,0,0,0,0,1,1,0,0,0,0]]
 * Output: 6
 * Explanation: The answer is not 11, because the island must be connected 4-directionally.
 * Example 2:
 * Input: grid = [[0,0,0,0,0,0,0,0]]
 * Output: 0
 * &nbsp;
 * Constraints:
 * m == grid.length
 * n == grid[i].length
 * 1 <= m, n <= 50
 * grid[i][j] is either 0 or 1.
 */
class Solution {

    // Requirements:
    //  - Find the maximum area of ANY ISLAND
    //  - There may be multiple islands
    //  - If there are no islands, return 0

    // Possible approach
    //  - Iterate over grid
    //  - When you reach an island, BFS it, keeping track of islands size
    //  - If the island size is greater than the maximum, record it as a possible answer
    //  - During the graph traversal, keep track of nodes that you've visited so you don't over-shoot the answer
    //  - Need to search the entire grid; can't assume any one answer is the peak answer

    class Point {
        int i;
        int j;

        public Point(int i, int j) {
            this.i = i;
            this.j = j;
        }

        @Override
        public boolean equals(Object o) {
            if (o == null || getClass() != o.getClass()) return false;
            Point point = (Point) o;
            return i == point.i && j == point.j;
        }

        @Override
        public int hashCode() {
            return Objects.hash(i, j);
        }
    }

    public int maxAreaOfIsland(int[][] grid) {
        int answer = 0;
        Set<Point> visited = new HashSet<>();

        // Iterate over the entire grid, searching for land.
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (land(grid, i, j)) {
                    // Once we reach land, determine the island size.
                    int size = search(grid, i, j, visited);

                    // Finally, see if this is the largest island so far.
                    answer = Math.max(answer, size);
                }
            }
        }

        return answer;
    }

    // Check if we are currently on land
    boolean land(int[][] grid, int i, int j) {
        return grid[i][j] == 1;
    }

    // DFS the remainder of the current island, finding its size
    // Check up/down/left/right
    int search(int[][] grid, int i, int j, Set<Point> visited) {
        Point current = new Point(i, j);
        if (visited.contains(current)) {
            return 0;
        }

        if (outOfBounds(grid, i, j)) {
            return 0;
        }

        if (!land(grid, i, j)) {
            return 0;
        }

        visited.add(current);

        int size = 1;
        size += search(grid, i + 1, j, visited);
        size += search(grid, i - 1, j, visited);
        size += search(grid, i, j + 1, visited);
        size += search(grid, i, j - 1, visited);
        return size;
    }

    // Check if we're outside the map
    boolean outOfBounds(int[][] grid, int i, int j) {
        return i < 0 || j < 0 || i >= grid.length || j >= grid[0].length;
    }
}
