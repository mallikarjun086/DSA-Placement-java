/*
Problem: LeetCode 1 - Two Sum
Pattern: Arrays / Hashing
Difficulty: Easy

Approach:
- Use HashMap to store elements
- Check complement

Time Complexity: O(n)
Space Complexity: O(n)
*/
class Solution {
    public int[] twoSum(int[] nums, int target) {
        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                if (nums[i] + nums[j] == target) {
                    return new int[]{i, j};
                }
            }
        }
        return new int[0];
    }
}
