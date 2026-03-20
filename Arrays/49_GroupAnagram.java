/*
Problem: LeetCode 49 - Group Anagrams
Pattern: Hashing
Difficulty: Medium

Approach:
- Sort each string
- Use sorted string as key in hashmap

Time Complexity: O(n * k log k)
Space Complexity: O(n)
*/
class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String, List<String>> ans = new HashMap<>();

        for (String s : strs) {
            char[] chars = s.toCharArray();
            Arrays.sort(chars);
            String key = new String(chars);
            if (!ans.containsKey(key)) {
                ans.put(key, new ArrayList<>());
            }
            ans.get(key).add(s);
        }

        return new ArrayList<>(ans.values());        
    }
}
