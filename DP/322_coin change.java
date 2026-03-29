/*
Problem: LeetCode 322 - Coin Change
Pattern: Dynamic Programming (Unbounded Knapsack)
Difficulty: Medium

Approach:
- Use 1D DP array where dp[i] represents minimum coins needed to make amount i
- Initialize dp with (amount + 1) as a large value (impossible case)
- Base case: dp[0] = 0 (0 coins needed for amount 0)
- For each amount, try all coins:
    dp[i] = min(dp[i], 1 + dp[i - coin])
- If dp[amount] remains greater than amount, return -1

Time Complexity: O(n × amount)
Space Complexity: O(amount)
*/
class Solution {
    public int coinChange(int[] coins, int amount) {

        int[] dp = new int[amount + 1];

        Arrays.fill(dp, amount + 1); // large value (like infinity)
        dp[0] = 0;

        for (int i = 1; i <= amount; i++) {
            for (int coin : coins) {
                if (coin <= i) {
                    dp[i] = Math.min(dp[i], 1 + dp[i - coin]);
                }
            }
        }

        return dp[amount] > amount ? -1 : dp[amount];
    }
}
