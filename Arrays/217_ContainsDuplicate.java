/*
Problem: LeetCode 217 - Contains Duplicate
Pattern: Arrays / Hashing
Difficulty: Easy

Approach:
- Use HashSet to track seen elements
- If duplicate found → return true

Time Complexity: O(n)
Space Complexity: O(n)
*/
import java.util.*;

class Solution {
    public boolean containsDuplicate(int[] nums) {
        HashSet<Integer> set = new HashSet<>();

        for(int num : nums) {
            if(set.contains(num)) {
                return true;
            }
            set.add(num);
        }

        return false;
    }
}
