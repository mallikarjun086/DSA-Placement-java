/*
Problem: LeetCode 200 - Number of Islands
Pattern: Graph (DFS / BFS)
Difficulty: Medium

Approach:
- Treat grid as a graph where each cell is a node
- Traverse using DFS
- When a '1' is found, run DFS to mark the entire island as visited
- Increment count for each DFS call

Time Complexity: O(m × n)
Space Complexity: O(m × n)
*/
class Solution {

    public int numIslands(char[][] grid) {

        if (grid == null || grid.length == 0)
            return 0;

        int count = 0;

        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {

                if (grid[i][j] == '1') {
                    dfs(grid, i, j);
                    count++;
                }
            }
        }

        return count;
    }

    private void dfs(char[][] grid, int i, int j) {

        if (i < 0 || i >= grid.length ||
            j < 0 || j >= grid[0].length ||
            grid[i][j] == '0') {
            return;
        }

        // mark visited
        grid[i][j] = '0';

        dfs(grid, i + 1, j);
        dfs(grid, i - 1, j);
        dfs(grid, i, j + 1);
        dfs(grid, i, j - 1);
    }
}
