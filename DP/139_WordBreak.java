/*
Problem: LeetCode 139 - Word Break
Pattern: Dynamic Programming + HashSet
Difficulty: Medium

Approach:
- Use a HashSet for O(1) lookup of dictionary words
- dp[i] represents whether substring s[0...i-1] can be segmented
- Initialize dp[0] = true (empty string is valid)
- For each index i, check all possible previous splits j:
    If dp[j] is true AND substring(j, i) exists in dictionary
    → dp[i] = true
- Optimization:
    Limit j using max word length to reduce unnecessary checks

Time Complexity: O(n * maxLen)
Space Complexity: O(n)
*/
class Solution {
    public boolean wordBreak(String s, List<String> wordDict) {
        Set<String> wordSet = new HashSet<>(wordDict);
        int maxLen = 0;
        for(String word:wordDict){
            maxLen = Math.max(maxLen,word.length());
        }
        int n = s.length();
        boolean[] dp =new boolean[n+1];

        dp[0] = true;
        for(int i = 1; i<=n;i++)
            for(int j = i-1;j>=Math.max(0,i-maxLen);j--)
                if(dp[j] && wordSet.contains(s.substring(j,i))){
                    dp[i] = true;
                    break;
                }
        return dp[n];
    }
}
