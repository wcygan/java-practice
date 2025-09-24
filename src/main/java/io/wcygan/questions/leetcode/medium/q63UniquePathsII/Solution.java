package io.wcygan.questions.leetcode.medium.q63UniquePathsII;

import java.util.Arrays;

/**
 * 63. Unique Paths II
 *
 * Difficulty: Medium
 * URL: https://leetcode.com/problems/unique-paths-ii/
 *
 * You are given an m x n integer array grid. There is a robot initially located at the top-left corner (i.e., grid[0][0]). The robot tries to move to the bottom-right corner (i.e., grid[m - 1][n - 1]). The robot can only move either down or right at any point in time.
 * An obstacle and space are marked as 1 or 0 respectively in grid. A path that the robot takes cannot include any square that is an obstacle.
 * Return the number of possible unique paths that the robot can take to reach the bottom-right corner.
 * The testcases are generated so that the answer will be less than or equal to 2 * 109.
 * &nbsp;
 * Example 1:
 * Input: obstacleGrid = [[0,0,0],[0,1,0],[0,0,0]]
 * Output: 2
 * Explanation: There is one obstacle in the middle of the 3x3 grid above.
 * There are two ways to reach the bottom-right corner:
 * 1. Right -> Right -> Down -> Down
 * 2. Down -> Down -> Right -> Right
 * Example 2:
 * Input: obstacleGrid = [[0,1],[0,0]]
 * Output: 1
 * &nbsp;
 * Constraints:
 * m == obstacleGrid.length
 * n == obstacleGrid[i].length
 * 1 <= m, n <= 100
 * obstacleGrid[i][j] is 0 or 1.
 */
class Solution {
    int[][] obstacleGrid;
    int[][] memo;
    int m;
    int n;

    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        this.obstacleGrid = obstacleGrid;
        m = obstacleGrid.length;
        n = obstacleGrid[0].length;
        memo = new int[m][n];
        for (int[] row : memo) Arrays.fill(row, -1);
        return backtrack(0, 0);
    }

    int backtrack(
            int x,
            int y
    ) {
        if (x >= m|| y >= n) {
            // we went off of the course
            return 0;
        }

        if (obstacleGrid[x][y] == 1) {
            // blocked by an obstacle
            return 0;
        }

        if (x == m - 1 && y == n - 1) {
            // we found a solution
            return 1;
        }

        if (memo[x][y] != -1) return memo[x][y];

        return memo[x][y] = backtrack(x + 1, y) + backtrack(x, y + 1);
    }
}
