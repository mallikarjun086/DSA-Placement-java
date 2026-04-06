/*
Problem: LeetCode 64 - Minimum Path Sum
Pattern: Dynamic Programming (Grid)
Difficulty: Medium

Approach:
- Use in-place DP
- Each cell = min(top, left) + current

Time Complexity: O(m * n)
Space Complexity: O(1)
*/
class Solution {
    public int minPathSum(int[][] grid) {
        int row = grid.length;
        int col = grid[0].length;

        // first row
        for(int i = 1;i<col;i++){
            grid[0][i] += grid[0][i-1];
        }
        // first column
        for(int j = 1;j<row;j++){
            grid[j][0] += grid[j-1][0];
        }
        for(int i = 1;i<row;i++){
            for(int j = 1;j<col;j++){
                grid[i][j] += Math.min(grid[i-1][j],grid[i][j-1]);
            }
        }
        return grid[row-1][col-1];
    }
}
