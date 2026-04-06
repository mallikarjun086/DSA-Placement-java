/*
Problem: LeetCode 547 - Number of Provinces
Pattern: Graph (DFS / BFS)
Difficulty: Medium

Approach:
- Treat matrix as graph
- Use DFS to explore connected components
- Count number of DFS calls

Time Complexity: O(n^2)
Space Complexity: O(n)
*/
class Solution {
    private void dfs(int[][] isConnected,boolean[] vis,int curr,int n){
        for(int i=0;i<n;i++){
            if(isConnected[curr][i]==1 && ! vis[i]){
                vis[i]=true;
                dfs(isConnected,vis,i,n);
            }
        }
    }
    public int findCircleNum(int[][] isConnected) {
        int n = isConnected.length;
        boolean[] vis = new boolean[n];
        int cnt = 0;
        for(int i=0;i<n;i++){
            if(!vis[i]){
                cnt++;
                dfs(isConnected,vis,i,n);
            }
        }
        return cnt;
    }
}
