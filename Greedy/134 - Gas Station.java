/*
Problem: LeetCode 134 - Gas Station
Pattern: Greedy
Difficulty: Medium

Approach:
- If total gas < total cost → return -1
- Traverse and track current tank
- If tank < 0 → reset start position

Time Complexity: O(n)
Space Complexity: O(1)
*/
class Solution {
    public int canCompleteCircuit(int[] gas, int[] cost) {
        int totalgas = 0;
        int totalcost = 0;
        for(int i = 0;i<gas.length;i++){
            totalgas+=gas[i];
            totalcost+=cost[i];
        }
        if(totalgas<totalcost){
            return -1;
        }
        int currentGas = 0,startIndex = 0;
        for(int i = 0;i<gas.length;i++){
            currentGas+=gas[i]-cost[i];

            if(currentGas<0){
                startIndex=i+1;
                currentGas=0;
            }
        }
        return startIndex; 

    }
}
