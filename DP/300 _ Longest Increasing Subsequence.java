/*
Problem: LeetCode 300 - Longest Increasing Subsequence
Pattern: Dynamic Programming
Difficulty: Medium

Approach:
- dp[i] represents the length of LIS ending at index i
- Initialize all dp[i] = 1 (each element is LIS of length 1)
- For each element, check all previous elements:
    if nums[j] < nums[i]:
        dp[i] = max(dp[i], dp[j] + 1)
- Final answer = maximum value in dp array

Time Complexity: O(n^2)
Space Complexity: O(n)
*/
class Solution {
    public int lengthOfLIS(int[] nums) {
        int[] T = new int[nums.length];
        for(int i = 1; i < nums.length; i++)
            for(int j = 0; j < i;j++)
                if(nums[i] > nums[j])
                    if(T[j] + 1 > T[i])
                        T[i] = T[j] + 1;

        int maxIndex = 0;
        for(int i = 0; i < T.length;i++)
            if(T[i] > T[maxIndex])
                maxIndex = i;
        return T[maxIndex] + 1;
    }    
}
