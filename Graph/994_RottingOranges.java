/*
Problem: LeetCode 994 - Rotting Oranges
Pattern: Graph (BFS)
Difficulty: Medium

Approach:
- Use multi-source BFS starting from all rotten oranges
- Spread rot level by level (minute by minute)
- Count time until all fresh oranges become rotten

Time Complexity: O(m × n)
Space Complexity: O(m × n)
*/
class Solution {
    public int orangesRotting(int[][] grid) {

        int rows = grid.length;
        int cols = grid[0].length;

        Queue<int[]> queue = new LinkedList<>();
        int fresh = 0;

        // Step 1: Add all rotten oranges
        for(int i = 0; i < rows; i++){
            for(int j = 0; j < cols; j++){
                if(grid[i][j] == 2){
                    queue.offer(new int[]{i, j});
                }
                if(grid[i][j] == 1){
                    fresh++;
                }
            }
        }

        int time = 0;
        int[][] directions = {{1,0},{-1,0},{0,1},{0,-1}};

        // Step 2: BFS
        while(!queue.isEmpty() && fresh > 0){

            int size = queue.size();

            for(int i = 0; i < size; i++){

                int[] curr = queue.poll();

                for(int[] dir : directions){
                    int r = curr[0] + dir[0];
                    int c = curr[1] + dir[1];

                    if(r >= 0 && r < rows && c >= 0 && c < cols && grid[r][c] == 1){
                        grid[r][c] = 2;
                        queue.offer(new int[]{r, c});
                        fresh--;
                    }
                }
            }

            time++;
        }

        return fresh == 0 ? time : -1;
    }
}
