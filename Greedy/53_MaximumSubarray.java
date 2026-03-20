/*
Problem: LeetCode 53 - Maximum Subarray
Pattern: Kadane’s Algorithm
Difficulty: Medium

Approach:
- Maintain running sum
- Reset when negative

Time Complexity: O(n)
Space Complexity: O(1)
*/
class Solution {
    public int maxSubArray(int[] nums) {
        int currentSum = nums[0];
        int maxSum = nums[0];

        for(int i = 1; i < nums.length; i++) {
            currentSum = Math.max(nums[i], currentSum + nums[i]);
            maxSum = Math.max(maxSum, currentSum);
        }

        return maxSum;
    }
}
