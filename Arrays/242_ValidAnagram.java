/*
Problem: LeetCode 242 - Valid Anagram
Pattern: Arrays / Hashing
Difficulty: Easy

Approach:
- Use frequency array or hashmap
- Compare counts of characters

Time Complexity: O(n)
Space Complexity: O(1)
*/

public class Solution {
    public boolean isAnagram(String s, String t) {
        if (s.length() != t.length()) {
            return false;
        }

        char[] sSort = s.toCharArray();
        char[] tSort = t.toCharArray();
        Arrays.sort(sSort);
        Arrays.sort(tSort);
        return Arrays.equals(sSort, tSort);
    }
}
