/*
Problem: LeetCode 169 - Majority Element
Pattern: Boyer-Moore Voting
Difficulty: Easy

Approach:
- Track candidate and count
- Cancel out different elements

Time Complexity: O(n)
Space Complexity: O(1)
*/
class Solution {
    public int majorityElement(int[] nums) {
        int candidate = 0;
        int count = 0;

        for(int num : nums) {
            if(count == 0) {
                candidate = num;
            }

            if(num == candidate) {
                count++;
            } else {
                count--;
            }
        }

        return candidate;
    }
}
