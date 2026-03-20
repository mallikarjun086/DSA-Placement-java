/*
Problem: LeetCode 121 - Best Time to Buy and Sell Stock
Pattern: Greedy
Difficulty: Easy

Approach:
- Track minimum price so far
- Calculate max profit

Time Complexity: O(n)
Space Complexity: O(1)
*/

class Solution {
    public int maxProfit(int[] prices) {
        int buyPrice = prices[0];
        int profit = 0;

        for (int i = 1; i < prices.length; i++) {
            if (buyPrice > prices[i]) {
                buyPrice = prices[i];
            }

            profit = Math.max(profit, prices[i] - buyPrice);
        }

        return profit;        
    }
}
