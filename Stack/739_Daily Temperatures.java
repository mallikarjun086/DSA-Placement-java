/*
Problem: LeetCode 739 - Daily Temperatures
Pattern: Monotonic Stack
Difficulty: Medium

Approach:
- Store indices
- Compare temperatures

Time Complexity: O(n)
Space Complexity: O(n)
*/
class Solution {
    public int[] dailyTemperatures(int[] temperatures) {
        Stack<Integer>helperStack = new Stack<>();

        int n = temperatures.length;
        int[] result = new int[n];

        for(int idx= n-1; idx>=0;idx--){
            while(!helperStack.isEmpty()&&temperatures[idx]>=temperatures[helperStack.peek()]){
                helperStack.pop();
            }
            if(!helperStack.isEmpty()){
                result[idx]=helperStack.peek()-idx;
            }
            helperStack.push(idx);
        }
        return result;
    }
}
