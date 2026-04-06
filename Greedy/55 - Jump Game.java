/*
Problem: LeetCode 55 - Jump Game
Pattern: Greedy (Backward)
Difficulty: Medium

Approach:
- Start from last index as goal
- Move backwards and update goal if reachable
- If goal becomes 0 → return true

Time Complexity: O(n)
Space Complexity: O(1)
*/
class Solution {
    public boolean canJump(int[] nums) {
        int finalposition = nums.length-1;
        for(int idx=nums.length-2;idx>=0;idx--){
            if(idx+nums[idx]>=finalposition){
                finalposition=idx;
            }

        }
        return finalposition==0;
    }
}
