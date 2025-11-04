package io.wcygan.questions.leetcode.medium.q200NumberofIslands;
/**
 * 200. Number of Islands
 *
 * Difficulty: Medium
 * URL: https://leetcode.com/problems/number-of-islands/
 *
 * Given an m x n 2D binary grid grid which represents a map of '1's (land) and '0's (water), return the number of islands.
 * An island is surrounded by water and is formed by connecting adjacent lands horizontally or vertically. You may assume all four edges of the grid are all surrounded by water.
 * &nbsp;
 * Example 1:
 * Input: grid = [
 * ["1","1","1","1","0"],
 * ["1","1","0","1","0"],
 * ["1","1","0","0","0"],
 * ["0","0","0","0","0"]
 * ]
 * Output: 1
 * Example 2:
 * Input: grid = [
 * ["1","1","0","0","0"],
 * ["1","1","0","0","0"],
 * ["0","0","1","0","0"],
 * ["0","0","0","1","1"]
 * ]
 * Output: 3
 * &nbsp;
 * Constraints:
 * m == grid.length
 * n == grid[i].length
 * 1 <= m, n <= 300
 * grid[i][j] is '0' or '1'.
 */
class Solution {
    public int numIslands(char[][] grid) {
        int rows = grid.length;
        int cols = grid[0].length;
        int count = 0;

        for (int r = 0; r < rows; r++) {
            for (int c = 0; c < cols; c++) {
                if (grid[r][c] == '1') {
                    dfs(r, c, grid, rows, cols);
                    count++;
                }
            }
        }

        return count;
    }

    void dfs(int r, int c, char[][] grid, int rows, int cols) {
        // boundary or already visited
        if (r < 0 || c < 0 || r >= rows || c >= cols || grid[r][c] == '0') {
            return;
        }

        // mark visited
        grid[r][c] = '0';

        // explore all four directions
        dfs(r + 1, c, grid, rows, cols);
        dfs(r - 1, c, grid, rows, cols);
        dfs(r, c + 1, grid, rows, cols);
        dfs(r, c - 1, grid, rows, cols);
    }
}

