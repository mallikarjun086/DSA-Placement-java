/*
Problem: LeetCode 45 - Jump Game II
Pattern: Greedy (Level-based traversal)
Difficulty: Medium

Approach:
- Track current jump range (currentEnd)
- Track farthest reachable index
- When reaching currentEnd → increment jumps

Time Complexity: O(n)
Space Complexity: O(1)
*/
class Solution {
    public int jump(int[] nums) {

        int jumps = 0;
        int currentEnd = 0;
        int farthest = 0;

        for(int i = 0; i < nums.length - 1; i++){

            farthest = Math.max(farthest, i + nums[i]);

            if(i == currentEnd){
                jumps++;
                currentEnd = farthest;
            }
        }

        return jumps;
    }
}
