/*
Problem: LeetCode 167 - Two Sum II
Pattern: Two Pointers
Difficulty: Medium

Approach:
- Use left and right pointers
- Adjust based on sum

Time Complexity: O(n)
Space Complexity: O(1)
*/
class Solution {
    public int[] twoSum(int[] numbers, int target) {
        int left = 0;
        int right = numbers.length - 1;

        while (left < right) {
            int currentSum = numbers[left] + numbers[right];

            if (currentSum == target) {
                return new int[]{left + 1, right + 1}; // 1-based indexing
            } 
            else if (currentSum < target) {
                left++;
            } 
            else {
                right--;
            }
        }

        return new int[]{-1, -1};
    }
}
