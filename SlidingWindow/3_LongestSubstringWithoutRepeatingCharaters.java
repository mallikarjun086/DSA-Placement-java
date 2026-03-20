/*
Problem: LeetCode 3 - Longest Substring Without Repeating Characters
Pattern: Sliding Window
Difficulty: Medium

Approach:
- Use HashSet
- Expand and shrink window

Time Complexity: O(n)
Space Complexity: O(n)
*/

class Solution {
    public int lengthOfLongestSubstring(String s) {
        int left = 0;
        int maxLength = 0;
        HashSet<Character> charSet = new HashSet<>();

        for (int right = 0; right < s.length(); right++) {
            while (charSet.contains(s.charAt(right))) {
                charSet.remove(s.charAt(left));
                left++;
            }

            charSet.add(s.charAt(right));
            maxLength = Math.max(maxLength, right - left + 1);
        }

        return maxLength;       
    }
}
