/*
Problem: LeetCode 207 - Course Schedule
Pattern: Graph (Topological Sort / BFS)
Difficulty: Medium

Approach:
- Build graph using adjacency list
- Maintain in-degree of each node
- Use queue to process nodes with in-degree 0
- Perform BFS (Kahn’s Algorithm)
- If all nodes are processed → no cycle

Time Complexity: O(V + E)
Space Complexity: O(V + E)
*/
class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
       List<List<Integer>> graph =new ArrayList<>();
       int[] inDegree =new int[numCourses];
       for(int i=0;i<numCourses;i++)
            graph.add(new ArrayList<>());

        for(int[] pre:prerequisites){
            graph.get(pre[1]).add(pre[0]);
            inDegree[pre[0]]++;
        }

        Queue<Integer> queue=new LinkedList<>();
        for(int i=0;i<numCourses;i++)
            if(inDegree[i]==0)
                queue.offer(i);
        int count=0;
        while(!queue.isEmpty()){
            int curr =queue.poll();
            count++;
            for(int next:graph.get(curr)){
                inDegree[next]--;
                if(inDegree[next]==0)queue.offer(next);
            }
        }
        return count == numCourses;
    }
}
