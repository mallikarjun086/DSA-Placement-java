/*
Problem: LeetCode 213 - House Robber II
Pattern: Dynamic Programming
Difficulty: Medium

Approach:
- Houses are arranged in a circular manner → first and last cannot be robbed together
- Break into two cases:
    1. Rob houses from index 0 to n-2
    2. Rob houses from index 1 to n-1
- Apply House Robber I logic on both cases
- Return the maximum of both results

Time Complexity: O(n)
Space Complexity: O(1)
*/
class Solution {
    public int rob(int[] nums) {
        if(nums.length < 2) return nums[0];

        int [] skipLastHouse = new int[nums.length - 1];
        int [] skipFirstHouse = new int[nums.length - 1];

        for(int i = 0; i<nums.length-1;i++){
            skipLastHouse[i] =nums[i];
            skipFirstHouse[i] = nums[i+1];
        }
        int lootSkippingLast = robHelper(skipLastHouse);
        int lootSkippingFirst = robHelper(skipFirstHouse);

        return Math.max(lootSkippingLast,lootSkippingFirst);
    }
    public int robHelper(int[] nums) {
        if(nums.length<2) return nums[0];

        int[] dp = new int[nums.length];

        dp[0] = nums[0];
        dp[1] = Math.max(nums[0],nums[1]);

        for(int i = 2;i<nums.length;i++){
            //core logic
            dp[i] = Math.max(dp[i-2]+nums[i],dp[i-1]);
        }
        return dp[nums.length-1];
    }

}
